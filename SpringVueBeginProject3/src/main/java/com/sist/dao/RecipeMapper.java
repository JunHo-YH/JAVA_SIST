package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import java.util.*;
/*
 *  NO     NOT NULL NUMBER         
	POSTER          VARCHAR2(260)  
	TITLE           VARCHAR2(1000) 
	CHEF            VARCHAR2(200) 
 * 
 */
public interface RecipeMapper {
	@Select("SELECT no, poster, title, chef, num "
			+ "FROM (SELECT no, poster, title, chef,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk) */no, poster, title, chef "
			+ "FROM recipe)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
}
