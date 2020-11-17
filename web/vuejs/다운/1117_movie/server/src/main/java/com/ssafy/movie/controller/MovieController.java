package com.ssafy.movie.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ssafy.movie.dto.MovieDto;
import com.ssafy.movie.dto.MoviePageDto;
import com.ssafy.movie.service.MovieService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "Movie")
public class MovieController {
	@Autowired
	private MovieService mservice;

	@ApiOperation(value="현재 페이지의 모든 영화 목록을 반환한다", response = MoviePageDto.class)
	@GetMapping("/movies")
	public MoviePageDto getMovieList(@ApiParam(value="페이지 번호", required = true, example="1") @RequestParam(value = "page", defaultValue = "1") int page) {
		return mservice.makePage(page);
	}
	
	@ApiOperation(value = "mno에 해당하는 영화의 상세 정보 반환", response = MovieDto.class)
	@GetMapping("/movies/{mno}")
	public MovieDto getMovie(@PathVariable("mno") int mno) {
		return mservice.getMovie(mno);
	}

	@ApiOperation(value = "영화 정보 등록 성공시 success 실패시 fail 반환")
	@PostMapping("/movies")
	public String addMovie(@RequestBody MovieDto movie) {
		String result = "";
		if(mservice.registMovie(movie)) {
			result = "success";
		}
		else {
			result = "fail";
		}
		return result;
	}

	@ApiOperation(value = "mno에 해당하는 영화 정보 수정. 성공시 success 실패시 fail 반환")
	@PutMapping("/movies/{mno}")
	public String modifyMovie(@RequestBody MovieDto movie, @PathVariable("mno") int mno) {
		movie.setMno(mno);
		String result = "";
		if(mservice.updateMovie(movie)) {
			result = "success";
		} else {
			result = "fail";
		}
		return result;
	}

	@ApiOperation(value = "mno에 해당하는 영화 삭제. 성공시 success 실패시 fail 반환")
	@DeleteMapping("/movies/{mno}")
	public String deleteMovie(@PathVariable("mno") int mno) {
		String result = "";
		if(mservice.delete(mno)) {
			result = "success";
		} else {
			result = "fail";
		}
		return result;
	}
}

