package com.ssafy.movie.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReviewDto : 리뷰정보", description = "영화에 달린 리뷰 나타냄")
public class ReviewDto {
	@ApiModelProperty(value="리뷰 번호. primary key")
	private int rno; // 리뷰 번호. DB에서 primary key
	@ApiModelProperty(value="리뷰 단 영화 번호. foreign key")
	private int mno; // 리뷰 단 영화 번호. foreign key
	@ApiModelProperty(value="리뷰 작성자")
	private String rwriter; // 리뷰 작성자
	@ApiModelProperty(value="리뷰 내용")
	private String rcontent; // 리뷰 내용
	@ApiModelProperty(value="리뷰 작성일")
	private String rdate; // 리뷰 작성일
	
	public ReviewDto() {}

	public ReviewDto(int mno, String rwriter, String rcontent, String rdate) {
		super();
		this.mno = mno;
		this.rwriter = rwriter;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}

	public ReviewDto(int rno, int mno, String rwriter, String rcontent, String rdate) {
		super();
		this.rno = rno;
		this.mno = mno;
		this.rwriter = rwriter;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "ReviewDto [rno=" + rno + ", mno=" + mno + ", rwriter=" + rwriter + ", rcontent=" + rcontent + ", rdate="
				+ rdate + "]";
	}
	
	
}