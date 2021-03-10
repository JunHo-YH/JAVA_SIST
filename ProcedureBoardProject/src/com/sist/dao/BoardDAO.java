package com.sist.dao;
// 오라클 연결 
import java.sql.*; 
import java.util.*;
import oracle.jdbc.*;
public class BoardDAO {
   // 1. 오라클 연결 객체
	private Connection conn;
   // 2. SQL문장 전송 , 함수 호출 
	private CallableStatement cs;// 프로시저 호출시 사용되는 클래스
   // 3. 오라클 URL주소 
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 4. 오라클 연결 드라이버 설치 
	public BoardDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	// 5. 오라클 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"system","happy");
		}catch(Exception ex) {}
	}
	// 6. 오라클 닫기
	public void disConnection()
	{
		try
		{
			if(cs!=null) cs.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	// 7. 기능 
	// 7-1 . 목록 출력 
	/*
	 *      CREATE OR REPLACE PROCEDURE board_list(
			    pStart freeboard.no%TYPE,
			    pEnd freeboard.no%TYPE,
			    pResult OUT SYS_REFCURSOR
			)
	 */
	 // BoardVO(한개의 게시물) => 게시물 여러개를 모아서 브라우저로 전송 
	 public ArrayList<BoardVO> board_list(int page)
	 {
		 ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		 try
		 {
			 // 1. 연결
			 getConnection();
			 // 2. SQL문장을 만든다 
			 String sql="{CALL board_list(?,?,?)}";
			 cs=conn.prepareCall(sql);
			 // ?에 값을 채운후에 실행 
			 int rowSize=10;
			 int start=(rowSize*page)-(rowSize-1);
			 int end=rowSize*page;
			 /*
			  *   1pgae 1 - 10
			  *   2page 11 - 20
			  */
			 cs.setInt(1, start);
			 cs.setInt(2, end);
			 cs.registerOutParameter(3, OracleTypes.CURSOR);
			 //   => 오라클의 데이터형을 설정 
			 /*
			  *   SYS_REFCURSOR => OracleTypes.CURSOR
			  *   VARCHAR2      => OracleTypes.VARCHAR
			  *   NUMBER        => OracleTypes.INTEGER
			  */
			 // 실행 요청 
			 cs.executeUpdate(); // procedure => INSERT,UPDATE,DELETE,SELECT 
			                     // cs.executeUpdate() : 함수 호출 
			 ResultSet rs=(ResultSet)cs.getObject(3);// 저장된 데이터를 받는다 
			 /*
			  *     cs.getString(index)
			  *     cs.getInt()
			  *     cs.getDate()
			  *     CURSOR => cs.getObject() => 자바에서 존재하는 데이터형이 아니다 
			  */
			 while(rs.next())
			 {
				 // no,subject,name,regdate,hit
				 BoardVO vo=new BoardVO();
				 vo.setNo(rs.getInt(1));
				 vo.setSubject(rs.getString(2));
				 vo.setName(rs.getString(3));
				 vo.setRegdate(rs.getDate(4));
				 vo.setHit(rs.getInt(5));
				 
				 list.add(vo);
			 }
			 rs.close();
			 
		 }catch(Exception ex)
		 {
			 // 오류 처리
			 ex.printStackTrace();
		 }
		 finally
		 {
			 disConnection();
		 }
		 return list;
	 }
	 // 7-2. 총페이지 가지고 오기 
	 /*
	  *   CREATE OR REPLACE PROCEDURE board_totalpage(
              pTotal OUT NUMBER
          )
	  */
	 public int board_totalpage()
	 {
		  int total=0;
		  try
		  {
			  // 1. 연결
			  getConnection();
			  // 2. SQL문장 
			  String sql="{CALL board_totalpage(?)}";
			  cs=conn.prepareCall(sql);
			  // ?에 값을 채운다 
			  cs.registerOutParameter(1, OracleTypes.INTEGER);
			  // 실행
			  cs.executeUpdate();
			  total=cs.getInt(1);
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  disConnection();
		  }
		  return total;
	 }
	 // 7-2. 게시물 올리기
	 /*
	  *     CREATE OR REPLACE PROCEDURE board_insert(
			   pName freeboard.name%TYPE,
			   pSubject freeboard.subject%TYPE,
			   pContent freeboard.content%TYPE,
			   pPwd freeboard.pwd%TYPE
			)
	  */
	 // 자바에서 오라클에 만들어진 함수(프로시저)를 호출 : 자바에서 호출 (제어)
	 // DAO,VO => 웹 프로그램의 핵심 
	 // DAO => 원시소스 => 라이브러리 (ORM:MyBatis(O),Hibernate,JPA)
	 public void board_insert(BoardVO vo)
	 {
		 try
		 {
			 // 연결
			 getConnection();
			 // SQL문장 
			 String sql="{CALL board_insert(?,?,?,?)}";
			 // 함수 호출 
			 cs=conn.prepareCall(sql);
			 // ?=>값을 채운다 
			 cs.setString(1, vo.getName());
			 cs.setString(2, vo.getSubject());
			 cs.setString(3, vo.getContent());
			 cs.setString(4, vo.getPwd());
			 // 실행한다 
			 cs.executeUpdate();
		 }catch(Exception ex)
		 {
			 // 오류 처리
			 ex.printStackTrace();
			 // 프로시저,함수 => ERP (취업:85%) = 학교,은행,공기업(관리)
			 // 차세대 개발 => AL, 5G (속도) => Front (VueJS,ReactJS)
			 // 모바일 : 안드로이드,아이폰 => 통합(플래터) 
			 
		 }
		 finally
		 {
			 // 닫기
			 disConnection();
			 /*
			  *   자바메소드 , 오라클에서 프로시저 
			  *   1) 메소드,프로시저: 한가지 기능 수행 (구조화)
			  *   2) 반복이 많은 경우에 제작(재사용)
			  */
		 }
	 }
	 // 7-3. 상세보기 
	 /*
	  *     CREATE OR REPLACE PROCEDURE board_detail(
			   pNo freeboard.no%TYPE,
			   pResult OUT SYS_REFCURSOR
			)
	  */
	 // 화면 출력 : 서블릿 , JSP 
	 public BoardVO board_detail(int no)
	 {
		 BoardVO vo=new BoardVO();
		 try
		 {
			 getConnection();
			 String sql="{CALL board_detail(?,?)}";
			 cs=conn.prepareCall(sql);
			 // 실행전 => ?에 값을 채운다 
			 cs.setInt(1, no);
			 // 읽어올 위치를 설정 
			 cs.registerOutParameter(2, OracleTypes.CURSOR);
			 // 실행 요청
			 cs.executeUpdate();
			 // no,name,subject,content,regdate,hit,like1
			 ResultSet rs=(ResultSet)cs.getObject(2);
			 rs.next();
			 vo.setNo(rs.getInt(1));
			 vo.setName(rs.getString(2));
			 vo.setSubject(rs.getString(3));
			 vo.setContent(rs.getString(4));
			 vo.setRegdate(rs.getDate(5));
			 vo.setHit(rs.getInt(6));
			 vo.setLike1(rs.getInt(7));
			 rs.close();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 disConnection();
		 }
		 // Object selectOne()
		 return vo;
	 }
	 // 7-4. 삭제하기
	 /*
	  * CREATE OR REPLACE PROCEDURE board_delete(
		   pNo freeboard.no%TYPE,
		   pPwd freeboard.pwd%TYPE,
		   pResult OUT freeboard.name%TYPE
		)
	  */
	 public boolean board_delete(int no,String pwd)
	 {
		 boolean bCheck=false;
		 try
		 {
			 // 1. 연결
			 getConnection();
			 // 2. SQL
			 String sql="{CALL board_delete(?,?,?)}";
			 cs=conn.prepareCall(sql);
			 // 3. ?에 값을 채운다
			 cs.setInt(1, no);
			 cs.setString(2, pwd);
			 cs.registerOutParameter(3, OracleTypes.VARCHAR);
			 
			 // 4. 실행요청
			 cs.executeUpdate();
			 // 5. 저장된 데이터값을 받는다 
			 String result=cs.getString(3);
			 
			 bCheck=Boolean.parseBoolean(result); // String => boolean으로 변경
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 disConnection();
		 }
		 return bCheck;
	 }
	 // 7-5. 수정하기
	 /*
	  *   CREATE OR REPLACE PROCEDURE board_updateData(
			   pNo freeboard.no%TYPE,
			   pResult OUT SYS_REFCURSOR
			)
	  */
	 public BoardVO board_updateData(int no)
	 {
		 BoardVO vo=new BoardVO();
		 try
		 {
			 getConnection();
			 // SQL문장
			 String sql="{CALL board_updateData(?,?)}";
			 cs=conn.prepareCall(sql);
			 // ?에 값을 채운다 
			 cs.setInt(1, no);
			 cs.registerOutParameter(2, OracleTypes.CURSOR);
			 // no,name,subject,content
			 cs.executeUpdate();
			 ResultSet rs=(ResultSet)cs.getObject(2);
			 rs.next();
			 vo.setNo(rs.getInt(1));
			 vo.setName(rs.getString(2));
			 vo.setSubject(rs.getString(3));
			 vo.setContent(rs.getString(4));
			 rs.close();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 disConnection();
		 }
		 return vo;
	 }
	 // 7-5-1. 실제 수정
	 /*
	  *  CREATE OR REPLACE PROCEDURE board_update(
		   pNo freeboard.no%TYPE,
		   pName freeboard.name%TYPE,
		   pSubject freeboard.subject%TYPE,
		   pContent freeboard.content%TYPE,
		   pPwd freeboard.pwd%TYPE,
		   pResult OUT freeboard.name%TYPE --비밀번호 확인
		)
	  */
	 public boolean board_update(BoardVO vo)
	 {
		 boolean bCheck=false;
		 try
		 {
			 getConnection();
			 String sql="{CALL board_update(?,?,?,?,?,?)}";
			 cs=conn.prepareCall(sql);
			 // ?에 값을 채운다 
			 cs.setInt(1,vo.getNo());
			 cs.setString(2, vo.getName());
			 cs.setString(3, vo.getSubject());
			 cs.setString(4, vo.getContent());
			 cs.setString(5, vo.getPwd());
			 /// ==================== 오라클에서 읽어 가는 데이터 
			 cs.registerOutParameter(6, OracleTypes.VARCHAR);
			
			 // 실행 
			 cs.executeUpdate();
			 
			 String result=cs.getString(6);
			 bCheck=Boolean.parseBoolean(result);
			 
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 disConnection();
		 }
		 return bCheck;
	 }
	 // 7-6. 찾기 
	
}










