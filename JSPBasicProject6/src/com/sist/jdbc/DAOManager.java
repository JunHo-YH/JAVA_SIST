package com.sist.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAOManager {
	private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  public DAOManager()
	  {
		  try
		  {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch(Exception ex) {}
	  }
	  public Connection getConnection()
	  {
		  try
		  {
			  conn=DriverManager.getConnection(URL,"hr","happy");
		  }catch(Exception ex) {}
		  
		  return conn;
	  }
	  public void disConnection(Connection conn,PreparedStatement ps)
	  {
		  try
		  {
			  if(ps!=null) ps.close();
			  if(conn!=null) ps.close();
		  }catch(Exception ex) {}
	  }
}
