package com.sist.dao;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class MemberDAO {
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
   // 기능 
   public String isLogin(String id,String pwd)
   {
	   String result="";
	   try
	   {
		   // 연결
		   getConnection();
		   String sql="SELECT COUNT(*) FROM webMember "
				     +"WHERE id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   int count=rs.getInt(1);
		   rs.close();
		   /////////////////// ID가 존재여부 
		   if(count==0) // ID가 없는 상태
		   {
			   result="NOID";
		   }
		   else // ID가 존재하는 상태
		   {
			   sql="SELECT pwd,name FROM webMember "
				  +"WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   String name=rs.getString(2);
			   rs.close();
			   
			   if(db_pwd.equals(pwd))
			   {
				   result=name;
			   }
			   else
			   {
				   result="NOPWD";
			   }
		   }
	   }catch(Exception ex)
	   {
		   // 오류처리
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 반환 
		   disConnection();
	   }
	   return result;
   }
}








