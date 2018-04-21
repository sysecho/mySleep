package com.example.sysecho.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sysecho.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}
