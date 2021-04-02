package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
public class MemberDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static MemberDAO dao;
	   public void getConnection()
	   {
		   try
		   {
			   // JNDI초기화 : 탐색기를 연다
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex) {}
	   }
	   // 사용후에 반환 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex){}
	   }
	   // DAO  객체를 클라이언트당 1개씩만 사용 => 싱글턴 
	   public static MemberDAO newInstance()
	   {
		   if(dao==null)
			   dao=new MemberDAO();
		   
		   return dao;
			   
	   }
	   // 우편번호
	   public List<ZipcodeVO> postFindData(String dong)
	   {
		   List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					     +"FROM zipcode "
					     +"WHERE dong LIKE '%'||?||'%'";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, dong);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   ZipcodeVO vo=new ZipcodeVO();
				   vo.setZipcode(rs.getString(1));
				   vo.setSido(rs.getString(2));
				   vo.setGugun(rs.getString(3));
				   vo.setDong(rs.getString(4));
				   vo.setBunji(rs.getString(5));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
	   // 아이디 중복체크
	   public int idcheck(String id)
	   {
		   int count=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT COUNT(*) FROM project_member "
					     +"WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return count;
	   }
	   // 회원가입
	   public void memberJoin(MemberVO vo)
	   {
		   /*
		    *  ID       NOT NULL VARCHAR2(20)  
			PWD      NOT NULL VARCHAR2(10)  
			NAME     NOT NULL VARCHAR2(34)  
			SEX               VARCHAR2(10)  
			BIRTHDAY NOT NULL VARCHAR2(20)  
			EMAIL             VARCHAR2(100) 
			POST     NOT NULL VARCHAR2(10)  
			ADDR1    NOT NULL VARCHAR2(200) 
			ADDR2             VARCHAR2(200) 
			TEL               VARCHAR2(20)  
			CONTENT           CLOB          
			ADMIN             CHAR(1) 
		    */
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO project_member VALUES(?,?,?,?,?,?,?,?,?,?,?,'n')";
			   ps=conn.prepareStatement(sql);
			   //?에 값을 채운다 
			   ps.setString(1, vo.getId());
			   ps.setString(2, vo.getPwd());
			   ps.setString(3, vo.getName());
			   ps.setString(4, vo.getSex());
			   ps.setString(5, vo.getBirthday());
			   
			   ps.setString(6, vo.getEmail());
			   ps.setString(7, vo.getPost());
			   ps.setString(8, vo.getAddr1());
			   ps.setString(9, vo.getAddr2());
			   ps.setString(10, vo.getTel());
			   
			   ps.setString(11, vo.getContent());
			   
			   ps.executeUpdate();
		   }catch(Exception ex) 
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   
	   }
	   // 회원수정 
	   // 아이디 찾기
	   // 비밀번호 찾기 
}











