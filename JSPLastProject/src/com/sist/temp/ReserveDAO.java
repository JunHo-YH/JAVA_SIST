package com.sist.temp;
import java.util.*;
import java.sql.*;
public class ReserveDAO {
	  private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  public ReserveDAO()
	  {
		  try
		  {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch(Exception ex) {}
	  }
	  public void getConnection()
	  {
		  try
		  {
			  conn=DriverManager.getConnection(URL,"hr","happy");
		  }catch(Exception ex) {}
		  
	  }
	  public void disConnection()
	  {
		  try
		  {
			  if(ps!=null) ps.close();
			  if(conn!=null) ps.close();
		  }catch(Exception ex) {}
	  }
	  // 맛집=>예약일 등록 
	  public void foodReserveDate(int no, String rday)
	  {
		  try
		  {
			  getConnection();
			  String sql="UPDATE food_house SET "
					    +"rdays=? "
					    +"WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, rday);
			  ps.setInt(2, no);
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
	  
	  public void rdayInsert(int no,String time)
	  {
		  try
		  {
			  getConnection();
			  String sql="INSERT INTO rday VALUES(?,?)";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ps.setString(2, time);
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
}








