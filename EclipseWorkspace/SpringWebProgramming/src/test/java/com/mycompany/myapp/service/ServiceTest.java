package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.mycompany.myapp.ApplicationContextLoader;
import com.mycompany.myapp.dao.Exam12Dao;
import com.mycompany.myapp.dto.Exam12Board;


public class ServiceTest extends ApplicationContextLoader{
	@Resource(name="exam12DaoImpl3")
	private Exam12Dao dao;
	
	@Test
	public void insertTest(){
		//테스트 코드 
		Exam12Board board = new Exam12Board();
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setBwriter("글쓴이");
		board.setBpassword("12345");
		System.out.println(board.getBtitle());
		System.out.println(board.getBcontent());
		System.out.println(board.getBwriter());
		System.out.println(board.getBpassword());
		System.out.println(board.getBhitcount());
		System.out.println(board.getBoriginalfilename());
		System.out.println(board.getBsavedfilename());
		int bno = dao.boardInsert(board);
		
		Exam12Board dbBoard = dao.boardSelectByBno(bno);
		Assert.assertNotNull(dbBoard);
		
	}
	
	@Test
	public void insertWithAttachTest(){
		//테스트 코드 
		Exam12Board board = new Exam12Board();
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setBwriter("글쓴이");
		board.setBpassword("12345");
		int bno = dao.boardInsert(board);
		
		Exam12Board dbBoard = dao.boardSelectByBno(bno);
		Assert.assertNotNull(dbBoard);
		
	}
	
	
	@Test
	public void selectByPageTest(){
		//테스트 코드 
		
	}
}
