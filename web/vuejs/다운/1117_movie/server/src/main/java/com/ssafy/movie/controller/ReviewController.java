package com.ssafy.movie.controller;

import java.util.List;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ssafy.movie.dto.ReviewDto;
import com.ssafy.movie.service.ReviewService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "Review")
public class ReviewController {
	@Autowired
	private ReviewService rservice;

	@ApiOperation(value = "mno에 해당하는 영화 정보에 달린 댓글 목록 가져옴", response = List.class)
	@GetMapping("/reviews/{mno}")
	public List<ReviewDto> getReview(@PathVariable("mno") int mno) {
		return rservice.getReviewList(mno);
	}

	@ApiOperation(value = "mno에 해당하는 영화 정보에 댓글 등록. 성공시 success 실패시 fail 반환")
	@PostMapping("/reviews/{mno}")
	public String addReview(@RequestBody ReviewDto dto, @PathVariable("mno") int mno) {
		dto.setMno(mno);
		if(rservice.writeReview(dto))
			return "success";
		else
			return "fail";
	}

	@ApiOperation(value = "rno에 해당하는 댓글 정보 수정. 성공시 success 실패시 fail 반환")
	@PutMapping("/reviews/{rno}")
	public String updateReview(@RequestBody ReviewDto dto, @PathVariable("rno") int rno){
		dto.setRno(rno);
		if(rservice.updateReview(dto)){
			return "success";
		} else {
			return "fail";
		}
	}

	@ApiOperation(value = "rno에 해당하는 댓글 정보 삭제. 성공시 success 실패시 fail 반환")
	@DeleteMapping("/reviews/{rno}")
	public String deleteReview(@PathVariable("rno") int rno){
		if(rservice.deleteReview(rno)){
			return "success";
		} else {
			return "fail";
		}
	}
}
