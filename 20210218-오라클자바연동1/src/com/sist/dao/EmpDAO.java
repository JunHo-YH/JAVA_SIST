package com.sist.dao;
// ��ɺ��� ����� 
/*
 *   �Խ��� (VO,DAO)
 *   ȸ��  (VO,DAO)
 *   ��ȭ  (VO,DAO)
 *   ����  (VO,DAO)
 *   --
 *   --
 *   --
 *   --
 */
/*
 *    1. SELECT 
 *       1) ����
 *          SELECT
 *          FROM
 *          WHERE
 *          GROUP BY
 *          HAVING
 *          ORDER BY
 *       2) ������ 
 *          IN , NULL(IS NULL, IS NOT NULL) , BETWEEN ~ AND , NOT
 *       3) �����Լ� 
 *          ���� : SUBSTR() , RPAD() , LENGTH()
 *          ���� : ROUND(), CEIL()
 *          ��¥ : SYSDATE 
 *          ��ȯ : TO_CHAR => ��¥ , �ð�  ==> YYYY(RRRR) , MM , DD , HH24 , MI , SS
 *                           ���� => 99,999
 *          �Ϲ� : NVL 
 *          ���� : MAX,COUNT, RANK() => AVG,SUM
 *       4) GROUP BY
 *       5) JOIN 
 *           INNER JOIN : EQUI_JOIN 
 *           OUTER JOIN : LEFT , RIGHT
 *       ===============================
 *       6) SUBQUERY => VIEW
 *          CREATE TABLE table_name
 *          AS
 *            SELECT~~
 *       ===============================
 *    2. INSERT
 *    3. UPDATE
 *    4. DELETE   ==> JDBC
 */
import java.util.*;
import java.sql.*;
/*
 *   class A
 *   
 *   A a;
 */
public class EmpDAO {
   //1. ���ᰴü,���۰�ü ���� 
   //1) ���� ��ü
   private Connection conn;//Scoket => TCP ==> null
   //2) SQL���� ���� => ������� �о���� ��ü 
   private PreparedStatement ps;
   //3) ����Ŭ ���� �ּ� 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // ���α׷� ���� => �ݵ�� ����̹� ��ġ (Ŭ����) => Ŭ������ ����ϸ� ����̹���ġ�� �ν� 
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   // 1. ���� 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   // => ����Ŭ�� ���� conn hr/happy
	   }catch(Exception ex) {}
   }
   //2. ���� ���� 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close(); // ����Ŭ�� ����� ���¶�� 
		   if(conn!=null) conn.close();
		   
		   // exit (����)
	   }catch(Exception ex) {}
   }
   
   // ��� ���� (SQL ���� ����)
   // 1. EMP�� ��� �����͸� ��� 
   // SQL : SELECT * FROM emp
   public void empAllData()
   {
	   try
	   {
		   // ���� 
		   getConnection();
		   // SQL������ �����
		   String sql="SELECT * FROM emp";
		   // SQL���� ����
		   ps=conn.prepareStatement(sql);
		   // ������� �޴´�
		   ResultSet rs=ps.executeQuery();
		   // ȭ�鿡 ��� => ������ , ���������Ʈ
		   /*
		    *    ������ : CHAR , VARCHAR2 , CLOB  => getString()
		    *    ��¥�� : DATE , TIMESTAMP  => getDate()
		    *    ������ : NUMBER => �Ҽ����� ���� ��� => getInt() 
		    *                     �Ҽ����� �ִ� ��� => getDouble()
		    */
		   while(rs.next())
		   {
			   System.out.println("���:"+rs.getInt(1));
			   System.out.println("�̸�:"+rs.getString(2));
			   System.out.println("����:"+rs.getString(3));
			   System.out.println("���:"+rs.getInt(4));
			   System.out.println("�Ի���:"+rs.getDate(5));
			   System.out.println("�޿�:"+rs.getInt(6));
			   System.out.println("������:"+rs.getInt(7));
			   System.out.println("�μ���ȣ:"+rs.getInt(8));
			   System.out.println("===================");
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // ����
		   disConnection();
	   }
   }
   // ���ϴ� �÷��� ��� => ename,job,hiredate,sal => �޼ҵ�� : empListData()
   public void empListData()
   {
	   try
	   {
		   // ���� 
		   getConnection();
		   // SQL������ �����
		   String sql="SELECT ename,job,hiredate,sal FROM emp";
		   // SQL���� ����
		   ps=conn.prepareStatement(sql);
		   // ������� �޴´�
		   ResultSet rs=ps.executeQuery();
		   // ȭ�鿡 ��� => ������ , ���������Ʈ
		   /*
		    *    ������ : CHAR , VARCHAR2 , CLOB  => getString()
		    *    ��¥�� : DATE , TIMESTAMP  => getDate()
		    *    ������ : NUMBER => �Ҽ����� ���� ��� => getInt() 
		    *                     �Ҽ����� �ִ� ��� => getDouble()
		    */
		   while(rs.next())
		   {
			   
			   System.out.println("�̸�:"+rs.getString(1));
			   System.out.println("����:"+rs.getString(2));
			   System.out.println("�Ի���:"+rs.getDate(3));
			   System.out.println("�޿�:"+rs.getInt(4));
			   System.out.println("===================");
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // ����
		   disConnection();
	   }
   }
   public void empOperationData()
   {
	   try
	   {
		   // ���� 
		   getConnection();
		   // SQL������ �����
		   String sql="SELECT ename,sal,comm,sal+NVL(comm,0) FROM emp";
		   // SQL���� ����
		   ps=conn.prepareStatement(sql);
		   // ������� �޴´�
		   ResultSet rs=ps.executeQuery();
		   // ȭ�鿡 ��� => ������ , ���������Ʈ
		   /*
		    *    ������ : CHAR , VARCHAR2 , CLOB  => getString()
		    *    ��¥�� : DATE , TIMESTAMP  => getDate()
		    *    ������ : NUMBER => �Ҽ����� ���� ��� => getInt() 
		    *                     �Ҽ����� �ִ� ��� => getDouble()
		    */
		   while(rs.next())
		   {
			   
			   System.out.println("�̸�:"+rs.getString(1));
			   System.out.println("�޿�:"+rs.getInt(2));
			   System.out.println("������:"+rs.getInt(3));
			   System.out.println("�޿�+������:"+rs.getInt(4));
			   System.out.println("===================");
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // ����
		   disConnection();
	   }
   }
   // 3. ����̸� (ename) , �޿�(sal) , ������(comm) , �ѱ޿� ���(sal+comm)  (���������) 
   // 4. SUBSTR�� �̿��ؼ� 81�⿡ �Ի��� ����� �̸� , �Ի��� , �޿� 
   //                                getString  getDate getInt
   public void empSubstrData()
   {
	   try
	   {
		   // ���� 
		   getConnection();
		   // SQL������ �����
		   String sql="SELECT ename,hiredate,sal FROM emp "
				     +"WHERE SUBSTR(hiredate,1,2)=81";
		   // SQL���� ����
		   ps=conn.prepareStatement(sql);
		   // ������� �޴´�
		   ResultSet rs=ps.executeQuery();
		   // ȭ�鿡 ��� => ������ , ���������Ʈ
		   /*
		    *    ������ : CHAR , VARCHAR2 , CLOB  => getString()
		    *    ��¥�� : DATE , TIMESTAMP  => getDate()
		    *    ������ : NUMBER => �Ҽ����� ���� ��� => getInt() 
		    *                     �Ҽ����� �ִ� ��� => getDouble()
		    */
		   while(rs.next())
		   {
			   
			   System.out.println("�̸�:"+rs.getString(1));
			   System.out.println("�Ի���:"+rs.getDate(2));
			   System.out.println("�޿�:"+rs.getInt(3));
			   System.out.println("===================");
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // ����
		   disConnection();
	   }
   }
   // emp���� A�� �����ϴ� ����� �̸��� ��� 
   // emp���� �޿��� 1500�̻� 3000������ ����� �̸�,�޿�,���� ��� 
   // emp���� 10,20�� �μ��� ����̸�,�޿�,����
   // emp���� �������� �޴� ����� ����̸�,�޿� ,������, ����
   public void empBetweenData()
   {
	   try
	   {
		   // ���� 
		   getConnection();
		   // SQL������ �����
		   //String sql="SELECT ename,sal,job FROM emp "
				     //+"WHERE sal BETWEEN 1500 AND 3000";
		   String sql="SELECT ename,sal,comm,job FROM emp "
				     +"WHERE comm IS NOT NULL AND comm<>0";
		   // SQL���� ����
		   ps=conn.prepareStatement(sql);
		   // ������� �޴´�
		   ResultSet rs=ps.executeQuery();
		   // ȭ�鿡 ��� => ������ , ���������Ʈ
		   /*
		    *    ������ : CHAR , VARCHAR2 , CLOB  => getString()
		    *    ��¥�� : DATE , TIMESTAMP  => getDate()
		    *    ������ : NUMBER => �Ҽ����� ���� ��� => getInt() 
		    *                     �Ҽ����� �ִ� ��� => getDouble()
		    */
		   while(rs.next())
		   {
			   
			   System.out.println("�̸�:"+rs.getString(1));
			   System.out.println("�޿�:"+rs.getInt(2));
			   System.out.println("������:"+rs.getInt(3));
			   System.out.println("����:"+rs.getString(4));
			   System.out.println("===================");
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // ����
		   disConnection();
	   }
   }
   // ���μ��� �ο��� , �ִ�޿� , �ּұ޿� , �޿��� , �޿���� 
   // �Ի�⵵��  
   // ������ 
   public void empGroupData(int n)
   {
	   try
	   {
		   getConnection();
		   String sql="";
		   if(n==1)
		   {
			   sql="SELECT deptno,COUNT(*),MAX(sal),MIN(sal),SUM(sal),AVG(sal) "
				  +"FROM emp "
				  +"GROUP BY deptno";   
		   }
		   else if(n==2)
		   {
			   sql="SELECT TO_CHAR(hiredate,'YYYY'),COUNT(*),MAX(sal),MIN(sal),SUM(sal),AVG(sal) "
				  +"FROM emp "
				  +"GROUP BY TO_CHAR(hiredate,'YYYY')"; 
		   }
		   else if(n==3)
		   {
			   sql="SELECT job,COUNT(*),MAX(sal),MIN(sal),SUM(sal),AVG(sal) "
				  +"FROM emp "
				  +"GROUP BY job"; 
		   }
		   
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   //��� �����ʹ� getString()�� �о� �� �� �ִ� 
		   while(rs.next())
		   {
		     System.out.println(rs.getString(1)+" "
				            +rs.getInt(2)+" "
				            +rs.getInt(3)+" "
				            +rs.getInt(4)+" "
				            +rs.getInt(5)+" "
				            +rs.getInt(6)
				   );
		     System.out.println("=======================================");
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // ������ ������ ��� DISTINCT  => SELECT DISTINCT job FROM emp;
   
   // emp���� �̸� , ���� , �Ի��� , �޿� , �μ���, �ٹ��� , �޿� ��� ���  ==> empJoinData()
   public void empJoinData()
   {
	   try
	   {
		   getConnection();
		   // SQL����
		   String sql="SELECT ename,job,hiredate,sal,dname,loc,grade "
				     +"FROM emp,dept,salgrade "
				     +"WHERE emp.deptno=dept.deptno "
				     +"AND sal BETWEEN losal AND hisal";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   System.out.println(
				  rs.getString(1)+" "	   
				 +rs.getString(2)+" "
				 +rs.getDate(3)+" "
				 +rs.getInt(4)+" "
				 +rs.getString(5)+" "
				 +rs.getString(6)+" "
				 +rs.getInt(7)
			   );
			   
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   public static void main(String[] args) {
	   EmpDAO dao=new EmpDAO();
	   //1. ������ ��ü ��� ==> SELECT * FROM table_name
	   //dao.empAllData();
	   //2. �ʿ��� �÷��� ��� 
	   //dao.empListData();
	   //3. ������ 
	   //dao.empOperationData();
	   // SUBSTR
	   //dao.empSubstrData();
	   // BETWEEN ~ AND
	   //dao.empBetweenData();
	   //dao.empGroupData(1);
	   //dao.empGroupData(2);
	   //dao.empGroupData(3);
	   dao.empJoinData();
   }
}

















