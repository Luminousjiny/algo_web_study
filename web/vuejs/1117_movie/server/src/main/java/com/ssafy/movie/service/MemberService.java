package com.ssafy.movie.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.movie.dto.MemberDto;
import com.ssafy.movie.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private SqlSession sqlSession;
	
	public MemberDto userCheck(String userid, String userpwd) {
		return sqlSession.getMapper(MemberMapper.class).selectUseridAndUserpwd(userid, userpwd);
	}
	
	public int join(MemberDto member) {
		return sqlSession.getMapper(MemberMapper.class).insertUser(member);
	}
	
	public boolean checkUserid(String userid) {
		if(sqlSession.getMapper(MemberMapper.class).selectUserid(userid) != null) {
			// 해당 아이디 사용하는 유저 이미 존재
			return false;
		}
		return true;
	}
}
