package com.example.sysecho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sysecho.entity.UserEntity;
import com.example.sysecho.properties.SysechoProperties;
import com.example.sysecho.service.UserService;

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
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userService.getAll();
		return users;
	}
}
