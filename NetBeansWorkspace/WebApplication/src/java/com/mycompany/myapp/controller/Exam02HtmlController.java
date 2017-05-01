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
public class Exam02HtmlController {
	  @RequestMapping("/html/exam01")
	  public String html(){
			return "html/exam01";
	  }
}
