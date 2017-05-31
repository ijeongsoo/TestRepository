/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author ijeongsu
 */
@Component
public class Exam10Dao3ImpleB implements Exam10Dao3{
	public static final Logger LOGGER=LoggerFactory.getLogger(Exam10Dao3ImpleB.class);
	public void insert() {
		LOGGER.info("회원가입");
	}

	public void select() {
		LOGGER.info("회원검색");
	}

}
