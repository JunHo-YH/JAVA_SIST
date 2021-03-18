package com.sist.dao;
/*
 *    JDBC ===> DBCP ====> ORM (Mybatis:DBCP가 포함)
 *    1. 보안 
 *    2. 오라클 연결에 소모되는 시간을 줄일 수 있다
 *    3. Connection객체 메모리를 낭비하지 않는다 (Connection일정하게)
 *    4. 웹애플리케이션(사이트)에서 한번에 많은 접속자 들어와도 쉽게 무너지지 않는다
 *    5. 사이트를 만들때 일반화되어 있다 
 *    <Resource 
           driverClassName="oracle.jdbc.driver.OracleDriver"
           url="jdbc:oracle:thin:@localhost:1521:XE"
           username="hr"
           password="happy"
           maxActive="10"  -> 접속자가 증가가 되면 최대 10개까지 만들어라
           maxIdle="5"  ----> 톰캣 Connection객체를 5개를 만들어라
           maxWait="-1"  ---> 계속 기다려라 
           name="jdbc/oracle" -> 미리생성된 Connection을 찾아 온다 
           type="javax.sql.DataSource" -> DataSource를 이용해서 
                                          찾은 Connection주소 저장 
           auth="Container" : 관리자 (톰캣)
        />
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class MovieDAO {
	  private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  public MovieDAO()
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
			  conn=DriverManager.getConnection(URL,"system","happy");
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
	  // 기능 
	  public ArrayList<MovieVO> movieListData()
	  {
		  ArrayList<MovieVO> list=new ArrayList<MovieVO>();
		  try
		  {
			  getConnection();
			  // 인기순위(10) , 공지사항 5개...
			  String sql="SELECT mno,poster,title,rownum "
					    +"FROM daum_movie "
					    +"WHERE rownum<=20";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  MovieVO vo=new MovieVO();
				  vo.setMno(rs.getInt(1));
				  vo.setTitle(rs.getString(3));
				  vo.setPoster(rs.getString(2));
				  
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
	  
	  // 상세보기 
	  public MovieVO movieDetailData(int mno)
	  {
		  /*
		   *  private String poster,title,director,actor,regdate,
                             genre,nation,grade,time,showUser,
                             boxoffice,story,key;
              private double score;
		   */
		  MovieVO vo=new MovieVO();
		  try
		  {
			  getConnection();
			  String sql="SELECT poster,title,regdate,genre,nation,grade,time,"
					    +"showUser,boxoffice,story,key,score "
					    +"FROM daum_movie "
					    +"WHERE mno=?";
			  ps=conn.prepareStatement(sql);
			  // ? 에 값을 채운다
			  ps.setInt(1, mno);
			  
			  ResultSet rs=ps.executeQuery();
			  rs.next();// row
			  vo.setPoster(rs.getString(1));
			  vo.setTitle(rs.getString(2));
			  vo.setRegdate(rs.getString(3));
			  vo.setGenre(rs.getString(4));
			  vo.setNation(rs.getString(5));
			  vo.setGrade(rs.getString(6));
			  vo.setTime(rs.getString(7));
			  vo.setShowUser(rs.getString(8));
			  vo.setBoxoffice(rs.getString(9));
			  vo.setStory(rs.getString(10));
			  vo.setKey(rs.getString(11));
			  vo.setScore(rs.getDouble(12));
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


























