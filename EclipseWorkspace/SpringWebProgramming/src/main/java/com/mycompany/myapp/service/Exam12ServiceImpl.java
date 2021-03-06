package com.mycompany.myapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam12Dao;
import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12ServiceImpl implements Exam12Service{
	@Resource(name="exam12DaoImpl")
	private Exam12Dao dao;
	
	@Override
	public void boardWrite(Exam12Board board) {
		dao.boardInsert(board);
	}

	
	
	@Override
	public List<Exam12Board> boardListAll() {		
		return dao.boardSelectAll();
	}
	
	@Override
	public List<Exam12Board> boardListPage(int pageNo, int rowsPerPage) {
		return dao.boardSelectPage(pageNo, rowsPerPage);
	}
	
	@Override
	public int boardTotalRows() {
		return dao.boardCountAll();
	}
	
	@Override
	public Exam12Board getBoard(int bno) {
		Exam12Board board = dao.boardSelectByBno(bno);
		board.setBhitcount(board.getBhitcount()+1);
		dao.boardUpdateBhitcount(bno, board.getBhitcount());
		return board;
		
	}
	
	@Override
	public String boardCheckBpassword(int bno, String bpassword) {
		String result="fail";
		Exam12Board board =dao.boardSelectByBno(bno);
		
		if(board.getBpassword().equals(bpassword)){
			result = "success";
		}
		return result;
	}
	
	
	@Override
	public void boardUpdate(Exam12Board board) {
		dao.boardUpdate(board);
		
	}
	
	@Override
	public void boardDelete(int bno) {
		dao.boardDelete(bno);
	}
	
	///////////////////////////////////////////////////
	
	@Override
	public void memberJoin(Exam12Member member) {
		dao.memberInsert(member);
	}
	
	@Override
	public List<Exam12Member> memberListPage(int pageNo, int rowsPerPage) {
		return dao.memberSelectPage(pageNo, rowsPerPage);
	}
	
	
	@Override
	public int memberTotalRows() {
		return dao.memberCountAll();
	}
	
	@Override
	public Exam12Member getMember(String mid) {
		Exam12Member member = dao.memberSelectByMid(mid);
		return member;
		
	}
	
	@Override
	public String memberCheckMpassword(String mid, String mpassword) {
		String result="fail";
		Exam12Member member =dao.memberSelectByMid(mid);
		System.out.println(member.getMpasswd());
		if(member.getMpasswd().equals(mpassword)){
			result = "success";
		}
		return result;
	}
	
	@Override
	public void memberUpdate(Exam12Member member) {
		dao.memberUpdate(member);
	}
	
	@Override
	public void memberDelete(String mid) {
		dao.memberDelete(mid);
	}

}
