package com.sist.math;
/*
 *   Wrapper : 기본데이터형을 클래스화 시킨 클래스들의 집합 
 *   =======
 *     정수형 
 *       byte     =============  Byte
 *       short    =============  Short
 *       int      =============  *****Integer  변환) 문자열 => 정수 : parseInt("문자열") 
 *                                    => 에러 (정수변환이 안될때 NumberFormatException)
 *                                    => http://localhost/board/list.jsp?page=true 
 *                                       String page=request.getParameter("page");
 *                                       int page=Integer.parseInt(page);
 *                                       String s="1";
 *                                       if(s.equals("1"))
 *                                         page=1  ==> 21억 4천 
 *       long     =============  *****Long  => Long.parseLong("100")
 *     실수형
 *       float    =============  Float
 *       double   =============  *****Double => Double.parseDouble("10.5")
 *     문자형
 *       char     ============= Character
 *     논리형 
 *       boolean  ============= *****Boolean  => Boolean.parseBoolean("true")
 *       
 *     ===> 데이터형처럼 사용이 가능 
 *     Integer i=10;
 *     int j=i;
 *     
 *     
 */
import java.util.Scanner;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 숫자 입력:");
        String s1=scan.next();
        int i=Integer.parseInt(s1.trim());// 공백문자 제거후 정수형으로 변환
        System.out.print("두번째 숫자 입력:");
        String s2=scan.next();
        int j=Integer.parseInt(s2.trim());
        // 연산자 
        System.out.println(s1+s2);
        System.out.println(i+j);*/
		int i=100;
		Integer ii=i;//오토박싱
		int j=ii;//언박싱
		// 일반데이터형 <=> 클래스형 
		Boolean boo=true;
		boolean b=boo;
		Long l=10L;
		long l2=l;
		Double d=10.5;
		double d2=d;
		
		String ss="true";
		boolean bb=Boolean.parseBoolean(ss); // true
		
		String ss1="10.5";
		double dd=Double.parseDouble(ss1);
		
		String ss2="10000000000000000";
		long ll=Long.parseLong(ss2);
		
		System.out.println(bb);
		System.out.println(dd);
		System.out.println(ll);
		
		int k1=Integer.parseInt("1000",2);// 2진법 표현  => 100 => 4
		int k2=Integer.parseInt("1000"); //1000 (10진법 표현)
		int k3=Integer.parseInt("100",8);// 64 
		/*
		 *       1  0  0
		 *      8^2 8^1 8^0
		 */
		int k4=Integer.parseInt("FF",16);// F=>15  15*16+15
		System.out.println(k1);
		System.out.println(k2);
		System.out.println(k3);
		System.out.println(k4);
		/*
		 *   자바에서 숫자 표현 
		 *   2진법
		 *   8진법
		 *   16진법
		 *   10진법
		 */
		int k5=789;
		System.out.println(Integer.toBinaryString(k5));//2 ***
		System.out.println(Integer.toHexString(k5));//16
		System.out.println(Integer.toOctalString(k5));//8
		
		Integer k6=10;
		String sss=k6.toString();// 문자열 변환 ***
		Integer k7=20;
		
		System.out.println(k6+k7);
		
		
		long lll=10; // lll=10L
		Long k8=lll; // Long클래스안에는 반드시 long만 사용할 수 있다
		
	}

}




















