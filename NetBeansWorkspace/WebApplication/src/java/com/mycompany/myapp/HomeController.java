
package com.mycompany.myapp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	  @RequestMapping("/")
	  public String home(){
			System.out.println("home()");
			return "home";
	  }
	  
	  @RequestMapping("/home")
	  public String html(){
			return "html";
	  }
	  @RequestMapping("/css/exam01")
	  public String cssExam01(){
			return "css/exam01";
	  }
}
