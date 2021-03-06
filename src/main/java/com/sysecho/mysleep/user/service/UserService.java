package com.sysecho.mysleep.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sysecho.mysleep.user.entity.UserEntity;
import com.sysecho.mysleep.user.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<UserEntity> getAll(){
		return this.userMapper.getAll();
	}
	
	public Page<UserEntity> findByPage(int pageNo, int pageSize){
		PageHelper.offsetPage(pageNo, pageSize);
		return this.userMapper.getAll();
	}
	
	
	public UserEntity getOne(Long id){
		return this.getOne(id);
	}

	public void insert(UserEntity user){
		this.userMapper.insert(user);
	}

	public void update(UserEntity user){
		this.userMapper.update(user);
	}

	public void delete(Long id){
		this.userMapper.delete(id);
	}
	
	public void deleteAll(){
		this.userMapper.deleteAll();
	}
	
}

