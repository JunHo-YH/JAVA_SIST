package com.sist.movie;

// 오라클 연결 
import java.sql.*;

public class MovieDAO {
	private Connection conn;// 오라클 연결
	private PreparedStatement ps;// SQL문장을 전송
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// jdbc:업체명:IP:PORT:데이터베이스명
	// thin드라이버 => 연결 (오라클 <==> 자바응용프로그램) => 속도가 늦다 , 무료
	// 드라이버 등록 => 한번만 설정
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클하고 연결할 수 있게 드라이버 설치 (소프트웨어)
			// 리플랙션 => 클래스 정보를 읽어서 메모리 할당 => Properties를 이용하는 방법
		} catch (Exception ex) {
		}
	}

	// 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy"); // 연결 => 오라클 URL , username , password
			// conn hr/happy => 오라클 넘어간다
		} catch (Exception ex) {
		}
	}

	// 오라클 닫기
	public void disConnection() {
		try {
			if (ps != null)
				ps.close(); // OutputStream / BufferedReader => Statement
			if (conn != null)
				conn.close(); // Socket => TCP
			// exit
		} catch (Exception ex) {
		}
	}

	// 기능 (데이터 추가)
	/*
	 * MNO NUMBER(4) TITLE VARCHAR2(100) GENRE VARCHAR2(100) POSTER VARCHAR2(200)
	 * ACTOR VARCHAR2(300) REGDATE VARCHAR2(100) GRADE VARCHAR2(50) DIRECTOR
	 * VARCHAR2(50)
	 */
	// 기능
	public void movieInsert(MovieVO vo) {
		try {
			/*
			 * SELECT : 데이터 검색 INSERT : 데이터 추가 UPDATE : 데이터 수정 DELETE : 데이터 삭제 ==> CURD =>
			 * 데이터 조작 오라클 장점 => 영구적인 저장 장치 , 모든 공유할 수 있는 데이터
			 */
			getConnection();
			String sql = "INSERT INTO movie VALUES(?,?,?,?,?,?,?,?)"; // 오라클에 데이터 추가 명령어
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getMno()); // TO_NUMBER()
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
