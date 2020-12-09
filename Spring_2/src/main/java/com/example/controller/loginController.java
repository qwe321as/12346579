package com.example.controller;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MemberVO;
import com.example.service.MemberService;
import com.mysql.cj.xdevapi.JsonParser;

@RestController 
public class loginController {

	@Inject
	private MemberService service;
	
	   @RequestMapping(value="/login", headers = "Accept=application/json", method= RequestMethod.POST)
	   public String testResponse(@RequestBody HashMap<String, HashMap<String, String>> requestData) throws Exception {
	      String a = "";
	      HashMap<String, String> memberVO = requestData.get("MemberVO");
	      String id = memberVO.get("id");
	      String pw = memberVO.get("pw");
	      int cnt = service.selectCount(id);
	      int cnt1 =service.selectCountPW(pw);
	      int b = cnt+cnt1;
	      if (b==2) {
	         a="yes";

	      }else if (b==1) {
	         a="one yes";
	      } else {
	         a="no";
	      } 

	      return a;
	   }
	
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
	public List<MemberVO> testResponseBody() throws Exception {
		List<MemberVO> memberList = service.selectMember();
		return memberList;
	}
	
	@RequestMapping(value = "/memberlist", method = RequestMethod.POST)
	public MemberVO testBody(@RequestBody HashMap<String, HashMap<String, String>> requestData) throws Exception {
	      HashMap<String, String> memberVO = requestData.get("MemberVO");
	      String id = memberVO.get("id");
		MemberVO vo = service.selectOneMember(id);
		
		return vo;
	}
	
}
