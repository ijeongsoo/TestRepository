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

public class Exam10Service5eImpl implements Exam10Service5 {
	private Exam10Dao2 exam10Dao;

	public Exam10Service5eImpl(Exam10Dao2 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}

	@Override
	public void join() {
		System.out.println("exam10service5-imple-join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("exam10service5-imple-login");
		exam10Dao.select();
	}

}
