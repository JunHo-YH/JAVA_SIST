package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class TotalDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *  <select id="totalFoodListData" resultType="FoodVO">
		    SELECT /*+ INDEX_ASC(food_house fh1_no_pk)title,poster,tel,rownum
		    FROM food_house
		    WHERE rownum&lt;=10
		  </select>
	 */
	public List<FoodVO> totalFoodListData()
	{
		return getSqlSession().selectList("totalFoodListData");
	}
	/*
	 * <select id="totalMovieListData" resultType="MovieVO">
	    SELECT /*+ INDEX_ASC(daum_movie dm_mno_pk) title,poster,mno,rownum
	    FROM daum_movie
	    WHERE rownum&lt;=10;
	  </select>
	 */
	public List<MovieVO> totalMovieListData()
	{
		return getSqlSession().selectList("totalMovieListData");
	}
   
}
