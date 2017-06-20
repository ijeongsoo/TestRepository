package com.mycompany.myapp.dao;

import com.mycompany.myapp.dto.Exam15Account;

public interface Exam15Dao {
	public int update(Exam15Account account);
	public Exam15Account selectByAno(String ano);
}
