package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeMakeVO;
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
					     +"FROM recipe ORDER BY no ASC)) "
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
			   String sql="SELECT COUNT(*) FROM recipe";
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
	   // chef
	   public List<ChefVO> chefListData(int page)
	   {
		   List<ChefVO> list=new ArrayList<ChefVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT chef_name,poster,mc1,mc2,mc3,mc7,num "
					     +"FROM (SELECT chef_name,poster,mc1,mc2,mc3,mc7,rownum as num "
					     +"FROM (SELECT chef_name,poster,mc1,mc2,mc3,mc7 "
					     +"FROM chef)) "
					     +"WHERE num BETWEEN ? AND ?";
			   int rowSize=30;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   ChefVO vo=new ChefVO();
				   vo.setChef_name(rs.getString(1));
				   vo.setPoster(rs.getString(2));
				   vo.setMc1(rs.getString(3));
				   vo.setMc2(rs.getString(4));
				   vo.setMc3(rs.getString(5));
				   vo.setMc7(rs.getString(6));
				   
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
	   public int chefTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/30) FROM chef";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
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
	   // make
	   /*
	    *   NO          NOT NULL NUMBER         
			RNO                  NUMBER         
			POSTER      NOT NULL VARCHAR2(260)  
			CHEF        NOT NULL VARCHAR2(200)  
			CHEF_POSTER NOT NULL VARCHAR2(260)  
			TITLE       NOT NULL VARCHAR2(2000) 
			CONTENT     NOT NULL VARCHAR2(4000) 
			INFO1       NOT NULL VARCHAR2(20)   
			INFO2       NOT NULL VARCHAR2(20)   
			INFO3       NOT NULL VARCHAR2(20)   
			FOOD_MAKE   NOT NULL CLOB           
			CHEF_INFO   NOT NULL VARCHAR2(1000)
	    */
	   public RecipeMakeVO recipeMakeData(int no)
	   {
		   RecipeMakeVO vo=new RecipeMakeVO();
		   try
		   {
			   getConnection();
			   String sql="SELECT poster,chef,chef_poster,title,"
					     +"content,info1,info2,info3,food_make,chef_info "
					     +"FROM recipe_make "
					     +"WHERE rno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setPoster(rs.getString(1));
			   vo.setChef(rs.getString(2));
			   vo.setChef_poster(rs.getString(3));
			   vo.setTitle(rs.getString(4));
			   vo.setContent(rs.getString(5));
			   vo.setInfo1(rs.getString(6));
			   vo.setInfo2(rs.getString(7));
			   vo.setInfo3(rs.getString(8));
			   vo.setFood_make(rs.getString(9));
			   vo.setChef_info(rs.getString(10));
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
	   
	   public List<RecipeVO> recipeChefMakeData(String chef,int page)
	   {
		   List<RecipeVO> list=new ArrayList<RecipeVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,poster,title,chef,hit,num "
					     +"FROM (SELECT no,poster,title,chef,hit,rownum as num "
					     +"FROM (SELECT no,poster,title,chef,hit "
					     +"FROM recipe WHERE chef=? ORDER BY no ASC)) "
					     +"WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			   int rowSize=12;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps.setString(1, chef);
			   ps.setInt(2, start);
			   ps.setInt(3, end);
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
	   public int recipeChefMakePage(String chef)
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/12.0) "
					     +"FROM recipe "
					     +"WHERE chef=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, chef);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
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
	   
	   
}







