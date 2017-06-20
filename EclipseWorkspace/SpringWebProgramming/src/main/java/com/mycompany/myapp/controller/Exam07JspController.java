/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.controller;

import com.mycompany.myapp.dto.Exam07Board;
import com.mycompany.myapp.dto.Exam07Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ijeongsu
 */
@Controller
@RequestMapping("/jsp")
public class Exam07JspController {
	  
	  @RequestMapping("/exam01")
	  public String exam01(){
			
			return("jsp/exam01");
	  }
	  
	  @RequestMapping("/exam02")
	  public String exam02(){
			
			return("jsp/exam02");
	  }
	  
	  @RequestMapping("/exam03")
	  public String exam03(){
			
			return("jsp/exam03");
	  }
	  
//	  @RequestMapping("/exam04")
//	  public String exam04(){
//			
//			return("jsp/exam04");
//	  }
	  
	  @RequestMapping("/exam04")
	  public String exam04(Model model){
			model.addAttribute("name2", "홍길동");
			model.addAttribute("member2", new Exam07Member("홍길동", 30));
			return("jsp/exam04");
	  }
	  
	  
	  @RequestMapping("/exam05")
	  public String exam05(Model model){
			model.addAttribute("name3", "홍길동");
			model.addAttribute("member3", new Exam07Member("홍길동",30));
			
			Exam07Board board = new Exam07Board();
			board.setBtitle("오늘은 휴가 전날");
			board.setBcontent("ggggggggg");
			board.setBwriter("이정수");
			board.setBno(1);
			board.setBdate(new Date());
			model.addAttribute("board", board);
			
			List<Exam07Board> list = new ArrayList<Exam07Board>();
			for(int i=0; i<=10; i++){
				  Exam07Board b = new Exam07Board();
				  b.setBtitle("제목"+i);
				  b.setBcontent("ggggggggg"+i);
				  b.setBwriter("이정수"+i);
				  b.setBno(i);
				  b.setBdate(new Date());
				  list.add(b);
			}
			model.addAttribute("list",list);
			return("jsp/exam05");
	  }
	  
}
