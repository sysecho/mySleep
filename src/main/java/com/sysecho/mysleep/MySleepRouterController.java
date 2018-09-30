package com.sysecho.mysleep;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MySleepRouterController {
	

	@GetMapping("/voiceManager")
	public String voiceManager(){
		return "/voice/voiceManager.html";
	}
	
	@GetMapping("/index")
	public Object index(){
		return "/upload.html";
	}
	
}
