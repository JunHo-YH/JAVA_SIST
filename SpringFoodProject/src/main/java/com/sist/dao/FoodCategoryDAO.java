package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.FoodCategoryVO;

// 스프링에서 메모리 할당
/*
 * 스프링에서 어노테이션으로 메모리 할당 (기능별 분리)
 * @Component: 일반 클래스 (MainClass, ~Manager...)
 * @Repository: 저장소 (DAO) => 오라클, 몽고, MySQL ...
 * @Service: BI (통합) => DAO + DAO => DAO통합
 * @Controller: Model클래스 => 화면 변경(파일명을 전송) => sendRedirect(), forward()
 * @RestController: Model클래스 ==> 필요한 데이터만 전송할 때(Ajax, VueJS, React) => 일반 문자열, JSON, XML
 */
import java.util.*;

@Repository
public class FoodCategoryDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 기능만들기
	public List<FoodCategoryVO> foodCategoryListData(int no) {
		return getSqlSession().selectList("foodCategoryListData",no);
	}
	
}
