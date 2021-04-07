package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
/*
 *   DML : SELECT , INSERT , UPDATE , DELETE 
 *         = 참조키 (참조하고 있는 데이터를 먼저 삭제) 
 *         = SELECT 
 *           ====== JOIN , SUBQUERY , Inline View
 *   => 자바에서 연동 
 *      JDBC =======> DBCP ========> ORM(라이브러리: MyBatis,Hibernate, JPA)
 *                                                =======
 */
public class DataBoardDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static DataBoardDAO dao;
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
	   public static DataBoardDAO newInstance()
	   {
		   if(dao==null)
			   dao=new DataBoardDAO();
		   
		   return dao;
			   
	   }
	   // 자료실 목록 출력 
	   public List<DataBoardVO> databoardListData(int page)
	   {
		   List<DataBoardVO> list=new ArrayList<DataBoardVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,subject,name,regdate,hit,num "
					     +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					     +"FROM (SELECT no,subject,name,regdate,hit "
					     +"FROM databoard ORDER BY no DESC)) "
					     +"WHERE num BETWEEN ? AND ?";
			   int rowSize=10;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   DataBoardVO vo=new DataBoardVO();
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
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
	   // 총페이지 구하기
	   public int databoardTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/10.0) FROM databoard";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   // 에러 처리
			   ex.printStackTrace();
		   }
		   finally
		   {
			   // 반환 
			   disConnection();
		   }
		   return total;
	   }
	   // insert
	   public void databoardInsert(DataBoardVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO databoard(no,name,subject,content,pwd,filename,filesize) "
					     +"VALUES((SELECT NVL(MAX(no)+1,1) FROM databoard),?,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
			   ps.setString(5, vo.getFilename());
			   ps.setInt(6, vo.getFilesize());
			   
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
	   // detail
	   public DataBoardVO databoardDetailData(int no)
	   {
		   DataBoardVO vo=new DataBoardVO();
		   try
		   {
			   getConnection();
			   String sql="UPDATE databoard SET "
					     +"hit=hit+1 "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
			   
			   sql="SELECT no,name,subject,content,regdate,hit,filename,filesize "
				  +"FROM databoard "
				  +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setContent(rs.getString(4));
			   vo.setRegdate(rs.getDate(5));
			   vo.setHit(rs.getInt(6));
			   vo.setFilename(rs.getString(7));
			   vo.setFilesize(rs.getInt(8));
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
}









