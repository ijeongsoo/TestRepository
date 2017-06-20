/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ijeongsu
 */
@Controller
@RequestMapping("/javascript")
public class Exam04JavascriptController {
	  @RequestMapping("/exam01")
	  public String javascriptExam01(){
			return "javascript/exam01";
	  }
	  
	  @RequestMapping("/exam02")
	  public String javascriptExam02(){
			return "javascript/exam02";
	  }
	  
	  @RequestMapping("/exam03")
	  public String javascriptExam03(){
			return "javascript/exam03";
	  }
	  
	  @RequestMapping("/exam04")
	  public String javascriptExam04(){
			return "javascript/exam04";
	  }
	  
	  @RequestMapping("/exam05")
	  public String javascriptExam05(){
			return "javascript/exam05";
	  }
	  
	  @RequestMapping("/exam06")
	  public String javascriptExam06(){
			return "javascript/exam06";
	  }
	  
	  @RequestMapping("/exam07")
	  public String javascriptExam07(){
			return "javascript/exam07";
	  }
	  
	  @RequestMapping("/exam08")
	  public String javascriptExam08(){
			return "javascript/exam08";
	  }
	  
	  @RequestMapping("/exam09")
	  public String javascriptExam09(){
			return "javascript/exam09";
	  }
	  
	  @RequestMapping("/exam10")
	  public String javascriptExam10(){
			return "javascript/exam10";
	  }
	  
	  @RequestMapping("/exam11")
	  public String javascriptExam11(){
			return "javascript/exam11";
	  }
	  
}
