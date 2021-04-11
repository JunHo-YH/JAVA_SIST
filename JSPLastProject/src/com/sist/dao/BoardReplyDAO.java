package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sist.controller.RequestMapping;
import com.sist.vo.BoardReplyVO;
import com.sist.vo.DataBoardVO;

public class BoardReplyDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static BoardReplyDAO dao;
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
	   // DAO  객체를 클라이언트당 1개씩만 사용 => 싱글턴 
	   public static BoardReplyDAO newInstance()
	   {
		   if(dao==null)
			   dao=new BoardReplyDAO();
		   
		   return dao;
			   
	   }
	   
	   // 자료실 목록 출력 
	   public List<BoardReplyVO> boardReplyListData(int page)
	   {
		   List<BoardReplyVO> list=new ArrayList<BoardReplyVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,subject,name,regdate,hit,group_tab,num "
					     +"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
					     +"FROM (SELECT no,subject,name,regdate,hitgroup_tab "
					     +"FROM project_BoardReply ORDER BY no DESC, group_step ASC)) "
					     +"WHERE num BETWEEN ? AND ?";
			   int rowSize=10;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   BoardReplyVO vo=new BoardReplyVO();
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
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
	   // 총페이지 구하기
	   public int boardReplyTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/10.0) FROM project_BoardReply";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   // 에러 처리
			   ex.printStackTrace();
		   }
		   finally
		   {
			   // 반환 
			   disConnection();
		   }
		   return total;
	   }
	   // insert
	   public void boardReplyInsert(BoardReplyVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO BoardReply(no,name,subject,content,pwd) "
					     +"VALUES((SELECT NVL(MAX(no)+1,1) FROM BoardReply),?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setString(2, vo.getSubject());
			   ps.setString(3, vo.getContent());
			   ps.setString(4, vo.getPwd());
			   
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
	 
	   // detail
	   public BoardReplyVO boardReplyDetailData(int no)
	   {
		   BoardReplyVO vo=new BoardReplyVO();
		   try
		   {
			   getConnection();
			   String sql="UPDATE project_boardReply SET "
					     +"hit=hit+1 "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
			   
			   sql="SELECT no,name,subject,content,regdate,hit "
				  +"FROM project_boardReply "
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
			   ex.printStackTrace();
		   }
           finally
           {
        	   disConnection();
           }
		   return vo;
	   }
	   
	   @RequestMapping("boardreply/insert.do")
	   public String boardReply_insert(HttpServletRequest request, HttpServletResponse response) {
		   
		   
		   request.setAttribute("main_jsp", "../boardreply/insert.jsp");
		   return "../main/main.jsp";
	   }
	   
}
