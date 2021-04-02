package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MainModel {
  @RequestMapping("main/main.do")
  public String main_home(HttpServletRequest request,HttpServletResponse response)
  {
	  // 쿠키 
	  List<FoodVO> fList=new ArrayList<FoodVO>();
	  
	  FoodDAO dao=FoodDAO.newInstance();
	  
	  Cookie[] cookies=request.getCookies();
	  if(cookies!=null)
	  {
		  for(int i=cookies.length-1;i>=0;i--)
		  {
			  if(cookies[i].getName().startsWith("m"))
			  {
				  cookies[i].setPath("/");
				  System.out.println(cookies[i].getName());
				  String no=cookies[i].getValue();
				  FoodVO vo=dao.foodCookiePrintData(Integer.parseInt(no));
				  fList.add(vo);
			  }
		  }
	  }
	  request.setAttribute("fList", fList);
	  List<FoodCategoryVO> cList=dao.foodCategoryData();
	  request.setAttribute("cList", cList);
	  request.setAttribute("main_jsp", "../main/home.jsp");
	  return "../main/main.jsp";
  }
}











