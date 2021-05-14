package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *  <select id="movieListData" resultType="MovieVO" parameterType="hashmap">
	 *///[]
	public List<MovieVO> movieListData(Map map)
	{
		return getSqlSession().selectList("movieListData",map);
	}
	
	// <select id="movieTotalPage" resultType="int">
	public int movieTotalPage()
	{
		return getSqlSession().selectOne("movieTotalPage");
	}
	// <select id="movieDetailData" resultType="MovieVO" parameterType="int">
	public MovieVO movieDetailData(int mno)
	{
		return getSqlSession().selectOne("movieDetailData",mno);
	}
   
}









