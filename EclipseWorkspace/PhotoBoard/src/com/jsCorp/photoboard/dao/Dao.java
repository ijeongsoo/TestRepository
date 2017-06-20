package com.jsCorp.photoboard.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jsCorp.photoboard.dto.Board;
import com.jsCorp.photoboard.dto.Member;

@Component
public interface Dao {
	public int memberExistSelectByMid(String mid);
	public String memberInsert(Member member);
	public Member memberSelectByMid(String mid);
	
	public int boardInsert(Board board);
	public List<Board> boardSelectPage(int pageNo, int rowsPerPage);
	public int boardCountAll();
	
	public Board boardSelectByBno(int bno);
	public void boardUpdateBhitcount(int bno, int bhitcount);
	
	public void boardUpdate(Board board);
	public void boardDelete(int bno);
}
