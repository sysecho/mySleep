package com.sysecho.mysleep.voice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("voice")
public class VoiceController {

	@GetMapping("/voiceManager")
	public String voiceManager(){
		return "/voice/voiceManager.html";
	}
}
