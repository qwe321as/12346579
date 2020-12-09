package com.example.dao;

import java.util.List;

import com.example.dto.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> selectMember() throws Exception;

	public int selectCount(String id) throws Exception;
	
	public int selectCountPW(String pw) throws Exception;

	public MemberVO selectOneMember(String id) throws Exception;

	
}
