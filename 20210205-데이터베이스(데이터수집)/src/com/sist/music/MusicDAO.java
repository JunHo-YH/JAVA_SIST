package com.sist.music;

import java.sql.*;
/*
 * 
 * JDBC => Java Database Connective
 * ����Ŭ ����
 * 1. ����̹� ��ġ Class.forName("����̹� Ŭ������");
 * 2. ����Ŭ ���� Connection => ����Ŭ �ּ�, userName, passWord
 * 3. SQL���� ���� => ����Ŭ���� SQL�� �޾Ƽ� ����
 *    
 *                         Statement
 *                         = Statement: SQL���� + �����Ͱ�
 *                           String name, sex, addr, tel;
 *                           int age;
 *                           String sql = "INSERT INTO member VALUES('"+name+"', '"+sex+"', '"+addr+"' ...";
 *                 (��ȣ)   = PreparedStatement: default => SQL������ ����� ���߿� ���� ä���.
 *                           String sql = "INSERT INTO member VALUES(?,?,?,?,?,?);
 *                         = CallableStatement: �Լ� ȣ�� (PL/SQL)
 *    executeQuery(SQL����): ����� ����� �޾ƿ� �� => SELECT
 *    executeUpdate(SQL����): ����Ŭ ��ü���� ó�� => INSERT, UPDATE, DELETE
 * 4. ����Ŭ �ݱ�
 * 	  = ���� => ���� => �ݱ�
 *  
 */

public class MusicDAO {
	private Connection conn; // ����Ŭ ���� => Socket
	private PreparedStatement ps; // OutputStream(����Ŭ�� ����), BufferedReader(����Ŭ�κ��� ������ �ޱ�)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// ���� => null, NullPointerException ==> URL�ּ� Ȯ��

	// ����̹� ��ġ: �ѹ��� ����(�����ڿ� ��ġ)
	public MusicDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ����
	public void getConnection() {
		try {
			// ����Ŭ ���� => conn hr/happy
			conn = DriverManager.getConnection(URL, "hr", "happy");  // XML�� �����.

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// �ݱ�
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// ���Ϲ����� ������ ����
	/*  ������� �ֱ� �ڡڡڡڡ�
	 *  NO           NUMBER(3)     
	   	CNO          NUMBER(1)     
		TITLE        VARCHAR2(300) 
		SINGER       VARCHAR2(200) 
		ALBUM        VARCHAR2(200) 
		POSTER       VARCHAR2(260) 
		STATE        CHAR(4)       
		IDCREMENT    NUMBER(3)
	 */
	public void genieMusicInsert(GenieMusicVO vo) { // ������ ���� �� ����� ��ſ�, Ŭ������ �� ���� ����
		try {
			// ����
			getConnection();
			
			// SQL���� ����
			String sql = "INSERT INTO genie_music VALUES(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			// ?�� ���� ä���.
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
			
			// SQL���� ����
			ps.executeUpdate();
			
		} catch(Exception ex) {
			// ���� Ȯ��
			ex.printStackTrace();
		} finally {
			// ���� �ݱ�
			disConnection();
		}
	}

}
