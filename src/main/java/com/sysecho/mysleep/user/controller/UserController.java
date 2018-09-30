package com.sysecho.mysleep.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;
import com.sysecho.mysleep.enums.UserSexEnum;
import com.sysecho.mysleep.properties.MySleepProperties;
import com.sysecho.mysleep.user.entity.UserEntity;
import com.sysecho.mysleep.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private MySleepProperties mySleepProperties;
	
	@Autowired
    StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String hello(){
		stringRedisTemplate.opsForValue().set("xiaofei", "小飞机");
		return stringRedisTemplate.opsForValue().get("xiaofei") + mySleepProperties.getTitle()+mySleepProperties.getDescription();
	}
	
	@RequestMapping(value="/users")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userService.getAll();
		return users;
	}
	
	@RequestMapping(value="/page")
	public Page<UserEntity> pageUsers() {
		Page<UserEntity> pages = userService.findByPage(1, 10);
		return pages;
	}
	
	
	
	@RequestMapping("/add")
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

}
