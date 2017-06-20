package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl2 implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl2.class);
	
	@Autowired
	private DataSource dataSource1;
	
	@Override
	public int boardInsert(Exam12Board board) {
		int bno = -1;
		Connection conn = null;
		try {
			// jdbc driver loading
			
			// getting the connection object
			conn = dataSource1.getConnection();
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "insert into board (bno, btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent) values (board_bno_seq.nextval, ?, ?, ?, sysdate, ?,0, ?,?,?)";
			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBpassword());
			pstmt.setString(5, board.getBoriginalfilename());
			pstmt.setString(6, board.getBsavedfilename());
			pstmt.setString(7, board.getBfilecontent());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			bno = rs.getInt(1);
			pstmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();

				LOGGER.info("연결끊김");

			} catch (SQLException e) {
			}
			return bno;
		}

	}

	

	@Override
	public List<Exam12Board> boardSelectAll() {

		List<Exam12Board> list = new ArrayList<>();
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc";

			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
			}
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
			return list;
		}

	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {

		List<Exam12Board> list = new ArrayList<>();
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "select * "
					+ "from ( "
					+ "select rownum as r, bno, btitle, bwriter, bdate, bhitcount "
					+ "from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc) "
					+ "where rownum<=? "
					+ ") "
					+ "where r>=?";

			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo*rowsPerPage);
			pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
			}
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
			return list;
		}
	}
	
	@Override
	public int boardCountAll() {
		int count=0;
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "select count(*) from board";

			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			count = rs.getInt(1);
			
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
			return count;
		}
	}
	
	@Override
	public Exam12Board boardSelectByBno(int bno) {
		
		Exam12Board board=null;
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "select * from board where bno=?";

			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
			}

			
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
			return board;
		}
	}
	
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "update board set bhitcount=? where bno=? ";

			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bhitcount);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();

		
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
		}
	}
	
	
	@Override
	public void boardUpdate(Exam12Board board) {
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql;
			if(board.getBoriginalfilename()!=null){
				sql= "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=?  where bno=? ";
			}else{
				sql="update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=? ";
			}
			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBpassword());
			
			if(board.getBoriginalfilename() != null){
				pstmt.setString(4, board.getBoriginalfilename());
				pstmt.setString(5, board.getBsavedfilename());
				pstmt.setString(6, board.getBfilecontent());
				pstmt.setInt(7, board.getBno());
			}else{
				pstmt.setInt(4, board.getBno());
			}
			
			pstmt.executeUpdate();

		
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
		}
	}
	
	@Override
	public void boardDelete(int bno) {
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql= "delete from board where bno=? ";
			
			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			pstmt.executeUpdate();

		
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String memberInsert(Exam12Member member) {
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "insert into member (mid, mname, mpasswd, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent) "
					+ "values (?, ?, ?, sysdate, ?,?,?,?,?,?,?)";
			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
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
		} finally {
			// 연결끊기
			try {
				conn.close();

				LOGGER.info("연결끊김");

			} catch (SQLException e) {
			}
			return member.getMid();
		}

	}
	
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Member> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn=DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			String sql ="select * "
					+ "from( "
					+ "select rownum as r, mid, mname, mtel, mage, msavedfilename "
					+ "from (select mid, mname, mtel, mage, msavedfilename from member order by mage desc) "
					+ "where rownum<=? "
					+ ") "
					+ "where r>=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo*rowsPerPage));
			pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMtel(rs.getString("mtel"));
				member.setMage(rs.getInt("mage"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				list.add(member);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				LOGGER.info("연결종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		return list;
	}
	
	@Override
	public int memberCountAll() {
		int count=0;
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql = "select count(*) from member";

			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			count = rs.getInt(1);
			
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
			return count;
		}
	}
	
	
	@Override
	public Exam12Member memberSelectByMid(String mid) {
		Exam12Member member =null;
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url= "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn=DriverManager.getConnection(url, "iotuser", "iot12345");
			String sql = "select * from member where mid=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				member= new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpasswd(rs.getString("mpasswd"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				member.setMoriginalfilename(rs.getString("moriginalfilename"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				member.setMfilecontent(rs.getString("mfilecontent"));
			}
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return member;
		}
	}
	
	@Override
	public void memberUpdate(Exam12Member member) {
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql;
			LOGGER.info(member.getMoriginalfilename());
			if(member.getMoriginalfilename()!=null){
				sql= "update member set mname=?, mpasswd=?, mtel=?, memail=? , mage=?, maddress=?, moriginalfilename=?, msavedfilename=?, mfilecontent=?  where mid=? ";
			}else{
				sql="update member set mname=?, mpasswd=?, mtel=?, memail=?, mage=?, maddress=? where mid=? ";
			}
			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMpasswd());
			pstmt.setString(3, member.getMtel());
			pstmt.setString(4, member.getMemail());
			pstmt.setInt(5, member.getMage());
			pstmt.setString(6, member.getMaddress());
			
			if(member.getMoriginalfilename() != null){
				pstmt.setString(7, member.getMoriginalfilename());
				pstmt.setString(8, member.getMsavedfilename());
				pstmt.setString(9, member.getMfilecontent());
				pstmt.setString(10, member.getMid());
			}else{
				pstmt.setString(7, member.getMid());
			}
			
			pstmt.executeUpdate();

		
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
		}
	}
	
	@Override
	public void memberDelete(String mid) {
		Connection conn = null;
		try {
			// jdbc driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// connection String declare
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			// getting the connection object
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// write the 매개변수화된 SQL
			String sql="delete from member where mid=?";
			
			// transform the SQL
			// 완전한 SQL문만 사용!!!!
			// Statement stmt = conn.createStatement();
			// stmt.executeUpdate(sql);
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수있는 DB일 경우(MySQL, MSSQL)
			// PreparedStatement pstmt = conn.prepareStatement(sql,
			// Statement.RETURN_GENERATED_KEYS);
			// 오라클일 경우 Sequence 외부 객체를 사용하기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			

			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결끊김");
			} catch (SQLException e) {
			}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		Exam12DaoImpl2 test = new Exam12DaoImpl2();
		List<Exam12Member> list = test.memberSelectPage(1, 10);
		for(Exam12Member board : list){
			LOGGER.info(board.getMid());
		}

	}

}
