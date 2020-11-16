package com.ssafy.movie.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.movie.dto.MovieDto;
import com.ssafy.movie.dto.MoviePageDto;
import com.ssafy.movie.mapper.MovieMapper;

@Service
public class MovieService {
	@Autowired
	private SqlSession sqlSession;
	
	public static final int COUNT_PER_PAGE = 10;
	
	public MoviePageDto makePage(int curPage) {
		int totalCnt = sqlSession.getMapper(MovieMapper.class).selectTotalCount();
		int totalPageCnt = totalCnt / COUNT_PER_PAGE; // 총 필요한 페이지수 계산(다음, 이전 링크 관련)
		if(totalCnt%COUNT_PER_PAGE>0) 
			totalPageCnt++;
		
		int startPage = (curPage-1)/10*10+1;
		int endPage = startPage+9;
		
		if(totalPageCnt<endPage) // 마지막 페이지가 15이니까 20으로 계산하면 안댐.
			endPage = totalPageCnt;
		
		int startRow = (curPage-1)*10; // 현재 페이지에 보여질 글 조회
		ArrayList<MovieDto> movieList = sqlSession.getMapper(MovieMapper.class).selectPage(startRow, COUNT_PER_PAGE);
		
		return new MoviePageDto(movieList, curPage, startPage, endPage, totalPageCnt);
	}
	
	public MovieDto getMovie(int mno) {
		return sqlSession.getMapper(MovieMapper.class).selectOne(mno);
	}
	
	public boolean registMovie(MovieDto movie) {
		// 해당 제목, 감독의 영화 이미 등록되어 있으면 등록 실패
		if(sqlSession.getMapper(MovieMapper.class).selectMovie(movie) != null)
			return false;

		return sqlSession.getMapper(MovieMapper.class).insert(movie) == 1;
	}
	
	public boolean delete(int mno) {
		return sqlSession.getMapper(MovieMapper.class).delete(mno) == 1;
	}
	
	public boolean updateMovie(MovieDto movie) {
		return sqlSession.getMapper(MovieMapper.class).updateMovie(movie) == 1;
	}
}
