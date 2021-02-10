package com.sist.music;

import java.sql.*;
/*
 * 
 * JDBC => Java Database Connective
 * 오라클 연결
 * 1. 드라이버 설치 Class.forName("드라이버 클래스명");
 * 2. 오라클 연결 Connection => 오라클 주소, userName, passWord
 * 3. SQL문장 전송 => 오라클에서 SQL을 받아서 실행
 *    
 *                         Statement
 *                         = Statement: SQL문장 + 데이터값
 *                           String name, sex, addr, tel;
 *                           int age;
 *                           String sql = "INSERT INTO member VALUES('"+name+"', '"+sex+"', '"+addr+"' ...";
 *                 (선호)   = PreparedStatement: default => SQL문장을 만들고 나중에 값을 채운다.
 *                           String sql = "INSERT INTO member VALUES(?,?,?,?,?,?);
 *                         = CallableStatement: 함수 호출 (PL/SQL)
 *    executeQuery(SQL문장): 실행된 결과를 받아올 때 => SELECT
 *    executeUpdate(SQL문장): 오라클 자체에서 처리 => INSERT, UPDATE, DELETE
 * 4. 오라클 닫기
 * 	  = 연결 => 전송 => 닫기
 *  
 */

public class MusicDAO {
	private Connection conn; // 오라클 연결 => Socket
	private PreparedStatement ps; // OutputStream(오라클에 전송), BufferedReader(오라클로부터 데이터 받기)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// 오류 => null, NullPointerException ==> URL주소 확인

	// 드라이버 설치: 한번만 수행(생성자에 설치)
	public MusicDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 연결
	public void getConnection() {
		try {
			// 오라클 전송 => conn hr/happy
			conn = DriverManager.getConnection(URL, "hr", "happy");  // XML로 감춘다.

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 닫기
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 지니뮤직의 데이터 저장
	/*  순서대로 넣기 ★★★★★
	 *  NO           NUMBER(3)     
	   	CNO          NUMBER(1)     
		TITLE        VARCHAR2(300) 
		SINGER       VARCHAR2(200) 
		ALBUM        VARCHAR2(200) 
		POSTER       VARCHAR2(260) 
		STATE        CHAR(4)       
		IDCREMENT    NUMBER(3)
	 */
	public void genieMusicInsert(GenieMusicVO vo) { // 변수를 여러 개 많드는 대신에, 클래스로 한 번에 전달
		try {
			// 연결
			getConnection();
			
			// SQL문장 제작
			String sql = "INSERT INTO genie_music VALUES(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			// ?에 값을 채운다.
			ps.setInt(1, vo.getNo());
			ps.setInt(2, vo.getCno());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getSinger());
			ps.setString(5, vo.getAlbum());
			ps.setString(6, vo.getPoster());
			ps.setString(7, vo.getState());
			ps.setInt(8, vo.getIdcrement());
			/*
			 * VARCHAR2, CHAR, CLOB => String
			 * NUMBER => int(double)
			 * DATE => java.util.Date
			 */
			
			// SQL문장 실행
			ps.executeUpdate();
			
		} catch(Exception ex) {
			// 에러 확인
			ex.printStackTrace();
		} finally {
			// 파일 닫기
			disConnection();
		}
	}

}
