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
@RequestMapping("/css")
public class Exam03CssController {
	  @RequestMapping("/exam01")
	  public String cssExam01(){
			return "css/exam01";
	  }
	  
	  @RequestMapping("/exam02")
	  public String cssExam02(){
			return "css/exam02";
	  }
	  
	  @RequestMapping("/exam03")
	  public String cssExam03(){
			return "css/exam03";
	  }
}
