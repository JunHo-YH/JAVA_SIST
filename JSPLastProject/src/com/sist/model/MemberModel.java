package com.sist.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.FoodDAO;
import com.sist.dao.MemberDAO;
import com.sist.vo.FoodCategoryVO;
import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;

@Controller
public class MemberModel {
  @RequestMapping("member/join.do")
  public String member_join(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../member/join.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("member/post_result.do")
  public String member_post(HttpServletRequest request,HttpServletResponse response)
  {
	  System.out.println("OK");
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex){}
	  String dong=request.getParameter("dong");
	  System.out.println(dong);
	  MemberDAO dao=MemberDAO.newInstance();
	  List<ZipcodeVO> list=dao.postFindData(dong);
	  request.setAttribute("list", list);
	  return "../member/post_result.jsp";
  }
  
  @RequestMapping("member/idcheck_result.do")
  public String idcheck(HttpServletRequest request,HttpServletResponse response)
  {
	  String id=request.getParameter("id");
	  MemberDAO dao=MemberDAO.newInstance();
	  int count=dao.idcheck(id);
	  request.setAttribute("count", count);
	  return "../member/idcheck_result.jsp";
  }
  @RequestMapping("member/join_ok.do")
  public String join_ok(HttpServletRequest request,HttpServletResponse response)
  {
	  /*
	   *    ID       NOT NULL VARCHAR2(20)  
			PWD      NOT NULL VARCHAR2(10)  
			NAME     NOT NULL VARCHAR2(34)  
			SEX               VARCHAR2(10)  
			BIRTHDAY NOT NULL VARCHAR2(20)  
			EMAIL             VARCHAR2(100) 
			POST     NOT NULL VARCHAR2(10)  
			ADDR1    NOT NULL VARCHAR2(200) 
			ADDR2             VARCHAR2(200) 
			TEL               VARCHAR2(20)  
			CONTENT           CLOB          
			ADMIN             CHAR(1) 
	   */

	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String id=request.getParameter("id");
	  String pwd=request.getParameter("pwd");
	  String name=request.getParameter("name");
	  String sex=request.getParameter("sex");
	  String birthday=request.getParameter("birthday");
	  String post=request.getParameter("post");
	  String addr1=request.getParameter("addr1");
	  String addr2=request.getParameter("addr2");
	  String tel1=request.getParameter("tel1");
	  String tel2=request.getParameter("tel2");
	  String content=request.getParameter("content");
	  String email=request.getParameter("email");
	  
	  MemberVO vo=new MemberVO();
	  vo.setAddr1(addr1);
	  vo.setAddr2(addr2);
	  vo.setBirthday(birthday);
	  vo.setContent(content);
	  vo.setEmail(email);
	  vo.setId(id);
	  vo.setPost(post);
	  vo.setPwd(pwd);
	  vo.setTel(tel1+"-"+tel2);
	  vo.setSex(sex);
	  vo.setName(name);
	  
	  // DAO전송
	  MemberDAO dao=MemberDAO.newInstance();
	  dao.memberJoin(vo);
	  return "redirect:../main/main.do";     // main.do에 있는 값을 읽고 다시 출력
	  //return "../main/main.jsp";
  }
  
}








