/* 
 *  자바 표현법
 *  ========
 *  	1. 숫자
 *  		 = 10, 20, 30 ==> 10진법
 *    		 = 012, 013, 011 ==> 8진법
 *      	 = 0xFF ==> 16진법
 *        	 = 0b0001010 ==> 2진법
 *  		==================	
 *  			0 => 8진법
 *  			0x => 16진법
 *  			0b => 2진법
 *  		==================
 *  	2. 문자 : 문자 한 개	'A' '홍'
 *  	3. 문자열 : 문자 여러 개  "ABC" "홍길동"
 *  	4. 논리 : True / False
 * 
 * 
 * */

// 한 줄 주석 => 컴파일(기계어 변환) => 컴파일에서 제외가 되는 부분
// 주석: 도움말 => 소스 분석

/*
 *  < 프로그램 >
 *  =================================
 *  1. 대소문자 구분
 *  2. 명령문이 종료 되면 ';' (한 개의 명령)
 *  ================================= 1,2번은 이클립스에서 에러를 바로 잡아분다.
 *  3. 들여쓰기 (에러처리가 안됨)
 *  
 *  4. 약속
 *  ====================== 한글도 가능
 *   1) 클래스명 : 대문자 시작
 *   2) 변수명 : 소문자 시작
 *   3) 메소드명 : 소문자 시작
 *  
 *  
 *  
 *  class A
 *  {
	 *  public void main()
	 *  {
	 *  System.out.println("ABCD");
	 *  System.out.println("ABCD");
	 *  System.out.println("ABCD");
	 *  }
 *  }
 * 
 * */
public class MainClass {
	// 자동으로 첫번째로 읽어서 처리 (main => 모든 프로그램에 한 개 이상은 존재해야한다)
	// 시작
	public static void main(String[] args) {
		// 소스를 코딩하는 위치
		System.out.println("Hello Java"); // 명령문
		// ln => new Line
		System.out.println("ABCD");
		System.out.println('A');
		System.out.println(true);
		System.out.println(false);
		System.out.println(011);
		System.out.println(0b01111);
		System.out.println(0xFB);
		System.out.println(10);
		// 출력 방법 3가지
		System.out.print("Hello");
		System.out.print("Java");

		// 명령을 내린다. => 순서로 처리 (알고리즘) : 순서도
		              // =========
	}
	/*
	 * MainClass.java ==========> MainClass.class ======> "Hello" javac java
	 * 
	 */
}
