package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
@Repository("dao")
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map) {
		List<RecipeVO> list = null;
		try {
			list=mapper.recipeListData(map); // 디버깅
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	
	
}
