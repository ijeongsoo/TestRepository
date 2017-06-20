package com.jsCorp.photoboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsCorp.photoboard.dao.Dao;
import com.jsCorp.photoboard.dto.Board;
import com.jsCorp.photoboard.dto.Member;

@Component
public class ServiceImpl implements Service{
	
	@Autowired
	private Dao dao;
	
	@Override
	public int joinCheckID(String mid) {
		// TODO Auto-generated method stub
		int result=0;
		int count =dao.memberExistSelectByMid(mid);
		
		if(count==0){
			result = 1;
		}
		return result;
	}
	
	@Override
	public void memberJoin(Member member) {
		dao.memberInsert(member);
	}

	
	@Override
	public Member login(String mid, String mpassword) {
		Member member=dao.memberSelectByMid(mid);
		if(member==null){
			return null;
		}else{
			if(member.getMpassword().equals(mpassword)){
				return member;
			}else{
				return null;
			}
		}
		
	}
	
	@Override
	public void boardWrite(Board board) {
		dao.boardInsert(board);
	}
	
	@Override
	public List<Board> boardListPage(int pageNo, int rowsPerPage) {
		return dao.boardSelectPage(pageNo, rowsPerPage);
	}
	
	@Override
	public int boardTotalRows() {
		return dao.boardCountAll();
	}
	
	@Override
	public Board getBoard(int bno) {
		Board board = dao.boardSelectByBno(bno);
		board.setBhitcount(board.getBhitcount()+1);
		dao.boardUpdateBhitcount(bno, board.getBhitcount());
		return board;
	}
	
	@Override
	public void boardUpdate(Board board) {
		// TODO Auto-generated method stub
		dao.boardUpdate(board);
	}
	
	@Override
	public void boardDelete(int bno) {
		// TODO Auto-generated method stub
		dao.boardDelete(bno);
	}
	
	@Override
	public Member getMember(String mid) {
		Member member = dao.memberSelectByMid(mid);
		return member;
	}
	
	

}
