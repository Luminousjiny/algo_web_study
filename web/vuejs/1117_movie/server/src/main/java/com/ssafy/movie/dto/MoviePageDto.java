
package com.ssafy.movie.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

@ApiModel(value = "MoviePageDto : 영화게시판 페이지정보", description = "현재 페이지 정보를 나타냄.")
public class MoviePageDto {
	@ApiModelProperty(value="현재 페이지의 영화 리스트")
	private ArrayList<MovieDto> movieList;
	@ApiModelProperty(value="현재 페이지")
	private int curPage;
	private int startPage;
	private int endPage;
	private int totalPage;
	
	public MoviePageDto() {}
	public MoviePageDto(ArrayList<MovieDto> movieList, int curPage, int startPage, int endPage, int totalPage) {
		super();
		this.movieList = movieList;
		this.curPage = curPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
	}
	public ArrayList<MovieDto> getMovieList() {
		return movieList;
	}
	public void setMovieList(ArrayList<MovieDto> movieList) {
		this.movieList = movieList;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "MoviePageDto [movieList=" + movieList + ", curPage=" + curPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalPage=" + totalPage + "]";
	}
	
	
}