/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.Exam10Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ijeongsu
 */
@Component
public class Exam10Service1Impl implements Exam10Service1 {
	@Autowired
	Exam10Dao1 exam10Dao;

	@Override
	public void join() {
		System.out.println("exmam10service1-imple-join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("exam10service1-imple-login");
		exam10Dao.insert();
	}

}
