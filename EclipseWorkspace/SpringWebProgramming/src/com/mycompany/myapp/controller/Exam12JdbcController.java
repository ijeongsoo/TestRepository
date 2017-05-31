package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;
import com.mycompany.myapp.service.Exam12Service;

@Controller
public class Exam12JdbcController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12JdbcController.class);
	
	@Autowired
	private Exam12Service service;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/jdbc/exam01")
	public String exam01(){
		Exam12Board board = new Exam12Board();
		board.setBtitle("hi");
		board.setBcontent("hi bro!!!");
		
		service.write(board);
		return "redirect:/";
	}
	
	@RequestMapping(value="/jdbc/exam02", method=RequestMethod.GET)
	public String exame02Get(){
		return "jdbc/exam02";
	}
	
	@RequestMapping(value="/jdbc/exam02", method=RequestMethod.POST)
	public String exame02Post(Exam12Board board) throws IllegalStateException, IOException{
		board.setBoriginalfilename(board.getBattach().getOriginalFilename());
		board.setBfilecontent(board.getBattach().getContentType());
		String fileName= new Date().getTime()+"-"+board.getBoriginalfilename();
		board.setBsavedfilename(fileName);
		
		String realPath=servletContext.getRealPath("/WEB-INF/upload/");
		File file= new File(realPath+fileName);
		board.getBattach().transferTo(file);
		
		service.write(board);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.GET)
	public String exame03Get(){
		return "jdbc/exam03";
	}
	
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.POST)
	public String exame03Post(Exam12Member member) throws IllegalStateException, IOException{
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		member.setMfilecontent(member.getMattach().getContentType());
		String fileName= new Date().getTime()+"-"+member.getMoriginalfilename();
		member.setMsavedfilename(fileName);
		
		String realPath=servletContext.getRealPath("/WEB-INF/upload/");
		File file= new File(realPath+fileName);
		member.getMattach().transferTo(file);
		
		service.join(member);
		
		return "redirect:/";
	}
	
}
