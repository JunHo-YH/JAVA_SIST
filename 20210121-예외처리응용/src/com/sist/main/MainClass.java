package com.sist.main;

/*
 * 예외처리
 *  => 직접 처리 => 복구 (try ~ catch)
 *  Exception(전체 예외 처리), Throwable(전체 예외+에러)
 *  
 *  1. 컴파일 에러 (javac): 에러가 발생
 *  2. 실행시 에러 (java)
 *     = 웹, 네트워크
 *     
 *  => 간접 처리 => 자바 시스템 (JVM)에 에러 발생을 알려주고 떠맡긴다
 *               throws => 메서드 뒤에서 선언
 *               => 라이브러리에서 주로 프로그래머에 떠맡긴다(pass)	
 *      
 */
public class MainClass {
	public void a() {

	}

	public void b() {

	}

	public void c() {

	}

	public void d() {

	}

	public void e() {

	}

	public static void main(String[] args) {
		MainClass m = new MainClass();
		m.a();
		m.b();
	}

}
