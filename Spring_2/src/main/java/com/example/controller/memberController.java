package com.example.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.MemberVO;
import com.example.service.MemberService;

@Controller
public class memberController {

	@Inject
	private MemberService service;
	
	
	@GetMapping(value = "/memberlist")
	@ResponseBody 
	public List<MemberVO> testResponseBody() throws Exception {

		List<MemberVO> memberList = service.selectMember();


		return memberList;
	}
	
	

}
