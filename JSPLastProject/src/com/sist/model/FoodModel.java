package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
/*
 *   MVC => Model,View,Controller
 *          =====
 *          요청처리 = Spring(Controller) , Struts(Action)
 *          public void display(@Parameter B b)
 */
import com.sist.controller.RequestMapping;
import com.sist.dao.FoodDAO;

import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.vo.*;
/*
 *    1) ../food/food_category.do?cno=1 => 사용자 요청 (jsp파일에 있다)
 *    =========================
 *    2) DispatcherServlet 
 *       => @RequestMapping("food/food_category.do")
 *    3) FoodModel 
 *    4) FoodDAO 
 *    5) DispatcherServlet
 *    6) food_category.jsp 에서 출력 
 */
@Controller
public class FoodModel {
  @RequestMapping("food/food_category.do")
  public String food_category(HttpServletRequest request,HttpServletResponse response)
  {
	  String cno=request.getParameter("cno");
	  // DAO연결 {no:1,name:"",}
	  FoodDAO dao=FoodDAO.newInstance();// 오라클연동 
	  List<FoodVO> list=dao.foodCategoryHouseData(Integer.parseInt(cno));
	  for(FoodVO vo:list)
	  {
		  String poster=vo.getPoster();
		  poster=poster.substring(0,poster.indexOf("^"));
		  vo.setPoster(poster);
	  }
	  FoodCategoryVO vo=dao.foodCategoryInfoData(Integer.parseInt(cno));
	  request.setAttribute("list", list);
	  request.setAttribute("vo", vo);
	  request.setAttribute("main_jsp", "../food/food_category.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/detail_before.do")
  public String detail_before(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  System.out.println(no);
	  Cookie cookie=new Cookie("m"+no, no);// 문자열만 저장이 가능 
	  cookie.setMaxAge(60*60);
	  cookie.setPath("/");
	  response.addCookie(cookie);
	  return "redirect:../food/food_detail.do?no="+no;
  }
  @RequestMapping("food/food_detail.do")
  public String food_detail(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  // DAO연결 
	  FoodDAO dao=FoodDAO.newInstance();
	  FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
	  List<RecipeVO> list=dao.foodSameRecipeData(vo.getType());
	  List<FoodReplyVO> rList=dao.foodReplyReadData(Integer.parseInt(no));
	  request.setAttribute("rList", rList);
	  request.setAttribute("list", list);
	  request.setAttribute("vo", vo);
	  request.setAttribute("main_jsp", "../food/food_detail.jsp");
	  
	  HttpSession session=request.getSession();
	  String id=(String)session.getAttribute("id");
	  int count=dao.foodJjimCheck(Integer.parseInt(no), id);
	  request.setAttribute("count", count);
	  return "../main/main.jsp";
  }
  
  @RequestMapping("food/food_reply_insert.do")
  public String food_reply_insert(HttpServletRequest request,HttpServletResponse response)
  {
	  // 댓글 데이터 받기 
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String cno=request.getParameter("cno");
	  String msg=request.getParameter("msg");
	  HttpSession session=request.getSession();
	  String id=(String)session.getAttribute("id");
	  String name=(String)session.getAttribute("name");
	  FoodReplyVO vo=new FoodReplyVO();
	  vo.setName(name);
	  vo.setMsg(msg);
	  vo.setId(id);
	  vo.setCno(Integer.parseInt(cno));
	  //DAO연결 
	  FoodDAO dao=FoodDAO.newInstance();
	  dao.foodReplyInsert(vo);
	  return "redirect:../food/food_detail.do?no="+cno;
  }
  // 댓글 삭제
  @RequestMapping("food/food_reply_delete.do")
  public String food_reply_delete(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  String cno=request.getParameter("cno");
	  FoodDAO dao=FoodDAO.newInstance();
	  //DB연동 
	  dao.foodReplyDelete(Integer.parseInt(no));
	  return "redirect:../food/food_detail.do?no="+cno;
  }
  // http://localhost/JSPLastProject/food/food_detail.do?no=2
  // 댓글 수정 
  @RequestMapping("food/food_reply_update.do")
  public String food_reply_update(HttpServletRequest request,HttpServletResponse response)
  {
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String msg=request.getParameter("msg");
	  String no=request.getParameter("no");
	  String cno=request.getParameter("cno");
	  FoodReplyVO vo=new FoodReplyVO();
	  vo.setNo(Integer.parseInt(no));
	  vo.setMsg(msg);
	  FoodDAO dao=FoodDAO.newInstance();
	  dao.foodReplyUpdate(vo);
	  return "redirect:../food/food_detail.do?no="+cno;
  }
  // 찜하기 
  @RequestMapping("food/jjim.do")
  public String food_jjim(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  HttpSession session=request.getSession();
	  String id=(String)session.getAttribute("id");
	  
	  FoodDAO dao=FoodDAO.newInstance();
	  // 저장 
	  dao.foodJjimInsert(Integer.parseInt(no), id);
	  return "redirect:../food/food_detail.do?no="+no;
  }
  // 마이페이지 설정 
  @RequestMapping("food/mypage.do")
  public String food_mypage(HttpServletRequest request,HttpServletResponse response)
  {
	  HttpSession session=request.getSession();
	  String id=(String)session.getAttribute("id");
	  // DB연동 
	  FoodDAO dao=FoodDAO.newInstance();
	  // 1. 찜하기 목록
	  List<FoodJjimVO> jList=dao.foodJjimListData(id);
	  List<FoodVO> fList=new ArrayList<FoodVO>();
	  for(FoodJjimVO vo:jList)
	  {
		  FoodVO fvo=dao.foodDetailData(vo.getCno());
		  String poster=fvo.getPoster();
		  poster=poster.substring(0,poster.indexOf("^"));
		  fvo.setPoster(poster);
		  fList.add(fvo);
	  }
	  request.setAttribute("fList", fList);
	  request.setAttribute("jList", jList);
	  // 2. 예약 목록 
	  List<ReserveVO> rList=dao.mypage_data(id);
	  request.setAttribute("rList", rList);
	  request.setAttribute("main_jsp", "../food/mypage.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/reserve.do")
  public String food_reserve(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../food/reserve.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/date.do")
  public String movie_date(HttpServletRequest request,HttpServletResponse response)
  {
	   String strYear=request.getParameter("year");
	   String strMonth=request.getParameter("month");
	   
	   String today=new SimpleDateFormat("yyyy-M-d").format(new Date());
	   StringTokenizer st=new StringTokenizer(today,"-");
	   
	   String sy=st.nextToken();
	   String sm=st.nextToken();
	   String sd=st.nextToken();
	   
	   if(strYear==null)
		   strYear=sy;
	   if(strMonth==null)
		   strMonth=sm;
	   
	   int year=Integer.parseInt(strYear);
	   int month=Integer.parseInt(strMonth);
	   int day=Integer.parseInt(sd);
	   
	   
	   String[] strWeek={"일","월","화","수","목","금","토"};
	   
	   int total=(year-1)*365
			    +(year-1)/4
			    -(year-1)/100
			    +(year-1)/400;
	   
	   int[] lastDay={31,28,31,30,31,30,
			          31,31,30,31,30,31};
	   
	   if((year%4==0 && year%100!=0)||(year%400==0))
		   lastDay[1]=29;
	   else
		   lastDay[1]=28;
		
	   for(int i=0;i<month-1;i++)
	   {
		   total+=lastDay[i];
	   }
	   
	   total++;
	   
	   int week=total%7;
	   
	   String no=request.getParameter("no");
	   FoodDAO dao=FoodDAO.newInstance();
	   String rday=dao.foodReserveDate(Integer.parseInt(no));
	   /*
	    *    1,2,3,4,5,6,7,8,10
	    *    int[] arr=new int[10];
	    *    
	    *    arr[0]=11
	    *    arr[1]=21
	    *    arr[2]=31
	    *    --
	    *    arr[9]=10
	    *    
	    *    int[] arr={1,2,3,4,5,6,7}
	    *    int[] arr1={0,2,0,0,5,0,0}
	    *    
	    *    arr[i]==arr1[i] 2,5
	    */
	   
	   int[] days=new int[31];
	   if(rday!=null)
	   {
		   // 1,2,3,7,8,10...
		   StringTokenizer st1=new StringTokenizer(rday,",");
		   while(st1.hasMoreTokens())
		   {
			  int p=Integer.parseInt(st1.nextToken());// 31
			  if(p>=day)
			  {
			     days[p-1]=p;
			  }
		   }
	   }
	   request.setAttribute("days", days);
	   request.setAttribute("lastday", lastDay[month-1]);
	   request.setAttribute("week", week);
	   request.setAttribute("year", year);
	   request.setAttribute("month", month);
	   request.setAttribute("day", day);
	   request.setAttribute("strWeek", strWeek);
	   
	   return "../food/date.jsp";
  }
  @RequestMapping("food/location.do")
  public String food_location(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../food/location.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/location_result.do")
  public String food_location_result(HttpServletRequest request,HttpServletResponse response)
  {
	  String[] guList_1 = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
			    "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
			    "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
			    "강동구" };
	  String no=request.getParameter("no");
	  String gu=guList_1[Integer.parseInt(no)];
	  System.out.println(gu);
	  FoodDAO dao=FoodDAO.newInstance();
	  List<FoodVO> list=dao.foodLocationFind(gu);
	  /*
	   *   list.add("1")  
	   *   list.add("2") 
	   *   list.add("3") 
	   *   
	   *   => for(String s:list)
	   *        s=1,2,3  => s=1
	   *        s=2,3,4  => s=2
	   */
	  for(FoodVO vo:list)
	  {
		  String s=vo.getPoster();
		  s=s.substring(0,s.indexOf("^"));
		  vo.setPoster(s);
	  }
	  request.setAttribute("list", list);
	  return "../food/location_result.jsp";
  }
  @RequestMapping("food/reserve_foodhouse.do")
  public String reserve_foodhouse(HttpServletRequest request,HttpServletResponse response)
  {
	  FoodDAO dao=FoodDAO.newInstance();
	  List<FoodVO> list=dao.foodReserveAllData();
	  request.setAttribute("list", list);
	  return "../food/reserve_foodhouse.jsp";
  }
  @RequestMapping("food/time.do")
  public String food_time(HttpServletRequest request,HttpServletResponse response) 
  {
	  String day=request.getParameter("day");
	  // 시간을 읽어 온다 => 오라클 
	  FoodDAO dao=FoodDAO.newInstance();
	  String tno=dao.foodReserveTimeData(Integer.parseInt(day));
	  // 1="09:00",2,3,9,11
	  List<String> list=new ArrayList<String>();
	  StringTokenizer st=new StringTokenizer(tno,",");
	  while(st.hasMoreTokens())
	  {
		  String t=st.nextToken();
		  int i=Integer.parseInt(t);
		  String time=dao.foodReserveGetTime(i);
		  list.add(time);
	  }
	  
	  request.setAttribute("list", list);
	  return "../food/time.jsp";
  }
  @RequestMapping("food/inwon.do")
  public String food_inwon(HttpServletRequest request,HttpServletResponse response) 
  {
	  return "../food/inwon.jsp";
  }
  
  @RequestMapping("food/reserve_save.do")
  public String reserve_save(HttpServletRequest request,HttpServletResponse response) 
  {
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String title=request.getParameter("title");
	  String day=request.getParameter("day");
	  String time=request.getParameter("time");
	  String inwon=request.getParameter("inwon");
	  HttpSession session=request.getSession();
	  String id=(String)session.getAttribute("id");
	  
	  ReserveVO vo=new ReserveVO();
	  vo.setId(id);
	  vo.setTitle(title);
	  vo.setDay(day);
	  vo.setTime(time);
	  vo.setInwon(inwon);
	  
	  FoodDAO dao=FoodDAO.newInstance();
	  dao.foodReserveSave(vo);
	  
	  return "redirect:../food/mypage.do";
  }
  @RequestMapping("food/adminpage.do")
  public String food_adminpage(HttpServletRequest request,HttpServletResponse response)
  {
	  FoodDAO dao=FoodDAO.newInstance();
	  List<ReserveVO> list=dao.adminpage_data();
	  request.setAttribute("list", list);
	  request.setAttribute("main_jsp", "../food/adminpage.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/reserve_ok.do")
  public String food_reserve_ok(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  FoodDAO dao=FoodDAO.newInstance();
	  dao.reserve_ok(Integer.parseInt(no));
	  return "redirect:../food/adminpage.do";
  }
}










