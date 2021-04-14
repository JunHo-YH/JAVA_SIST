package com.sist.main2;

import org.mybatis.spring.support.SqlSessionDaoSupport;
/*					JDBC		MyBatis => 필요한 데이터는 XML, Annotation으로 전달
 * Connection	직접 생성			자동 생성
 * Statement	직접 전송			자동 전송
 * ResultSet	직접 처리			자동 생성
 * close		직접 처리			자동 처리
 * 
 * 								필요한 데이터
 * 								1) 오라클 정보 => DataSource
 *                              2) SQL문장 => mapper.xml
 *                              3) 결과값 받는 데이터형 설정 => resultType, parameterType
 *                              
 *  public List selectList() {
 *  	getConnection()
 *  ==============================
 *  	String sql=""
	==============================
 *  	ps=conn.preparedStatement(sql);
 *  ==============================
 *  	ps.setInt(1,no);
 *  ==============================
 *  	ResultSet rs = ps.executeQuery();
 *  	while(rs.next()) {
 *  ==============================
 *  		Vo vo = new VO();
 *  		vo.setXxx(rs.getString(1));
 *  		list.add(vo)
 *  ==============================
 *  	}
 *  	disConnection()
 *  }                            
 */
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport {
	public List<EmpVO> empAllData() {
		
		return getSqlSession().selectList("empAllData");
	}
	
	public EmpVO empDetailData(int empno) {
		return getSqlSession().selectOne("empDetailData",empno);
	}
}
