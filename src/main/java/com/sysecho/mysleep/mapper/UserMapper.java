package com.sysecho.mysleep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.sysecho.mysleep.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	Page<UserEntity> getAll();
	
	List<UserEntity> findByPage();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);
	
	void deleteAll();

}
