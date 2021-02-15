package com.sist.movie_;

import java.sql.*;

import com.sist.movie.MovieVO;

public class MovieDAO {
	private Connection conn; // 오라클 연결
	private PreparedStatement ps; // SQL문장 전송
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 드라이버 등록
	// 한 번만 설정
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 오라클에 데이터 추가
	public void moiveInsert(MovieVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO movie VALUES (?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getMno()); // TO_NUMBER()
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getActor());
			ps.setString(6, vo.getRegdate());
			ps.setString(7, vo.getGrade());
			ps.setString(8, vo.getDirector());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
