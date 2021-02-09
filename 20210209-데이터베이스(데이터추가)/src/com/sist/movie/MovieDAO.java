package com.sist.movie;

// 오라클 연결
import java.sql.*;

public class MovieDAO {
	private Connection conn; // 오라클 연결
	private PreparedStatement ps; // SQL문장을 전송
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 드라이버 등록 => 한번만 설정
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
			// sqlplus hr/happy
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 오라클 닫기
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
			// exit
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 기능 (데이터 추가)
	/*
	 * MNO NUMBER(4) TITLE VARCHAR2(100) GENRE VARCHAR2(100) POSTER VARCHAR2(200)
	 * ACTOR VARCHAR2(300) REGDATE VARCHAR2(100) GRADE VARCHAR2(50) DIRECTOR
	 * VARCHAR2(50)
	 */
	public void movieInsert(MovieVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO movie VALUES(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getMno());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getActor());
			ps.setString(6, vo.getRegdate());
			ps.setString(7, vo.getGrade());
			ps.setString(8, vo.getDirector());

			// 실행
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			disConnection();
		}
	}
}
