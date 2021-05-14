package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class TotalRestController {
    @Autowired
    private TotalDAO dao;
    
    @GetMapping(value="total/movie.do",produces="text/plain;charset=UTF-8")
    public String total_movie()
    {
    	String json="";
    	try
    	{
    		// title,poster,mno
    		List<MovieVO> list=dao.totalMovieListData();
    		System.out.println(list);
    		JSONArray arr=new JSONArray();
    		for(MovieVO vo:list)
    		{
    			JSONObject obj=new JSONObject();
    			obj.put("mno", vo.getMno());
    			obj.put("title", vo.getTitle());
    			obj.put("poster", vo.getPoster());
    			arr.add(obj);
    		}
    		json=arr.toJSONString();
    		System.out.println("movie-json:"+json);
    	}catch(Exception ex){ex.printStackTrace();}
    	return json;
    }
    @GetMapping(value="total/food.do",produces="text/plain;charset=UTF-8")
    public String total_food()
    {
    	String json="";
    	try
    	{
    		// title,poster,mno
    		List<FoodVO> list=dao.totalFoodListData();
    		JSONArray arr=new JSONArray();
    		// title,poster,tel
    		for(FoodVO vo:list)
    		{
    			JSONObject obj=new JSONObject();
    			obj.put("tel", vo.getTel());
    			obj.put("title", vo.getTitle());
    			obj.put("poster", vo.getPoster());
    			arr.add(obj);
    		}
    		json=arr.toJSONString();
    		System.out.println("food-json:"+json);
    	}catch(Exception ex){}
    	return json;
    }
}














