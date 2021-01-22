package com.sist.string;

/*
 * trim(): 좌우에 있는 공백문자 제거
 * 		ex) "  Heelo Java ".trim() ==> "Hello Java" 가운데 공백은 제거하지 않는다. 좌우의 공백만 제거
 *      사용) 검색어, 로그인 처리, 아이디 중복체크, 게시판 비밀번호 처리
 * 리턴형: String
 * 매개변수: 없음
 * 원형: public String trim()
 * 
 * valueOf(): 모든 데이터형을 문자열로 변환할 때 사용
 *            100 => "100"
 *            true = > "true"
 * 리턴형: String
 * 원형: public static String valueOf(데이터형)
 * 
 * 100 => int a = 100;
 *        String s = (String)a; => (X)
 *                   a.toString() (X)
 *                   String.valueOf(a)
 * String s = "Hello Java";
 * String s1 = "Oracle";
 * substring(0,3)
 * Web, Widow => String
 */
public class MainClass8 {
	public static void main(String[] args) {
		String msg = " Hello Java ";
		System.out.println(msg);
		System.out.println(msg.length());
	
		String msg2 = msg.trim();
		System.out.println(msg2);
		System.out.println(msg2.length());
		System.out.println(String.valueOf(100));
		
		
		int a = 100;
		int b = 200;
		String s = String.valueOf(a); // s = "100"
		String s1 = String.valueOf(b); // b = "200"
		String s2 = String.valueOf(true); // s2 = "true"
		String s3 = String.valueOf(10.5); // s3 = "10.5"
		
	}

}
