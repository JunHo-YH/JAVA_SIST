package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class MovieDAO extends SqlSessionDaoSupport{
	// SqlSessionFactory
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
    /*
     *   <select id="movieListData" resultType="MovieVO" parameterType="hashmap">
		    SELECT mno,title,poster,num
		    FROM (SELECT mno,title,poster,rownum as num 
		    FROM (SELECT /*+ INDEX_ASC(naver_movie NM_MNO_PK)  mno,title,poster
		    FROM naver_movie
		       <include refid="movie-where"/>
		    ))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="movieTotalPage" resultType="int" parameterType="hashmap">
		    SELECT COUNT(*) FROM naver_movie
		       <include refid="movie-where"/>
		  </select>
     */
	public List<MovieVO> movieListData(Map map) 
	{
		List<MovieVO> list=null;
		try
		{
			list=getSqlSession().selectList("movieListData",map);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	public int movieTotalPage(Map map)
	{
		int total=0;
		try
		{
			total=getSqlSession().selectOne("movieTotalPage",map);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return total;
	}
	/*
	 * <select id="movieDetailData" resultType="MovieVO" parameterType="int">
		   SELECT title,poster,genre,director,actor,story
		   FROM naver_movie
		   WHERE mno=#{mno}
		  </select>
	 */
	public MovieVO movieDetailData(int mno)
	{
		MovieVO vo=null;
		try
		{
			vo=getSqlSession().selectOne("movieDetailData",mno);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return vo;
	}
   
}






