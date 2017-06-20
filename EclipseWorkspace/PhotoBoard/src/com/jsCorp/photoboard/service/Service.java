package com.jsCorp.photoboard.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jsCorp.photoboard.dto.Board;
import com.jsCorp.photoboard.dto.Member;


@Component
public interface Service {
	public int joinCheckID(String mid);
	public void memberJoin(Member member);
	public Member login(String mid, String mpassword);
	
	public void boardWrite(Board board);
	public List<Board> boardListPage(int pageNo, int rowsPerPage);
	public int boardTotalRows();
	public Board getBoard(int bno);
	public void boardUpdate(Board board);
	public void boardDelete(int bno);
	public Member getMember(String mid);
}
