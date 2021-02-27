package com.sist.dao;
import java.util.*;
import java.sql.*;
public class BoardDAO {
   // 1. ����Ŭ ���� ��ü
   private Connection conn; // Socket
   // 2. SQL������ �ۼ��� ��ü
   private PreparedStatement ps;//BufferedReader,OutputStream
   // JDBC => TCP�� �̿��ϴ� ���α׷� 
   // 3. URL(����Ŭ �ּ�)
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // ����Ŭ ������ ���� ����̹� ��ġ(�ѹ��� ��ġ)
   public BoardDAO()
   {
	   try
	   {
		   // ���÷��� => Ŭ������ ������ �о �޸� �Ҵ� 
		   Class.forName("oracle.jdbc.driver.OracleDriver");// Class.forName("��Ű����.Ŭ������");
		   
	   }catch(Exception ex) {}
   }
   
   // ����Ŭ ���� = �ݱ� 
   // 1. ���� conn hr/happy
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   /*
		    *   DriverManager (Factory Pattern)
		    *   => DML (ANSI) LIKE '%'||?||'%'  => REGEXP_LIKE()
		    */
	   }catch(Exception ex) {}
   }
   // 2. �ݱ� exit
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   
   // 3. �Խ��� ��� 
   // 3-1. ��� => �ζ��κ� (������ ������) =>  ArrayList<BoardVO>
   public ArrayList<BoardVO> boardListData(int page)
   {
	   // return selectList()
	   ArrayList<BoardVO> list=new ArrayList<BoardVO>();//list�ȿ� 10���� BoardVO
	   try
	   {
		   // 1. ����
		   getConnection();
		   // 2. SQL���� ����
		   String sql="SELECT no,subject,name,regdate,hit,num "
				     +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
				     +"FROM (SELECT no,subject,name,regdate,hit "
				     +"FROM webBoard ORDER BY no DESC)) "
				     +"WHERE num BETWEEN ? AND ?";
		   int rowSize=10;
		   int start=(rowSize*page)-(rowSize-1);// 1 11
		   int end = rowSize*page;//10  20
		   ps=conn.prepareStatement(sql);
		   // ? �� ���� ä��� 
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   // SQL���� �����û => ������� �޴´�
		   ResultSet rs=ps.executeQuery();
		   // rs�� �����ϴ� �����͸� list�� �߰� 
		   while(rs.next())
		   {
			   BoardVO vo=new BoardVO();
			   vo.setNo(rs.getInt(1));
			   vo.setSubject(rs.getString(2));
			   vo.setName(rs.getString(3));
			   vo.setRegdate(rs.getDate(4));
			   vo.setHit(rs.getInt(5));
			   list.add(vo);
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   // ����,���� => ������ ����Ŭ �ݴ´�
		   disConnection();
	   }
	   return list;
   }
   // 3-1-1. �Խù� �� ���� => ��ȣ�� ������� ��� 
   public int boardRowCount()
   {
	   int count=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT COUNT(*) FROM webBoard";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   count=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return count;
   }
   
   // 3-2. �߰� => INSERT => ������
   // 3-3. ���� => UPDATE => SQL (2��) 1.��й�ȣ Ȯ�� , 2. ���� => ���� ����? �帧
   // 3-4. ���� => DELETE => ��й�ȣ Ȯ�� 
   // 3-5. ���뺸�� => SQL(2��)
   public BoardVO boardDetailData(int no)
   {
	   BoardVO vo=new BoardVO();
	   try
	   {
		   // 1. ����
		   getConnection();
		   // 2. SQL���� ����
		   // ��ȸ�� ���� 
		   String sql="UPDATE webBoard SET "
				     +"hit=hit+1 "
				     +"WHERE no=?";
		   ps=conn.prepareStatement(sql);
		   // ?�� ���� ä��� 
		   ps.setInt(1, no);
		   // UPDATE�� ���� 
		   ps.executeUpdate(); // COMMIT
		   
		   // ������ ��ȸ���� �����ؼ� ������ �б�
		   sql="SELECT no,name,subject,content,regdate,hit "
			  +"FROM webBoard "
			  +"WHERE no=?";
		   
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setNo(rs.getInt(1));
		   vo.setName(rs.getString(2));
		   vo.setSubject(rs.getString(3));
		   vo.setContent(rs.getString(4));
		   vo.setRegdate(rs.getDate(5));
		   vo.setHit(rs.getInt(6));
		   
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return vo;
   }
   // 3-6. ã�� => LIKE
   
   
}








