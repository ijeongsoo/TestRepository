/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.dto;

import java.util.Date;

/**
 *
 * @author ijeongsu
 */
public class Board {
	  private int bno;
	  private String btitle;
	  private String bwriter;
	  private Date bdate;
	  private String bcontent;

	  public String getBcontent() {
			return bcontent;
	  }

	  public void setBcontent(String bcontent) {
			this.bcontent = bcontent;
	  }
	  

	  public int getBno() {
			return bno;
	  }

	  public void setBno(int bno) {
			this.bno = bno;
	  }

	  public String getBtitle() {
			return btitle;
	  }

	  public void setBtitle(String btitle) {
			this.btitle = btitle;
	  }

	  public String getBwriter() {
			return bwriter;
	  }

	  public void setBwriter(String bwriter) {
			this.bwriter = bwriter;
	  }

	  public Date getBdate() {
			return bdate;
	  }

	  public void setBdate(Date bdate) {
			this.bdate = bdate;
	  }
	  
	  
	  
}
