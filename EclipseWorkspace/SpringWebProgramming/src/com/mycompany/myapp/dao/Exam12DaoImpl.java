package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam07Board;
import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl implements Exam12Dao{
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);

	@Override
	public int insert1(Exam12Board board) {
		int bno=-1;
		Connection conn=null;
		try {
			//jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			//connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object 
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			//write the 매개변수화된 SQL
			String sql ="insert into board (bno, btitle, bcontent) values (board_bno_seq.nextval, ?, ?)";
			//transform the SQL
			//완전한 SQL문만 사용!!!! 
			//Statement stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			//테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			//PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정 
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"bno"});
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			bno=rs.getInt(1);
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//연결끊기
			try {
				conn.close();
				
				LOGGER.info("연결끊김");
				
			} catch (SQLException e) {}
			return bno;
		}
		
		
		
		
		
		
	}
	
	
	@Override
	public String insert2(Exam12Member member) {
		Connection conn=null;
		try {
			//jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			//connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object 
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			//write the 매개변수화된 SQL
			String sql ="insert into memberjs (mid, mname, mpasswd, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent) "
					+ "values (?, ?, ?, sysdate, ?,?,?,?,?,?,?)";
			//transform the SQL
			//완전한 SQL문만 사용!!!! 
			//Statement stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			//테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			//PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMpasswd());
			pstmt.setString(4, member.getMtel());
			pstmt.setString(5, member.getMemail());
			pstmt.setInt(6, member.getMage());
			pstmt.setString(7, member.getMaddress());
			pstmt.setString(8, member.getMoriginalfilename());
			pstmt.setString(9, member.getMsavedfilename());
			pstmt.setString(10, member.getMfilecontent());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//연결끊기
			try {
				conn.close();
				
				LOGGER.info("연결끊김");
				
			} catch (SQLException e) {}
			return member.getMid();
		}
		
		
		
		
		
	}
	

	
	public static void main(String[] args){
		Exam12DaoImpl test = new Exam12DaoImpl();
		Exam12Board board = new Exam12Board();
		board.setBtitle("hi");
		board.setBcontent("hi bro!!!");
		
		
		test.insert1(board);
	}




	

}
