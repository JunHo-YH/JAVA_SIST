package com.sist.dao;
import java.sql.*;
// VO , DAO
/*
 *    SQL 
 *     = DML (������ ���۾��)
 *         = SELECT : ������ �˻� 
 *             = JOIN
 *             = SUBQUERY
 *         = INSERT : ������ �߰�
 *         = UPDATE : ������ ���� 
 *         = DELETE : ������ ���� 
 *     = DDL (������ ������) => �������� (PRIMARY KEY , FOREIGN KEY , CHECK , UNIQUE , DEFAULT)
 *         = CREATE : ����
 *            TABLE , VIEW , INDEX , SEQUENCE , PROCEDURE , FUNCTION , TRIGGER
 *         = ALTER : ����
 *         = DROP : ����
 *         = TRUNCATE : �߶󳻱�
 *         = RENAME : �̸����� 
 *     = DCL (������ ������)
 *         = GRENT : ���� �ο�
 *         = REVOKE : ���� ���� 
 *     = TCL (Ʈ����� ������)
 *         = COMMIT
 *         = ROLLBACK
 *         
 *    PL/SQL 
 *       ===
 *    ==
 *    �Լ��� ����� ��� : ����
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 1. Driver��� => Oracle���� 
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	// 2. ���� 
        	String url="jdbc:oracle:thin:@localhost:1521:XE";// ����Ŭ �ּ�
        	Connection conn=DriverManager.getConnection(url,"hr","happy");
        	// 3. SQL���� ����
        	String sql="SELECT empno,ename,job,hiredate,sal FROM emp WHERE ename LIKE '%T%'";
        	//           startsWith
        	// ����Ŭ => ��ҹ��� ������ ���� (��� => Ű����� �빮�ڷ� �Ѵ�)
        	// class,interface => �빮�� ���� , ����,�޼ҵ� => �ҹ���
        	/*
        	 *   class mainclass
        	 *   {
        	 *      
        	 *   }
        	 *   
        	 *   Mainclass mainclass=new Mainclass();
        	 */
        	PreparedStatement ps=conn.prepareStatement(sql);// ���� 
        	/*
        	 *    empno
        	 *    ename
        	 *    job
        	 *    mgr
        	 *    hiredate
        	 *    sal
        	 *    comm
        	 *    deptno
        	 */
        	// 4. ����� �޾Ƽ� ��� 
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())// ���پ� �о� �´� => �����Ͱ� ������ (false)
        	{
        		System.out.println(
        			rs.getInt(1)+" "
        			+rs.getString(2)+" "
        			+rs.getString(3)+" "
        			+rs.getDate(4)+" "
        			+rs.getInt(5)
        		);
        	}
        }catch(Exception ex) 
        {
        	ex.printStackTrace();
        }
	}

}











