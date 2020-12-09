package com.example.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> selectMember() throws Exception {

		return dao.selectMember();
	}

	@Override
	public MemberVO selectOneMember(String id) throws Exception {
		
		return dao.selectOneMember(id);
	}
	
	@Override
	public int selectCount(String id) throws Exception {
		return dao.selectCount(id);
	}
	
	@Override
	public int selectCountPW(String pw) throws Exception {
		return dao.selectCountPW(pw);
	}

}
