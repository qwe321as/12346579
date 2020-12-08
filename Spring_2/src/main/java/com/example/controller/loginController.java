package com.example.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.MemberService;

@Controller
public class loginController {

	@Inject
	private MemberService service;
	
	@GetMapping(value = "/login/{id}")
	@ResponseBody 
	public String testResponse(String id) throws Exception {
		String a = "";
		int cnt = service.selectCount(id);
		if (cnt!=1) {
			a="no";
			
		}else {
			a="yse";
		}
		
		return a;
	}


}
