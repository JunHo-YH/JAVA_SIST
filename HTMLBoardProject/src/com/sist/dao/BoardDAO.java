package com.sist.dao;

import java.util.*;

import com.sun.net.httpserver.Authenticator.Result;

import java.sql.*;

public class BoardDAO {
	// 1. 오라클 연결 객체
	private Connection conn; // Socket
	// 2. SQL문장을 송수신 객체
	private PreparedStatement ps;// BufferedReader,OutputStream
	// JDBC => TCP를 이용하는 프로그램
	// 3. URL(오라클 주소)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 오라클 연결을 위한 드라이버 설치(한번만 설치)
	public BoardDAO() {
		try {
			// 리플랙션 => 클래스의 정보를 읽어서 메모리 할당
			Class.forName("oracle.jdbc.driver.OracleDriver");// Class.forName("패키지명.클래스명");

		} catch (Exception ex) {
		}
	}

	// 오라클 연결 = 닫기
	// 1. 연결 conn system/happy
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "system", "happy");
			/*
			 * DriverManager (Factory Pattern) => DML (ANSI) LIKE '%'||?||'%' =>
			 * REGEXP_LIKE()
			 */
		} catch (Exception ex) {
		}
	}

	// 2. 닫기 exit
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}
	}

	// 3. 게시판 기능
	// 3-1. 목록 => 인라인뷰 (페이지 나누기) => ArrayList<BoardVO>
	public ArrayList<BoardVO> boardListData(int page) {
		// return selectList()
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();// list안에 10개의 BoardVO
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "SELECT no,subject,name,regdate,hit,num "
					+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					+ "FROM (SELECT no,subject,name,regdate,hit " + "FROM webBoard ORDER BY no DESC)) "
					+ "WHERE num BETWEEN ? AND ?";
			int rowSize = 10;
			int start = (rowSize * page) - (rowSize - 1);// 1 11
			int end = rowSize * page;// 10 20
			ps = conn.prepareStatement(sql);
			// ? 에 값을 채운다
			ps.setInt(1, start);
			ps.setInt(2, end);
			// SQL문장 실행요청 => 결과값을 받는다
			ResultSet rs = ps.executeQuery();
			// rs에 존재하는 데이터를 list에 추가
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			// 오류,정상 => 무조건 오라클 닫는다
			disConnection();
		}
		return list;
	}

	// 3-1-1. 게시물 총 갯수 => 번호를 순서대로 출력
	public int boardRowCount() {
		int count = 0;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM webBoard";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return count;
	}

	// 3-2. 추가 => INSERT => 시퀀스
	public void boardInsert(BoardVO vo) {
		try {
			// 1. 연결
			getConnection();

			// 2. SQL문장
			String sql = "INSERT INTO webBoard VALUES(" + "wb+no_seq.nextval,?,?,?,?,SYSDATE,0)";
			ps.getConnection().prepareStatement(sql);

			// 3. ?에 값을 채운다.
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());

			// 4. 실행요청 => Commit포함
			ps.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
	}

	// 3-3. 수정 => UPDATE => SQL (2개) 1.비밀번호 확인 , 2. 수정 => 어디로 갈까? 흐름
	// 3-3-1 데이터 읽기
	// web 화면 ==> DAO ==> web화면에 데이터 출력
	public BoardVO boardUpdateData(int no) {
		BoardVO vo = new BoardVO();
		try {
			// 1. 연결
			getConnection();

			// 2. SQL 문장
			String sql = "SELECT name, subject, content " + "FROM webBoard" + "WHERE no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);

			// 3. 실행요청
			ResultSet rs = ps.executeQuery();
			rs.next();
			// 4. 결과값을 VO에 채운다.
			vo.setName(rs.getString(1));
			vo.setSubject(rs.getString(2));
			vo.setContent(rs.getString(3));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return vo;
	}

	// 3-3-2 실제 수정
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck = false;
		try {
			// 1. 연결
			getConnection();

			// 2. SQL문
			String sql = "SELECT pwd FROM webBoard " + "WHERE no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd())) {
				bCheck = true;
				
				// 실제 수정
				sql = "UPDATE webBoard SET "
						+ "name=?, subject=?, content=? "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				// 실행
				ps.execute();
			}

			// 3. 실행요청

			// 4. 결과값을 VO에 채운다.

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return bCheck;
	}

	// 3-4. 삭제 => DELETE => 비밀번호 확인
	public boolean boardDelete(int no, String pwd) { // 매개변수가 3개 이상이면 vo를 사용 or not
		boolean bCheck = false;
		try {

			// 1. 오라클 연결
			getConnection();

			// 2. SQL문장
			String sql = "SELECT pwd FROM webBoard" + "WHERE no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();

			if (db_pwd.equals(pwd)) {
				bCheck = true;
				// 실제 데이터 삭제
				sql = "DELETE FROM webBoard" + "WHERE no=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, no);
				ps.executeUpdate();
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return bCheck;
	}

	// 3-5. 내용보기 => SQL(2개)
	public BoardVO boardDetailData(int no) {
		BoardVO vo = new BoardVO();
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작
			// 조회수 증가
			String sql = "UPDATE webBoard SET " + "hit=hit+1 " + "WHERE no=?";
			ps = conn.prepareStatement(sql);
			// ?에 값을 채운다
			ps.setInt(1, no);
			// UPDATE를 실행
			ps.executeUpdate(); // COMMIT

			// 증가된 조회수를 포함해서 데이터 읽기
			sql = "SELECT no,name,subject,content,regdate,hit " + "FROM webBoard " + "WHERE no=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));

			rs.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return vo;
	}
	// 3-6. 찾기 => LIKE

}
