package com.sist.dao;
import java.sql.*;
// VO , DAO
/*
 *    SQL 
 *     = DML (데이터 조작언어)
 *         = SELECT : 데이터 검색 
 *             = JOIN
 *             = SUBQUERY
 *         = INSERT : 데이터 추가
 *         = UPDATE : 데이터 수정 
 *         = DELETE : 데이터 삭제 
 *     = DDL (데이터 선언언어) => 제약조건 (PRIMARY KEY , FOREIGN KEY , CHECK , UNIQUE , DEFAULT)
 *         = CREATE : 생성
 *            TABLE , VIEW , INDEX , SEQUENCE , PROCEDURE , FUNCTION , TRIGGER
 *         = ALTER : 수정
 *         = DROP : 삭제
 *         = TRUNCATE : 잘라내기
 *         = RENAME : 이름변경 
 *     = DCL (데이터 제어언어)
 *         = GRENT : 권한 부여
 *         = REVOKE : 권한 해제 
 *     = TCL (트랜잭션 제어언어)
 *         = COMMIT
 *         = ROLLBACK
 *         
 *    PL/SQL 
 *       ===
 *    ==
 *    함수를 만드는 언어 : 재사용
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 1. Driver등록 => Oracle제공 
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	// 2. 연결 
        	String url="jdbc:oracle:thin:@localhost:1521:XE";// 오라클 주소
        	Connection conn=DriverManager.getConnection(url,"hr","happy");
        	// 3. SQL문장 전송
        	String sql="SELECT empno,ename,job,hiredate,sal FROM emp WHERE ename LIKE '%T%'";
        	//           startsWith
        	// 오라클 => 대소문자 구분이 없다 (약속 => 키워드는 대문자로 한다)
        	// class,interface => 대문자 시작 , 변수,메소드 => 소문자
        	/*
        	 *   class mainclass
        	 *   {
        	 *      
        	 *   }
        	 *   
        	 *   Mainclass mainclass=new Mainclass();
        	 */
        	PreparedStatement ps=conn.prepareStatement(sql);// 전송 
        	/*
        	 *    empno
        	 *    ename
        	 *    job
        	 *    mgr
        	 *    hiredate
        	 *    sal
        	 *    comm
        	 *    deptno
        	 */
        	// 4. 결과값 받아서 출력 
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())// 한줄씩 읽어 온다 => 데이터가 없으면 (false)
        	{
        		System.out.println(
        			rs.getInt(1)+" "
        			+rs.getString(2)+" "
        			+rs.getString(3)+" "
        			+rs.getDate(4)+" "
        			+rs.getInt(5)
        		);
        	}
        }catch(Exception ex) 
        {
        	ex.printStackTrace();
        }
	}

}











