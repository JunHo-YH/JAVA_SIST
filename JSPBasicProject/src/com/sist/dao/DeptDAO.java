package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

public class DeptDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String USERNAME = "system";
	private final String PASSWORD = "happy";
	
	// 드라이버 등록
	public DeptDAO() {
		try {
			Class.forName(DRIVER);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 오라클 연결 해제
	public void disConnection() {
		try {
			if (conn != null) conn.close();
			if (ps != null) ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 기능 => 사원 목록 전체 출력
	public ArrayList<DeptVO> deptListData() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		try {
			// 연결
			getConnection();
			
			// sql문장
			String sql = "SELECT * FROM dept ORDER BY dname";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				// deptno dname loc
				DeptVO vo = new DeptVO();
				vo.setDeptno(rs.getInt(1));
				vo.setDname(rs.getString(2));
				vo.setLoc(rs.getString(3));
				
				list.add(vo);
			}
			rs.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	
	
}
