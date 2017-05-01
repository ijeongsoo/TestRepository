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
@RequestMapping("/bootstrap")
public class Exam05BootstrapController {
	  @RequestMapping("/exam01")
	  public String bootstrapExam01(){
			return "bootstrap/exam01";
	  }
	  
	  @RequestMapping("/exam02")
	  public String bootstrapExam02(){
			return "bootstrap/exam02";
	  }
	  
	  @RequestMapping("/exam03")
	  public String bootstrapExam03(){
			return "bootstrap/exam03";
	  }
}
