package com.sist.main;
/*
 * 제어자 (page 344)
 * ================
 * 접근 지정어: public, protected, default, private
 * 클래스
 * =====
 *      클래스: public, default
 *      멤버변수: public, protected, default, private
 *      
 *      메서드:  public, protected, default, private
 *      생성자:  public, protected, default, private 
 *      =====> 메서드와 생성자는다른 클래스와 연결을 위한 목적이 크므로 public 사용을 권장
 *      
 *      final, static, abstract, synchronized
 *      =====
 *      상속을 할 수 없는 클래스, 상수
 *      static: 공통적인
 *      abstract: 추상적인 => 구현하지 않고 선언만
 *      synchronized: 동기화, 비동기화
 *                    ====
 *                    메서드는 기본적으로 동기화
 *                    
 *      사용방법 (353page)
 *      클래스
 *      접근지정어 옵션 class className
 *              [final, abstract]
 *      [public, dafault]
 *      
 *      
 *      public final class
 *      public abstract class
 *      
 *      (default) final class
 *      (default) abstract class
 *      =============================
 *      
 *      메서드
 *      접근지정어 옵션	리턴형 메서드명()
 *      ======= === 
 *      접근지정어: [public|private|default|protected]
 *      옵션: [final|abstract|static]
 *      
 *      멤버변수
 *      접근지정어 옵션 데이터형 변수명
 *      ======= ===
 *      접근지정어: [public|private|default|protected]
 *      옵션: [final|static]
 *      
 *      => 접근지정어 옵션
 *         public static
 *      => 옵션 접근지정어
 *         static public2
 *      
 */

class Student {
	private int hakbun;
	public String name;
	protected String sex;
	int kor;

	public Student() {
	}

	protected Student(int a) {
	}

	Student(int a, int b) {
	}

	private Student(int a, int b, int c) {
	}

}

public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
