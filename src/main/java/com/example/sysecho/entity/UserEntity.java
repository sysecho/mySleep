package com.example.sysecho.entity;

import java.io.Serializable;

import com.example.sysecho.enums.UserSexEnum;

import lombok.Data;

@Data
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;
}