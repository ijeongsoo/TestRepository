package com.mycompany.myapp.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.ApplicationContextLoader;


public class Exam12DaoImpl3Test extends ApplicationContextLoader{
	
	@Autowired
	private Exam15Dao dao;
	
	@Test
	public void insertTest(){
		Assert.assertNotNull(dao);
		
	}
	
	@Test
	public void selectTest(){
		//테스트 코드 
	}
}
