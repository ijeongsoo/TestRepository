/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.Exam10Dao2;

/**
 *
 * @author ijeongsu
 */

public class Exam10Service4eImpl implements Exam10Service4 {
	private Exam10Dao2 exam10Dao;

	public void setExam10Dao(Exam10Dao2 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}

	@Override
	public void join() {
		System.out.println("exam10service4-imple-join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("exam10service4-imple-login");
		exam10Dao.select();
	}

}
