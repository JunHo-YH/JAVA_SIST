package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.manager.*;
import java.util.*;
@Controller
public class NewsController {
  @Autowired
  private NewsManager mgr;
  @GetMapping("news/list.do")
  public String news_list(Model model)
  {
	  model.addAttribute("main_jsp", "../news/list.jsp");
	  return "main/main";
  }
  
  //axios.get  axios.post
  @GetMapping(produces="text/plain;charset=UTF-8",value="news/news_list.do")
  @ResponseBody
  public String news_news_list(String fd)
  {
	  String json="";
	  try
	  {
		  List<Item> list=mgr.newsFindData(fd);
		  JSONArray arr=new JSONArray();//[] => [{title:'',de...},{},{}...] => {Å°:°ª.....} JS(JavaScript)O(Object)N
		  for(Item i:list)
		  {
			  JSONObject obj=new JSONObject();
			  obj.put("title", i.getTitle());
			  obj.put("desc", i.getDescription());
			  obj.put("author", i.getAuthor());
			  obj.put("link", i.getLink());
			  arr.add(obj);
		  }
		  json=arr.toJSONString();
	  }catch(Exception ex){}
	  return json;
  }
}














