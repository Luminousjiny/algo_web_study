package com.ssafy.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.movie.dto.ReviewDto;

public interface ReviewMapper {
	public List<ReviewDto> selectReviewList(@Param("mno") int mno);
	public int insertReview(ReviewDto dto);
	public int updateReview(ReviewDto dto);
	public int deleteReview(@Param("rno") int rno);
}
