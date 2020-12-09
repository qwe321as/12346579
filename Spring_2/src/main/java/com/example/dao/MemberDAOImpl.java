package com.example.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.example.mapper.memberMapper";
	
	@Override
	public List<MemberVO> selectMember() throws Exception {

		return sqlSession.selectList(Namespace+".selectMember");
	}
	@Override
	public MemberVO selectOneMember(String id) throws Exception {
		
		return sqlSession.selectOne(Namespace+".selectOneMember",id);
	}
	@Override
	public int selectCount(String id) throws Exception {
		
		return sqlSession.selectOne(Namespace+".selectCount",id);
	}
	@Override
	public int selectCountPW(String pw) throws Exception {
		
		return sqlSession.selectOne(Namespace+".selectCountPW",pw);
	}

}
