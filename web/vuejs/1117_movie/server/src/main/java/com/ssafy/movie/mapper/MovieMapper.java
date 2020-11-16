package com.ssafy.movie.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ssafy.movie.dto.MovieDto;

public interface MovieMapper {
	public int selectTotalCount();
	public ArrayList<MovieDto> selectPage(@Param("startRow") int startRow, @Param("cnt") int cnt);
	public MovieDto selectOne(@Param("mno") int mno);
	public MovieDto selectMovie(MovieDto movie);
	public int insert(MovieDto movie);
	public int updateMovie(MovieDto movie);
	public int delete(@Param("mno") int mno);
}
