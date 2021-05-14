package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
// VueJs로 값을 전송 
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   //@GetMapping("food/category.do","text/plain;charset=UTF-8")
   //@GetMapping("text/plain;charset=UTF-8","food/category.do",)
   @GetMapping(value="food/category.do",produces="text/plain;charset=UTF-8")
   public String food_category(int no)
   {
	   String json="";
	   try
	   {
		   // DAO에서 값을 읽어 온다 
		   Map map=new HashMap();
		   int start=0;
		   int end=0;
		   if(no==1)
		   {
			   start=1;
			   end=12;
		   }
		   else if(no==2)
		   {
		       start=13;
		       end=18;
		   }
		   else if(no==3)
		   {
			   start=19;
			   end=30;
		   }
		   map.put("start", start);
		   map.put("end", end);
		   List<FoodCategoryVO> list=dao.foodCategoryData(map);
		   //[{},{},{}] => [] => List  , {} => VO
		   JSONArray arr=new JSONArray();
		   for(FoodCategoryVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("no", vo.getNo());
			   obj.put("title", vo.getTitle());
			   obj.put("poster", vo.getPoster());
			   obj.put("subject", vo.getSubject());
			   // 배열에 첨부
			   arr.add(obj);
		   }
		   
		   json=arr.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
   
   @GetMapping(value="food/category_list.do",produces="text/plain;charset=UTF-8")
   public String food_category_list(int cno)
   {
	   // no,poster,title,score,address,tel
	   String json="";
	   try
	   {
		   List<FoodVO> list=dao.foodListData(cno);
		   JSONArray arr=new JSONArray();
		   for(FoodVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   String img=vo.getPoster();
			   img=img.substring(0,img.indexOf("^"));
			   obj.put("no",vo.getNo());
			   obj.put("poster", img);
			   obj.put("title", vo.getTitle());
			   obj.put("score", vo.getScore());
			   obj.put("address", vo.getAddress().substring(0,vo.getAddress().lastIndexOf("지")));
			   obj.put("tel", vo.getTel());
			   // {no:1...}
			   arr.add(obj);
		   }
		   json=arr.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
   @GetMapping(value="food/category_info.do",produces="text/plain;charset=UTF-8")
   public String category_info(int cno)
   {
	   String json="";
	   try
	   {
		   FoodCategoryVO vo=dao.foodCategoryInfoData(cno);
		   JSONObject obj=new JSONObject();
		   obj.put("title", vo.getTitle());
		   obj.put("subject", vo.getSubject());
		   json=obj.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
   
   /*
    *  private int no,cno,good,soso,bad;
       private double score;
       private String poster,title,address,tel,type,price,parking,time,menu,rdays;
    */
   @GetMapping(value="food/food_detail.do",produces="text/plain;charset=UTF-8")
   public String food_detail(int no)
   {
	   String json="";
	   try
	   {
		   FoodVO vo=dao.foodDetailData(no);
		   //{}
		   JSONObject obj=new JSONObject();
		   obj.put("title", vo.getTitle());
		   obj.put("poster", vo.getPoster());
		   obj.put("score", vo.getScore());
		   obj.put("address", vo.getAddress().substring(0,vo.getAddress().lastIndexOf("지")));
		   obj.put("tel", vo.getTel());
		   obj.put("price", vo.getPrice());
		   obj.put("type", vo.getType());
		   obj.put("parking", vo.getParking());
		   obj.put("menu", vo.getMenu());
		   obj.put("good", vo.getGood());
		   obj.put("bad", vo.getBad());
		   obj.put("soso", vo.getSoso());
		   
		   json=obj.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
}














