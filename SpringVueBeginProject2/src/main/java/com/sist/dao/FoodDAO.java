package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *   메모리 할당하는 어노테이션 
 *   @Component
 *   @Repository
 *   @Service
 *   @Controller
 *   @RestController
 *   주입하는 어노테이션(클래스 객체 주소)  
 *   @Autowired
 *   @Qualifier : 특정 객체를 지정 (id)
 *   @Resource : 단점 (jdk1.9이상에서는 지원하지 않는다=> jaxb(X))
 *   
 *   MyBatis => SqlSessionFactory => XML 파싱 , getConnection,disConnection 
 *              => getSqlSession() => 처리 (DML)
 */
@Repository
public class FoodDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *    <select id="foodCategoryData" resultType="FoodCategoryVO">
		   SELECT no,title,subject,poster
		   FROM food_category
		  </select>
		  <select id="foodListData" resultType="FoodVO" parameterType="int">
		   SELECT no,poster,title,score,address,tel
		   FROM food_house
		   WHERE cno=#{cno}
		  </select>
		  
		  MVC => M : @Controller
		         V : JSP(Jquery) => JSP(VueJS,ReactJS:View ) => native모바일(5G)
		                                속도 , 재사용(Component) : 우아한 형제들  => Mobx , Saga => MVC
		                                         Vuex , Redux
		             ======================================
		                         목록(List) ================================= JSON (RestController)
		                         일반데이터 (총페이지)=> int ,String  =========== JSON
		         C : DispatcherServlet (Controller)
		         
		         => NodeJS , Spring
	 */
	// [{},{}..] => [] , {}
	public List<FoodCategoryVO> foodCategoryData(Map map)
	{
		return getSqlSession().selectList("foodCategoryData",map);
	}
	// []
	public List<FoodVO> foodListData(int cno)
	{
		return getSqlSession().selectList("foodListData", cno);
	}
	/*
	 *  <select id="foodCategoryInfoData" resultType="FoodCategoryVO" parameterType="int">
		    SELECT title,subject FROM food_category
		    WHERE no=#{no}
		  </select>
	 */
	//{}
	public FoodCategoryVO foodCategoryInfoData(int no)
	{
		return getSqlSession().selectOne("foodCategoryInfoData", no);
	}
	/*
	 *  <select id="foodDetailData" resultType="FoodVO" parameterType="int">
		    SELECT * FROM food_house
		    WHERE no=#{no}
		  </select>
	 */
	//{}
	public FoodVO foodDetailData(int no)
	{
		return getSqlSession().selectOne("foodDetailData", no);
	}
   
}














