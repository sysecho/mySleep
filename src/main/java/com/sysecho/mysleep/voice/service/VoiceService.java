package com.sysecho.mysleep.voice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysecho.mysleep.voice.entity.Voice;
import com.sysecho.mysleep.voice.mapper.VoiceMapper;

@Service
public class VoiceService {

	@Autowired
	private VoiceMapper mapper;
	
	public int deleteByPrimaryKey(Integer id){
		return this.deleteByPrimaryKey(id);
	}
	
	public int insert(Voice record){
		return this.mapper.insert(record);
	}
	
	public int updateByPrimaryKeySelective(Voice record){
		return this.updateByPrimaryKeySelective(record);
	}
	
	public Voice selectByPrimaryKey(Integer id){
		return this.mapper.selectByPrimaryKey(id);
	}
}
