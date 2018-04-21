package com.example.sysecho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sysecho.entity.UserEntity;
import com.example.sysecho.enums.UserSexEnum;
import com.example.sysecho.properties.SysechoProperties;
import com.example.sysecho.service.UserService;
import com.github.pagehelper.Page;

@RestController
public class UserController {

	@Autowired
	private SysechoProperties sysechoProperties;
	
	@Autowired
    StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String index(){
		stringRedisTemplate.opsForValue().set("xiaofei", "小飞机");
		return stringRedisTemplate.opsForValue().get("xiaofei") + sysechoProperties.getTitle()+sysechoProperties.getDescription();
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
