package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;

@Controller
public class RecipeController {
	@Autowired
	@Qualifier("dao") // RecipeDAO에 @Repository("dao")아이디가 없으면 RecipeDAO가 아이디가 돼서 @Qualifier("recipeDAO")로 적는다.
	private RecipeDAO dao;
	
	@GetMapping(value="recipe/list.do",produces="text/plain;charset=UTF-8")
	public String recipe_list(String page) {
		String json = "";
		try {
			if(page==null)
				page="1";
			int curpage=Integer.parseInt(page);
			int rowSize=12;
			int start=(rowSize*curpage) - (rowSize-1);
			int end = (rowSize*curpage);
			Map map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			List<RecipeVO> list = dao.recipeListData(map);
			// 배열[]로 만들어서 보내기
			JSONArray arr = new JSONArray();
			for(RecipeVO vo : list) {
				JSONObject obj = new JSONObject();
				obj.put("no", vo.getNo());
				obj.put("title", vo.getTitle());
				obj.put("poster", vo.getPoster());
				obj.put("chef", vo.getChef());
				arr.add(obj);
			}
			json = arr.toJSONString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return json;
	}
	
}
