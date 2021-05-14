package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *   �޸� �Ҵ��ϴ� ������̼� 
 *   @Component
 *   @Repository
 *   @Service
 *   @Controller
 *   @RestController
 *   �����ϴ� ������̼�(Ŭ���� ��ü �ּ�)  
 *   @Autowired
 *   @Qualifier : Ư�� ��ü�� ���� (id)
 *   @Resource : ���� (jdk1.9�̻󿡼��� �������� �ʴ´�=> jaxb(X))
 *   
 *   MyBatis => SqlSessionFactory => XML �Ľ� , getConnection,disConnection 
 *              => getSqlSession() => ó�� (DML)
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
		         V : JSP(Jquery) => JSP(VueJS,ReactJS:View ) => native�����(5G)
		                                �ӵ� , ����(Component) : ����� ������  => Mobx , Saga => MVC
		                                         Vuex , Redux
		             ======================================
		                         ���(List) ================================= JSON (RestController)
		                         �Ϲݵ����� (��������)=> int ,String  =========== JSON
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














