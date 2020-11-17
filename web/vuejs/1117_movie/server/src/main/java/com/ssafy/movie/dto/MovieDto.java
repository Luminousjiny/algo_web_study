package com.ssafy.movie.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MovieDto : 영화정보", description = "영화의 상세 정보를 나타낸다.")
public class MovieDto {
	@ApiModelProperty(value="영화 번호. primary key")
	private int mno;  // 영화 번호. DB에서 primary key
	@ApiModelProperty(value="영화 제목")
	private String mtitle; // 영화 제목
	@ApiModelProperty(value="영화 줄거리")
	private String mcontent;  // 영화 줄거리
	@ApiModelProperty(value="영화 감독")
	private String mdirector; // 영화 감독
	@ApiModelProperty(value="영화 개봉일")
	private String mdate; // 개봉일
	
	public MovieDto() {}

	public MovieDto(String mtitle, String mcontent, String mdirector, String mdate) {
		super();
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mdirector = mdirector;
		this.mdate = mdate;
	}

	public MovieDto(int mno, String mtitle, String mcontent, String mdirector, String mdate) {
		super();
		this.mno = mno;
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mdirector = mdirector;
		this.mdate = mdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getMdirector() {
		return mdirector;
	}

	public void setMdirector(String mdirector) {
		this.mdirector = mdirector;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "MovieDto [mno=" + mno + ", mtitle=" + mtitle + ", mcontent=" + mcontent + ", mdirector=" + mdirector
				+ ", mdate=" + mdate + "]";
	}
	
	
}