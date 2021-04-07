package com.sist.dao;
import java.util.*;
import javax.sql.*;

import com.sist.vo.FoodCategoryVO;
import com.sist.vo.FoodJjimVO;
import com.sist.vo.FoodReplyVO;
import com.sist.vo.FoodVO;
import com.sist.vo.RecipeVO;
import com.sist.vo.ReserveVO;

import java.sql.*;
import javax.naming.*;
public class FoodDAO {
   // 연결 객체
   private Connection conn;
   // SQL문장 전송 
   private PreparedStatement ps;
   // 미리 생성된 Connection객체 읽기
   private static FoodDAO dao;
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
   public static FoodDAO newInstance()
   {
	   if(dao==null)
		   dao=new FoodDAO();
	   
	   return dao;
		   
   }
   // Category 읽기
   public List<FoodCategoryVO> foodCategoryData()
   {
	   List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
	   try
	   {
		   // 연결
		   getConnection();
		   // SQL문장
		   String sql="SELECT no,poster,title,subject "
				     +"FROM food_category "
				     +"ORDER BY no ASC";
		   // 전송 객체 생성
		   ps=conn.prepareStatement(sql);
		   // 실행 
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   FoodCategoryVO vo=new FoodCategoryVO();
			   vo.setNo(rs.getInt(1));
			   vo.setPoster(rs.getString(2));
			   vo.setTitle(rs.getString(3));
			   vo.setSubject(rs.getString(4));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();// 반환
	   }
	   return list;
   }
   // Category Data
   public List<FoodVO> foodCategoryHouseData(int cno)
   {
	   List<FoodVO> list=new ArrayList<FoodVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT poster,title,address,no,score "
				     +"FROM food_house "
				     +"WHERE cno=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, cno);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   FoodVO vo=new FoodVO();
			   vo.setPoster(rs.getString(1));
			   vo.setTitle(rs.getString(2));
			   vo.setAddress(rs.getString(3));
			   vo.setNo(rs.getInt(4));
			   vo.setScore(rs.getDouble(5));
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
   public FoodCategoryVO foodCategoryInfoData(int cno)
   {
	   FoodCategoryVO vo=new FoodCategoryVO();
	   try
	   {
		   getConnection();
		   String sql="SELECT title,subject "
				     +"FROM food_category "
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
   
   // food => cookie에 출력할 데이터 
   public FoodVO foodCookiePrintData(int no)
   {
	   FoodVO vo=new FoodVO();
	   try
	   {
		   getConnection();
		   String sql="SELECT no,poster,title "
				     +"FROM food_house "
				     +"WHERE no=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   // 실행
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setNo(rs.getInt(1));
		   String s=rs.getString(2);
		   vo.setPoster(s.substring(0,s.indexOf("^")));
		   vo.setTitle(rs.getString(3));
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
   /*
    *  NO      NOT NULL NUMBER         
	CNO              NUMBER         
	POSTER  NOT NULL VARCHAR2(4000) 
	TITLE   NOT NULL VARCHAR2(200)  
	SCORE   NOT NULL NUMBER(2,1)    
	ADDRESS NOT NULL VARCHAR2(300)  
	TEL     NOT NULL VARCHAR2(30)   
	TYPE    NOT NULL VARCHAR2(100)  
	PRICE   NOT NULL VARCHAR2(50)   
	PARKING          VARCHAR2(500)  
	TIME             VARCHAR2(500)  
	MENU             VARCHAR2(2000) 
	GOOD             NUMBER         
	SOSO             NUMBER         
	BAD              NUMBER 
    */
   // 상세보기
     public FoodVO foodDetailData(int no)
	 {
		 FoodVO vo=new FoodVO();
		 try
		 {
			 getConnection();
			 String sql="SELECT no,poster,title,address,tel,price,parking,time,NVL(menu,'no'),"
					   +"score,good,soso,bad,type "
					   +"FROM food_house "
					   +"WHERE no=?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, no);
			 // 결과값 받기
			 ResultSet rs=ps.executeQuery(); // row단위
			 rs.next();
			 vo.setNo(rs.getInt(1));
			 vo.setPoster(rs.getString(2));
			 vo.setTitle(rs.getString(3));
			 vo.setAddress(rs.getString(4));
			 vo.setTel(rs.getString(5));
			 vo.setPrice(rs.getString(6));
			 vo.setParking(rs.getString(7));
			 vo.setTime(rs.getString(8));
			 vo.setMenu(rs.getString(9));
			 vo.setScore(rs.getDouble(10));
			 vo.setGood(rs.getInt(11));
			 vo.setSoso(rs.getInt(12));
			 vo.setBad(rs.getInt(13));
			 vo.setType(rs.getString(14));
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
     
     // 레시피 읽기 
     public List<RecipeVO> foodSameRecipeData(String type)
     {
    	 List<RecipeVO> list=new ArrayList<RecipeVO>();
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,poster,title,chef,hit,rownum "
    				   +"FROM recipe "
    				   +"WHERE REGEXP_LIKE(title,?) AND rownum<=5";
    		 ps=conn.prepareStatement(sql);
    		 if(type.equals("기타 양식"))
    		 {
    			 type="기타|양식";
    		 }
    		 ps.setString(1, type.replace("/", "|").replace(" ", ""));
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 RecipeVO vo=new RecipeVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setPoster(rs.getString(2));
    			 vo.setTitle(rs.getString(3));
    			 vo.setChef(rs.getString(4));
    			 vo.setHit(rs.getString(5));
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
     
     // 댓글 읽기
     public List<FoodReplyVO> foodReplyReadData(int cno)
     {
    	 List<FoodReplyVO> list=new ArrayList<FoodReplyVO>();
    	 try
    	 {
    		 // 연결
    		 getConnection();
    		 String sql="SELECT no,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') "
    				   +"FROM project_reply "
    				   +"WHERE cno=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, cno);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 FoodReplyVO vo=new FoodReplyVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setId(rs.getString(2));
    			 vo.setName(rs.getString(3));
    			 vo.setMsg(rs.getString(4));
    			 vo.setDbday(rs.getString(5));
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
     // 댓글 올리기
     public void foodReplyInsert(FoodReplyVO vo)
     {
    	 try
    	 {
    		 getConnection();
    		 String sql="INSERT INTO project_reply VALUES("
    				   +"pr_no_seq.nextval,?,?,?,?,SYSDATE)";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, vo.getCno());
    		 ps.setString(2, vo.getId());
    		 ps.setString(3, vo.getName());
    		 ps.setString(4, vo.getMsg());
    		 
    		 // 실행
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
     // 댓글 수정
     public void foodReplyUpdate(FoodReplyVO vo)
     {
    	 try
    	 {
    		 getConnection();
    		 String sql="UPDATE project_reply SET "
    				   +"msg=? "
    				   +"WHERE no=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, vo.getMsg());
    		 ps.setInt(2, vo.getNo());
    		 
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
     // 댓글 삭제
     public void foodReplyDelete(int no)
     {
    	 try
    	 {
    		 getConnection();
    		 String sql="DELETE FROM project_reply "
    				   +"WHERE no=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, no);
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
     // 찜하기
     public void foodJjimInsert(int no,String id)
     {
    	 try
    	 {
    		 getConnection();
    		 String sql="INSERT INTO project_jjim VALUES("
    				   +"pj_no_seq.nextval,?,?)";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(2, no);
    		 ps.setString(1, id);
    		 
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
     // 찜하기 체크
     public int foodJjimCheck(int cno,String id)
     {
    	 int count=0;
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT COUNT(*) FROM project_jjim "
    				   +"WHERE cno=? AND id=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, cno);
    		 ps.setString(2, id);
    		 ResultSet rs=ps.executeQuery();
    		 rs.next();
    		 count=rs.getInt(1);
    		 rs.close();
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return count;
     }
     // 찜 목록 
     public List<FoodJjimVO> foodJjimListData(String id)
     {
    	 List<FoodJjimVO> list=new ArrayList<FoodJjimVO>();
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,cno "
    				   +"FROM project_jjim "
    				   +"WHERE id=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, id);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 FoodJjimVO vo=new FoodJjimVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setCno(rs.getInt(2));
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
     public List<FoodVO> foodLocationFind(String gu)
     {
    	 List<FoodVO> list=new ArrayList<FoodVO>();
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,title,poster "
    				   +"FROM food_house "
    				   +"WHERE address LIKE '%'||?||'%'";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, gu);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 FoodVO vo=new FoodVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setTitle(rs.getString(2));
    			 vo.setPoster(rs.getString(3));
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
     
     public List<FoodVO> foodReserveAllData()
     {
    	 List<FoodVO> list=new ArrayList<FoodVO>();
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,title,poster,tel "
    				   +"FROM food_house "
    				   +"ORDER BY no ASC";
    		 ps=conn.prepareStatement(sql);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 FoodVO vo=new FoodVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setTitle(rs.getString(2));
    			 String s=rs.getString(3);
    			 s=s.substring(0,s.indexOf("^"));
    			 vo.setPoster(s);
    			 vo.setTel(rs.getString(4));
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
     
     public String foodReserveDate(int no)
     {
    	 String rday="";
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT rdays FROM food_house "
    				   +"WHERE no=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, no);
    		 ResultSet rs=ps.executeQuery();
    		 rs.next();
    		 rday=rs.getString(1);
    		 rs.close();
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return rday;
     }
     
     public String foodReserveTimeData(int day)
     {
    	 String time="";
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT tno FROM rday "
    				   +"WHERE no=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, day);
    		 ResultSet rs=ps.executeQuery();
    		 rs.next();
    		 time=rs.getString(1);
    		 rs.close();
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return time;
     }
     
     public String foodReserveGetTime(int no)
     {
    	 String time="";
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT time FROM rtime "
    				   +"WHERE no=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, no);
    		 ResultSet rs=ps.executeQuery();
    		 rs.next();
    		 time=rs.getString(1);
    		 rs.close();
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return time;
     }
     
     // 예약저장 
     public void foodReserveSave(ReserveVO vo)
     {
    	 try
    	 {
    		 getConnection();
    		 String sql="INSERT INTO project_reserve VALUES("
    				   +"(SELECT NVL(MAX(no)+1,1) FROM project_reserve),?,?,?,?,?,"
    				   +"0,SYSDATE)";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, vo.getId());
    		 ps.setString(2, vo.getTitle());
    		 ps.setString(3, vo.getDay());
    		 ps.setString(4, vo.getTime());
    		 ps.setString(5, vo.getInwon());
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
     public void reserve_ok(int no)
     {
    	 try
    	 {
    		 getConnection();
    		 String sql="UPDATE project_reserve SET "
    				   +"state=1 "
    				   +"WHERE no=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, no);
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
     
     public List<ReserveVO> mypage_data(String id)
     {
    	 List<ReserveVO> list=new ArrayList<ReserveVO>();
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,title,day,time,inwon,state,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') "
    				   +"FROM project_reserve "
    				   +"WHERE id=? "
    				   +"ORDER BY no DESC";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, id);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 ReserveVO vo=new ReserveVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setTitle(rs.getString(2));
    			 vo.setDay(rs.getString(3));
    			 vo.setTime(rs.getString(4));
    			 vo.setInwon(rs.getString(5));
    			 vo.setState(rs.getInt(6));
    			 vo.setDbday(rs.getString(7));
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
     
     public List<ReserveVO> adminpage_data()
     {
    	 List<ReserveVO> list=new ArrayList<ReserveVO>();
    	 try
    	 {
    		 getConnection();
    		 String sql="SELECT no,title,day,time,inwon,state,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),id "
    				   +"FROM project_reserve "
    				   +"ORDER BY no DESC";
    		 ps=conn.prepareStatement(sql);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 ReserveVO vo=new ReserveVO();
    			 vo.setNo(rs.getInt(1));
    			 vo.setTitle(rs.getString(2));
    			 vo.setDay(rs.getString(3));
    			 vo.setTime(rs.getString(4));
    			 vo.setInwon(rs.getString(5));
    			 vo.setState(rs.getInt(6));
    			 vo.setDbday(rs.getString(7));
    			 vo.setId(rs.getString(8));
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








