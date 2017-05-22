/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.Exam10Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ijeongsu
 */
@Component
public class Exam10ServiceImpl implements Exam10Service{
	@Autowired
	Exam10Dao exam10Dao;
	@Override
	public void join() {
		System.out.println("join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("login");
		exam10Dao.insert();
	}
	
}
