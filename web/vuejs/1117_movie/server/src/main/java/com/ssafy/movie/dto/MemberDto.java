package com.ssafy.movie.dto;

public class MemberDto {
	private String userid;
	private String nickname;
	private String userpwd;
	private String userphone;
	private int role;

	public MemberDto() {
	}

	public MemberDto(String userid, String nickname, String userpwd, String userphone) {
		this.userid = userid;
		this.nickname = nickname;
		this.userpwd = userpwd;
		this.userphone = userphone;
	}

	public MemberDto(String userid, String nickname, String userpwd, String userphone, int role) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.userpwd = userpwd;
		this.userphone = userphone;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", nickname=" + nickname + ", userpwd=" + userpwd + ", userphone="
				+ userphone + ", role=" + role + "]";
	}

}