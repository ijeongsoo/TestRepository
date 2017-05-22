/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.controller;

import com.mycompany.myapp.service.Exam10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ijeongsu
 */
@Controller
public class Exam10DIController {
	@Autowired
	Exam10Service exam10Service;
	
	@RequestMapping("/di/exam01")
	public String exam01(){
		System.out.println("exam01");
		exam10Service.join();
		return "di/exam01";
	}
	
	@RequestMapping("/di/exam02")
	public String exam02(){
		System.out.println("exam02");
		exam10Service.login();
		return "di/exam02";
	}
}
