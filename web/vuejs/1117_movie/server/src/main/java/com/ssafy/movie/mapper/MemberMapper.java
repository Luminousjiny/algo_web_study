package com.ssafy.movie.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssafy.movie.dto.MemberDto;

public interface MemberMapper {
	public MemberDto selectUseridAndUserpwd(@Param("userid") String userid, @Param("userpwd") String userpwd);
	public MemberDto selectUserid(@Param("userid") String userid);
	public int insertUser(MemberDto member);
}
