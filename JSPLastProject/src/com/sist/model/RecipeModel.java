package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class RecipeModel {
   @RequestMapping("recipe/recipe_list.do")
   public String recipe_list(HttpServletRequest request,HttpServletResponse response)
   {
	    // list.do?page= => ""  list.do => null
	    // if(page.equals(""))  if(page==null) 
	    String page=request.getParameter("page");
	    if(page==null)
	    	page="1";
	    int curpage=Integer.parseInt(page);
	    RecipeDAO dao=RecipeDAO.newInstance();
	    List<RecipeVO> rList=dao.recipeListData(curpage);
	    int count=dao.recipeCount();
	    int totalpage=(int)(Math.ceil(count/12.0));
	    
	    final int BLOCK=10;
	    //102  [1]-[10] [91]~[100] [101][102]
	    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	    // 1~10 => 1  10-1/10 => 0  9/10
	    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	    // 1~10 => 10
	    // 11~20 => 11~20
	    
	    if(endPage>totalpage)
	    	endPage=totalpage;
	    
	    request.setAttribute("count", count); // ${count}
	    // <%= request.getAttribute("count") %>
	    request.setAttribute("rList", rList);
	    
	    request.setAttribute("block", BLOCK);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("totalpage", totalpage);
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("main_jsp", "../recipe/recipe_list.jsp");
	    return "../main/main.jsp";
	    // return "redirect:../board/list.do"
   }
}












