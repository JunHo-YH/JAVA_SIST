package com.sist.util;
/*
 *    java.lang.*
 *    ============
 *      Object , String , StringBuffer , Wrapper , Math
 *      => final Ŭ����(����� �޾Ƽ� �������̵��� �Ұ���)
 *    java.util.*
 *      = ���ڿ� �и� : StringTokenizer (split ��ü)
 *      = ��¥ ���� : Date , Calendar
 *      = ���� ���� : Random  => nextInt(10)
 *      = �ڷ� ���� : Collection
 *                  ========== List,Set,Map(interface) => �� �ٽ� 
 *    java.sql.* : ����Ŭ ���� 
 *      = Connection : ���� 
 *      = Statement : SQL���� ���� 
 *      = ResultSet : ������� �о� �´� 
 *    java.io.*
 *    java.net.*
 *      = URL 
 *      = URLEncoder
 *    ==================================================
 *    �� : javax~ (Servlet => JSP => Struts => Spring)
 *                ========   ====             ======= Maven
 *        Request , Response , Session , Cookie => Newwork
 */
import java.util.*; // * �� ��� Ŭ���� 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Random r=new Random();// �Ϲ� Ŭ���� 
        //int data=r.nextInt(10); // int���� (0~9)
        // 0~99 +1 1~100
        //System.out.println(data);
        int[] arr=new int[100];
        for(int i=0;i<100;i++)
        {
        	arr[i]=r.nextInt(10);
        }
        
        // ��� 
        for(int i=0;i<100;i++)
        {
        	if(i%10==0 && i!=0)
        	{
        		System.out.println();
        	}
        	System.out.print(arr[i]);
        }
	}

}



















