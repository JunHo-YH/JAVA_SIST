package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.RecipeVO;

import java.sql.*;
import java.util.*;
public class RecipeDAO {
	   // 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static RecipeDAO dao;
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
	   public static RecipeDAO newInstance()
	   {
		   if(dao==null)
			   dao=new RecipeDAO();
		   return dao;
	   }
	   // 레시피 목록 출력 
	   /*
	    *   NO     NOT NULL NUMBER         
			POSTER NOT NULL VARCHAR2(260)  
			TITLE  NOT NULL VARCHAR2(1000) 
			CHEF   NOT NULL VARCHAR2(200)  
			HIT             VARCHAR2(100)  
			LINK            VARCHAR2(100)
			
			                  .do => DispatcherServlet
			                request               request
			JSP(요청: ~.do) ==> DispatcherServlet =========> Model <=====> DAO 
			                   (Controller) 
			                   => 요청을 처리하는 자바클래스 찾기 
			                   => 처리한 결과값을 받는다 
			                   => 요청한 클라이언트의 JSP로 전송
			                   
	    */
	   public List<RecipeVO> recipeListData(int page)
	   {
		   List<RecipeVO> list=new ArrayList<RecipeVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,poster,title,chef,hit,num "
					     +"FROM (SELECT no,poster,title,chef,hit,rownum as num "
					     +"FROM (SELECT no,poster,title,chef,hit "
					     +"FROM craw ORDER BY no ASC)) "
					     +"WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			   int rowSize=12;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   RecipeVO vo=new RecipeVO();
				   vo.setNo(rs.getInt(1));
				   vo.setPoster(rs.getString(2));
				   vo.setTitle(rs.getString(3));
				   vo.setChef(rs.getString(4));
				   vo.setHit(rs.getString(5));
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
	   // 총갯수
	   public int recipeCount()
	   {
		   int count=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT COUNT(*) FROM craw";
			   ps=conn.prepareStatement(sql);
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
	   
	   
}







