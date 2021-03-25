package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
// DBCP => 웹에서만 가능 
public class FoodDAO {
	 private Connection conn;
	 private PreparedStatement ps;
	// 미리 만들어진 객체주소를 얻어온다 (Connection)
	   public void getConnection()
	   {
		   try
		   {
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex){}
	   }
	   // 반환 (풀(POOL)로 반환) => 재사용
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	 public List<FoodCategoryVO> foodCategoryData(int index)
	 {
		 List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
		 try
		 {
			 getConnection();
			 int start=0;
			 int end=0;
			 if(index==1)
			 {
				 start=1;
				 end=12;
			 }
			 else if(index==2)
			 {
				 start=13;
				 end=18;
			 }
			 else
			 {
				 start=19;
				 end=30;
				 
			 }
			 String sql="SELECT * FROM food_category "
					   +"WHERE no BETWEEN ? AND ?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, start);
			 ps.setInt(2, end);
			 
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 FoodCategoryVO vo=new FoodCategoryVO();
				 vo.setNo(rs.getInt(1));
				 vo.setTitle(rs.getString(2));
				 vo.setSubject(rs.getString(3));
				 vo.setPoster(rs.getString(4));
				 vo.setLink(rs.getString(5));
				 
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
	 public List<FoodCategoryVO> foodCategoryLinkData()
	 {
		 List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
		 try
		 {
			 getConnection();
			 String sql="SELECT no,link FROM food_category ORDER BY no ASC";
			 ps=conn.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 FoodCategoryVO vo=new FoodCategoryVO();
				 vo.setNo(rs.getInt(1));
				 vo.setLink(rs.getString(2));
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
	 public FoodCategoryVO foodInfoData(int cno)
	 {
		 FoodCategoryVO vo=new FoodCategoryVO();
		 try
		 {
			 getConnection();
			 String sql="SELECT title,subject FROM food_category "
					   +"WHERE no=?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, cno);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 vo.setTitle(rs.getString(1));
			 vo.setSubject(rs.getString(2));
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
	 
	 public List<FoodVO> foodCategoryFoodData(int cno)
	 {
		 List<FoodVO> list=new ArrayList<FoodVO>();
		 try
		 {
			 getConnection();
			 String sql="SELECT no,title,score,address,poster "
					   +"FROM food_house "
					   +"WHERE cno=?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, cno);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 FoodVO vo=new FoodVO();
				 vo.setNo(rs.getInt(1));
				 vo.setTitle(rs.getString(2));
				 vo.setScore(rs.getDouble(3));
				 vo.setAddress(rs.getString(4));
				 vo.setPoster(rs.getString(5));
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
}









