package com.sist.dao;
// ����Ŭ �����ϴ� ���α׷� 
import java.util.*;// ArrayList
import java.sql.*;
public class MusicDAO {
   // �����ϴ� Ŭ���� 
   private Connection conn;//����Ŭ ���� 
   // SQL�������� �����ϴ� Ŭ���� 
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   //1. ���� ����̹� ��ġ => �ѹ��� ��� (������)
   public MusicDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   // 2. ���� 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   // ����Ŭ => conn hr/happy
	   }catch(Exception ex) {}
   }
   // 3. ����
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();// ���(�۽�:OutputStream,����:BufferReader)
		   if(conn!=null) conn.close();// ������: Socket
	   }catch(Exception ex) {}
   }
   // 4. ��� => ���������� 50���� �޾Ƽ� ���� ==> ����� ������ ���������� �о ��� 
   public ArrayList<MusicVO> musicListData()
   {
	   ArrayList<MusicVO> list=new ArrayList<MusicVO>();
	   try
	   {
		   // 1. ���� 
		   getConnection();
		   // 2. SQL������ �����
		   String sql="SELECT no,title,poster,singer,album,state,idcrement "
				     +"FROM genie_music "
				     +"ORDER BY 1";
		   ps=conn.prepareStatement(sql);// �����غ� 
		   // 3. SQL���� ���� 
		   ResultSet rs=ps.executeQuery();
		   // 4. ������� ������ �´� 
		   // 5. ArrayList�� ��´� 
		   /*
		    *    =================
		    *     no title...
		    *    =================
		    *     1    ==          | next()
		    *    =================
		    *     2    ==          | next()
		    *    =================
		    *     3    ==          | next()
		    *    =================
		    *     4    ==          | next()
		    *    =================
		    *                      | next() => false
		    *    
		    */
		   while(rs.next())
		   {
			   MusicVO vo=new MusicVO();
			   vo.setNo(rs.getInt(1));
			   vo.setTitle(rs.getString(2));
			   vo.setPoster(rs.getString(3));
			   vo.setSinger(rs.getString(4));
			   vo.setAlbum(rs.getString(5));
			   vo.setState(rs.getString(6));
			   vo.setIdcrement(rs.getInt(7));
			   list.add(vo);
		   }
		   rs.close();
		   // 6. ������ 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection(); // �ݱ� (����,���� => ������ ����Ŭ�� �ݴ´�)
	   }
	   return list;
   }
   
}













