package com.sysecho.mysleep.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.Page;
import com.sysecho.mysleep.enums.UserSexEnum;
import com.sysecho.mysleep.properties.MySleepProperties;
import com.sysecho.mysleep.user.entity.UserEntity;
import com.sysecho.mysleep.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private MySleepProperties mySleepProperties;
	
	@Autowired
    StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private GridFsTemplate gridFsTemplate;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		stringRedisTemplate.opsForValue().set("xiaofei", "小飞机");
		return stringRedisTemplate.opsForValue().get("xiaofei") + mySleepProperties.getTitle()+mySleepProperties.getDescription();
	}
	
	@RequestMapping(value="/users")
	@ResponseBody
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userService.getAll();
		return users;
	}
	
	@RequestMapping(value="/page")
	@ResponseBody
	public Page<UserEntity> pageUsers() {
		Page<UserEntity> pages = userService.findByPage(1, 10);
		return pages;
	}
	
	
	
	@RequestMapping("/add")
	@ResponseBody
	public Object addUses(){
		UserEntity user = null;
		this.userService.deleteAll();
		for (int i = 0; i < 100; i++) {
			user = new UserEntity();
			user.setUserName("AAA"+i);
			user.setPassWord("PASSWORD"+i);
			user.setNickName("中文昵称"+i);
			if(i%2==0){
				user.setUserSex(UserSexEnum.MAN);
			}else{
				user.setUserSex(UserSexEnum.WOMAN);
			}
			this.userService.insert(user);
		}
		return userService.getAll();
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public Object upload(@RequestParam("file")MultipartFile file) throws IOException{
		Map<String,Object> reMap = new HashMap<String,Object>();
		if (null == file || file.getSize() > 0) {
			ObjectId store = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
			return reMap.put("data", store);
		}else{
			return reMap.put("msg", "文件不能为空！");
		}
	}
	
	@GetMapping("/index")
	public Object index(){
		return "/upload.html";
	}
	

}
