/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;

/**
 *
 * @author ijeongsu
 */
@Component
public class Exam10Service6eImpl implements Exam10Service6 {
	//@Autowired- type을 기준으로   
	@Resource(name="exam10Dao3ImpleA")
	private Exam10Dao3 exam10Dao;

	@Override
	public void join() {
		System.out.println("exam10service6-imple-join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("exam10service6-imple-login");
		exam10Dao.select();
	}

}
