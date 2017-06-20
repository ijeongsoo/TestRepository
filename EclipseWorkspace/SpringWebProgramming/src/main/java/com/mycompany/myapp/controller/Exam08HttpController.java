/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ijeongsu
 */
@Controller
@RequestMapping("/http")
public class Exam08HttpController {
	@RequestMapping(value="/exam01",method=RequestMethod.GET)
	public String exam01Get(){
		System.out.println("exam01Get()...");
		return "http/exam01";
	}
	@RequestMapping(value="/exam01",method=RequestMethod.POST)
	public String exam01Post(){
		System.out.println("exam01Post()...");
		return "http/exam01";
	}
	
	@RequestMapping("/exam02")
	public String exam02(HttpServletRequest request){
		String method = request.getMethod();
		String uri=request.getRequestURI();
		String queryString=request.getQueryString();
		String type=request.getParameter("type");
		int bno=Integer.parseInt(request.getParameter("bno"));
		request.setAttribute("method", method);
		request.setAttribute("uri", uri);
		request.setAttribute("queryString", queryString);
		return "http/exam02";
	}
	
	
	@RequestMapping("/exam03")
	public String exam03(Model model, String type, int bno, String[] hobby,@RequestHeader("User-Agent") String userAgent){
		model.addAttribute("type",type);
		model.addAttribute("bno",bno);
		model.addAttribute("hobby", hobby);
		model.addAttribute("userAgent", userAgent);
		return "http/exam02";
	}
}
