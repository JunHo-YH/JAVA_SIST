package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.jdbc.*;
// DBCP => 웹에서만 가능 
public class FoodDAO {
	 private DAOManager dm=new DAOManager();
	 private Connection conn;
	 private PreparedStatement ps;
	 public void foodCategoryInsert(FoodCategoryVO vo)
	 {
		 try
		 {
			 conn=dm.getConnection();
			 System.out.println("conn:"+conn);
			 String sql="INSERT INTO food_category VALUES("
					   +"(SELECT NVL(MAX(no)+1,1) FROM food_category),?,?,?,?)";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, vo.getTitle());
			 ps.setString(2, vo.getSubject());
			 ps.setString(3, vo.getPoster());
			 ps.setString(4, vo.getLink());
			 // 실행
			 ps.executeUpdate(); // COMMIT
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 dm.disConnection(conn, ps);
		 }
	 }
	 public List<FoodCategoryVO> foodCategoryData(int index)
	 {
		 List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
		 try
		 {
			 conn=dm.getConnection();
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
			 dm.disConnection(conn, ps);
		 }
		 return list;
	 }
	 
	 
	 
	 public List<FoodCategoryVO> foodCategoryLinkData()
	 {
		 List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
		 try
		 {
			 conn=dm.getConnection();
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
			 dm.disConnection(conn, ps);
		 }
		 return list;
	 }
	 /*
	  *   NO      NOT NULL NUMBER         
		CNO              NUMBER         
		POSTER  NOT NULL VARCHAR2(4000) 
		TITLE   NOT NULL VARCHAR2(200)  
		SCORE   NOT NULL NUMBER(2,1)    
		ADDRESS NOT NULL VARCHAR2(300)  
		TEL     NOT NULL VARCHAR2(30)   
		TYPE    NOT NULL VARCHAR2(100)  
		PRICE   NOT NULL VARCHAR2(50)   
		PARKING          VARCHAR2(20)   
		TIME             VARCHAR2(50)   
		MENU             VARCHAR2(1000) 
		GOOD             NUMBER         
		SOSO             NUMBER         
		BAD              NUMBER   
	  */
	 public void foodInsert(FoodHouseVO vo)
	 {
		 try
		 {
			 conn=dm.getConnection();
			 String sql="INSERT INTO food_house VALUES("
					   +"(SELECT NVL(MAX(no)+1,1) FROM food_house),"
					   +"?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 ps=conn.prepareStatement(sql);
			 //?에 값을 채운다
			 ps.setInt(1, vo.getCno());
			 ps.setString(2, vo.getPoster());
			 ps.setString(3, vo.getTitle());
			 ps.setDouble(4, vo.getScore());
			 ps.setString(5, vo.getAddress());
			 ps.setString(6, vo.getTel());
			 ps.setString(7, vo.getType());
			 ps.setString(8, vo.getPrice());
			 ps.setString(9, vo.getParking());
			 ps.setString(10, vo.getTime());
			 ps.setString(11, vo.getMenu());
			 ps.setInt(12, vo.getGood());
			 ps.setInt(13,vo.getSoso());
			 ps.setInt(14, vo.getBad());
			 
			 ps.executeUpdate();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 dm.disConnection(conn, ps);
		 }
	 }
}








