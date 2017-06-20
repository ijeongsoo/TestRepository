package com.mycompany.myapp.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.myapp.dto.Exam13Member;

@Controller
@SessionAttributes({"name1", "name2", "member"})
public class Exam13CookieAndSessionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam13CookieAndSessionController.class);
	
	@RequestMapping("/cookie/exam01")
	public String exam01(HttpServletResponse response) throws Exception{
		//쿠키 생성
		Cookie cookie1 = new Cookie("name1", "ijeongsu");
		String name2="이정수";
		name2=URLEncoder.encode(name2, "UTF-8");
		Cookie cookie2 = new Cookie("name2", name2);
		cookie2.setMaxAge(30*24*60*60);
		//쿠기를 응답 헤더에 추가
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "redirect:/";
	}
	
//	@RequestMapping("/cookie/exam02")
//	public String exam02(HttpServletRequest request, Model model) throws Exception{
//		Cookie[] cookies=request.getCookies();
//		String name1 = null;
//		String name2 = null;
//		for(Cookie cookie : cookies){
//			if(cookie.getName().equals("name1")){
//				name1=cookie.getValue();
//			}else if(cookie.getName().equals("name2")){
//				name2=cookie.getValue();
//				name2=URLDecoder.decode(name2, "UTF-8");
//			}
//		}
//		model.addAttribute("name1", name1);
//		model.addAttribute("name2", name2);
//		
//		return "cookie/exam02";
//	}
	
	@RequestMapping("/cookie/exam02")
	public String exam02(@CookieValue(defaultValue="") String name1,@CookieValue(defaultValue="") String name2, Model model) throws Exception{
		
		model.addAttribute("name1", name1);
		model.addAttribute("name2", name2);
		
		return "cookie/exam02";
	}
	
	@RequestMapping("/cookie/exam03")
	public String exam03(HttpServletResponse response) throws Exception{
		Cookie cookie1 = new Cookie("name1", "");
		Cookie cookie2 = new Cookie("name2", "");
		
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "redirect:/";
	}
	
//	@RequestMapping("/session/exam04")
//	public String exam04(HttpSession session){
//		session.setAttribute("name1", "hongkildong");
//		session.setAttribute("name2", "홍길동");
//		Exam13Member member = new Exam13Member();
//		member.setMname("스프링");
//		session.setAttribute("member", member);
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/session/exam05")
//	public String exam05(HttpSession session){
//		String name1 = (String)session.getAttribute("name1");
//		String name2 = (String)session.getAttribute("name2");
//		Exam13Member member = (Exam13Member)session.getAttribute("member");
//		
//		LOGGER.debug(name1);
//		LOGGER.debug(name2);
//		
//		return "session/exam05";
//	}
	
	@RequestMapping("/session/exam04")
	public String exam04(Model model){
		model.addAttribute("name1", "honggildong");
		model.addAttribute("name2", "홍길동");
		Exam13Member member = new Exam13Member();
		member.setMname("스프링");
		model.addAttribute("member", member);
		return "redirect:/";
	}
	
	@RequestMapping("/session/exam05")
	public String exam05(@ModelAttribute String name1, @ModelAttribute String name2, @ModelAttribute Exam13Member member){
	
		return "session/exam05";
	}
	
//	@RequestMapping("/session/exam06")
//	public String exam06(HttpSession session){
//		//세션에서 삭제해도 Model에는 남아 있을 수 있다. 
//		//@SessionAttribute 대신 httpsession 이용할 경우에 사용
//		
//		session.removeAttribute("name1");
//		session.removeAttribute("name2");
//		session.removeAttribute("member");
//		
//		return "redirect:/";
//	}
	
	@RequestMapping("/session/exam06")
	public String exam06(SessionStatus sessionStatus){
		//세션에 있는 모든 정보를 삭제 
		//@SessionAttributes를 사용할 경우 이용 
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
	
}
