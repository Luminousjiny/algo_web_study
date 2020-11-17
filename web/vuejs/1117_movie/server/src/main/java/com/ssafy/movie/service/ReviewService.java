package com.ssafy.movie.service;

import java.util.List;

import com.ssafy.movie.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.movie.dto.ReviewDto;
import com.ssafy.movie.mapper.ReviewMapper;

@Service
public class ReviewService {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReviewDto> getReviewList(int mno){
		return sqlSession.getMapper(ReviewMapper.class).selectReviewList(mno);
	}
	
	public boolean writeReview(ReviewDto dto) {
		if(sqlSession.getMapper(MemberMapper.class).selectUserid(dto.getRwriter()) == null)
			return false;
		return sqlSession.getMapper(ReviewMapper.class).insertReview(dto) == 1;
	}

	public boolean updateReview(ReviewDto dto){
		return sqlSession.getMapper(ReviewMapper.class).updateReview(dto) == 1;
	}

	public boolean deleteReview(int rno){
		return sqlSession.getMapper(ReviewMapper.class).deleteReview(rno) == 1;
	}
}
