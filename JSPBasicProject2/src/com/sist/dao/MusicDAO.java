package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MusicDAO {
	private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  public MusicDAO()
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
	  // 전체 페이지
	  public ArrayList<MusicVO> musicListData()
	  {
		  ArrayList<MusicVO> list=new ArrayList<MusicVO>();
		  try
		  {
			  getConnection();
			  // 인기순위(10) , 공지사항 5개...
			  /*
			   * NO           NUMBER(3)     
				TITLE        VARCHAR2(300) 
				SINGER       VARCHAR2(200) 
				ALBUM        VARCHAR2(200) 
				POSTER       VARCHAR2(260) 
			   */
			  String sql="SELECT no,title,singer,album,poster "
					    +"FROM MUSIC_GENRE "
					    +"WHERE rownum<=20";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  MusicVO vo=new MusicVO();
				  vo.setNo(rs.getInt(1));
				  vo.setTitle(rs.getString(2));
				  vo.setSinger(rs.getString(3));
				  vo.setAlbum(rs.getString(4));
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
	  
	  
	  //상세보기
	  public MusicVO musicDetailData(int no) {
		  /*
		   * private int no, idcrement;
			private String title, singer, album, poster, state;
		   */

		  MusicVO vo = new MusicVO();
		  try {
			  
			  getConnection();
			  String sql = "SELECT no, idcrement, title, singer, album, poster, state "
			  			+ "FROM MUSIC_GENRE "
			  			+ "WHERE no = ?";
			  ps = conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ResultSet rs = ps.executeQuery();
			  rs.next();
			  vo.setNo(rs.getInt(1));
			  vo.setIdcrement(rs.getInt(2));
			  vo.setTitle(rs.getString(3));
			  vo.setSinger(rs.getString(4));
			  vo.setAlbum(rs.getString(5));
			  vo.setPoster(rs.getString(6));
			  vo.setState(rs.getString(7));
			  rs.close();
			  
			  
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }finally {
			  disConnection();
		  }
		  return vo;
	  }
}
