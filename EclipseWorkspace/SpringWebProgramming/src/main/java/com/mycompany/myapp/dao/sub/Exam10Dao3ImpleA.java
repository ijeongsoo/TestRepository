/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.dao.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;

/**
 *
 * @author ijeongsu
 */
@Component("subExam10Dao3ImpleA")
public class Exam10Dao3ImpleA implements Exam10Dao3{
	public static final Logger LOGGER=LoggerFactory.getLogger(Exam10Dao3ImpleA.class);
	public void insert() {
		LOGGER.info("회원가입");
	}

	public void select() {
		LOGGER.info("회원검색");
	}

}