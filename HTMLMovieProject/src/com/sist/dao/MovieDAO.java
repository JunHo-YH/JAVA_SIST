package com.sist.dao;

import java.util.*;
import java.sql.*;

public class MovieDAO {
	// 1. 오라클 연결 객체
	private Connection conn;

	// 2. SQL문장 전송 => 결과값을 받아오는 객체
	private PreparedStatement ps;

	// 3. 오라클 주소(URL)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1-1. 드라이버 등록 => sqldeveloper 열기 => 생성자는 한번만 사용 가능
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 1-2. 오라클 연결 conn system/happy
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "system", "happy");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 1-3. 오라클 닫기 exit
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 2-1. 기능 설계
	// 1) 로그인 => 경우의 수 (ID가 틀린 경우, 비밀번호가 틀린 경우, 로그인)
	public String isLogin(String id, String pwd) {
		String result = "";
		try {
			// 1. 연결
			getConnection();
			
			// 2. SQL 문장 => ID가 존재 여부 확인
			String sql = "SELECT COUNT(*) FROM webMember "
					+ "WHERE id = ?";
			ps = conn.prepareStatement(sql);
			
			// ?에 값을 채운다.
			ps.setString(1, id);
			
			// 실행후에 결과값을 받는다.
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			
			if(count == 0) { // ID가 존재하지 않는 경우
				result = "NO ID"; // alert()
			} else { // ID가 존재하는 경우
				// 비밀번호 검색
				sql = "SELECT pwd, name FROM webMember "
						+ "WHERE id=?";
				ps = conn.prepareStatement(sql);
				
				// ?에 값을 채운다
				ps.setString(1, id);
				
				// 실행 결과값 가지고 온다
				rs = ps.executeQuery();
				rs.next(); // 결과값이 있는 위치에 커서 이동
				String db_pwd = rs.getString(1);
				String name = rs.getString(2);
				rs.close();
				
				// 비밀번호가 있냐?
				if(db_pwd.equals(pwd)) { // 비밀번호가 맞는 상태 => 로그인
					// 영화목록으로 이동
					result = name; // id, name => session => 댓글사용 불가
				} else { // 비밀번호가 틀린 상태
					result = "NO PWD";
				}
			
			
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		} finally {
			// 닫기
			disConnection();
		}

		return result;
	}
	// 2) 영화 목록
	public ArrayList<MovieVO> movieListData(int page) {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		try {
			// 1. 연결
			getConnection();
//================================================================================================↓ 이해 x
			// 2. SQL문장
			String sql = "SELECT mno, title, poster, num "
					+ "FROM (SELECT mno, title, poster, rownum as num "
					+ "FROM (SELECT mno, title, poster "
					+ "FROM movie ORDER BY 1)) "
					+ "WHERE num BETWEEN ? AND ?";
			int rowSize = 20;
			int start=(rowSize*page) - (rowSize-1);
			int end = rowSize*page;
			
			ps = conn.prepareStatement(sql);
			
			// ?에 값 채우기
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			// 실행요청 => 결과값을 받는다.
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			disConnection();
		}
		return list;
	}
	// 2-1) 총 페이지 수
	public int movieTotalPage() {
		int total = 0;
		try {
			// 1. 연결
			getConnection();
			
			// 2. SQL 문장
			String sql = "SELECT CEIL(COUNT(*)/20.0) FROM movie";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			disConnection();
		}
		return total;
	}
	// 3) 영화 상세보기 (mno => 사용자가 포스터를 클릭할 때 넘겨준 번호) => 영화 1개에 대한 정보
	public MovieVO movieDetailData(int mno) {
		MovieVO vo = new MovieVO();
		try {
			// 1. 연결
			getConnection();
			
			// 2. SQL문장
			String sql = "SELECT mno, title, poster, genre, actor,"
					+ "regdate, grade, director "
					+ "FROM movie "
					+ "WHERE mno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			
			// 결과값 받기
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setMno(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setGenre(rs.getString(4));
			vo.setActor(rs.getString(5));
			vo.setRegdate(rs.getString(6));
			vo.setGrade(rs.getString(7));
			vo.setDirector(rs.getString(8));
			rs.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());// 오류처리
		}finally {
			disConnection();// 해제
		}
		return vo; // vo에 값을 채워서 넘겨준다.
	}
	// 4) 댓글 쓰기
	// 5) 댓글 삭제
	// 6) 댓글 수정
}



























