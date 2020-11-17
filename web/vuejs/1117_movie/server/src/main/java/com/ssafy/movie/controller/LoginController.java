package com.ssafy.movie.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.movie.dto.MemberDto;
import com.ssafy.movie.service.MemberService;


@Controller
public class LoginController {
	@Autowired
	private MemberService mservice;
	
	@GetMapping("login.do")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("loginCheck.do")
	public String getCheckLogin() {
		return "loginCheck";
	}
	
	@PostMapping("login.do")
	public String login(@RequestParam Map<String, String> paramMap, HttpServletRequest request, Model model) {
		String userid = paramMap.get("userid");
		String userpwd = paramMap.get("userpwd");
		
		MemberDto member = mservice.userCheck(userid, userpwd);
		
		if(member == null) { // 존재하지 않는 유저
			return "login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginInfo", member);
		
		model.addAttribute("userid", userid);
		
		return "loginSuccess";
	}
	
	@GetMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "home";
	}
	
	@GetMapping("join.do")
	public String getJoin() {
		return "join";
	}
	
	
	@PostMapping("join.do")
	public String join(@RequestParam Map<String, String> paramMap, HttpServletResponse response, Model model) {
		String userid = paramMap.get("id");
		String nickname = paramMap.get("nick").replaceAll("\\s+", "");
		String userpwd = paramMap.get("pw");
		String userphone = paramMap.get("phone");
		
		if(mservice.checkUserid(userid)) { // id 중복 안됨
			MemberDto newMember = new MemberDto(userid, nickname, userpwd, userphone);
			mservice.join(newMember);
			
			return "home";
		}
		
//		아이디 중복된 경우 아이디 제외한 나머지 데이터 자동입력 해주기 위한 쿠키 설정
		response.setCharacterEncoding("UTF-8");
		Cookie joinNickname = new Cookie("joinNickname", nickname);
		Cookie joinPhone = new Cookie("joinPhone", userphone);
		Cookie joinPw = new Cookie("joinPw", userpwd);
		joinNickname.setMaxAge(10);
		joinPhone.setMaxAge(10);
		joinPw.setMaxAge(10);
		
		response.addCookie(joinNickname);
		response.addCookie(joinPhone);
		response.addCookie(joinPw);
//		////////////////////////////////////////////////////
		
		return "joinFail";
	}
}
