/*
 * 	정리
 * 		기본형 데이터
 * 			====================================================
 * 				1byte		2byte		4byte		8byte
 *  		====================================================
 *  		정수	byte		short		int			long
 *  								  (default)
 *  								  System.out.println(100)
 *  													===== 컴퓨터에서 int로 인식
 *  						==> int와 long구분 ==> l(L)  예시) long데이터 출력 => 100L
 *   		====================================================
 *   		실수							float		double
 *   											   (default)
 *   								  			System.out.println(100.5)
 *   															  ======= 컴퓨터에서 double로 인식
 *   						==> float과 double을 구분 ==> f(F)
 *   							예시) 10.5F , 10.5
 *   								======   ======
 *   								float     double		
 *    		====================================================
 *    		문자				char			
 *    						문자 1개만 저장이 가능 ==> ''
 *     		====================================================
 *     		논리	boolean     항상 저장시에 true / false만 저장 가능
 *     		====================================================
*/
public class 변수_2 {

	public static void main(String[] args) {
//		변수 설정
		
		// (4byte)를 100으로 저장
		int x = 100; // 초기값
		
//		변수의 값을 변경 (가공 => 캐릭터가 이동 => x, y)
//		변경된 값을 출력
		//왼쪽으로 5만큼 이동
		 x = 95;
		 x = 90;
		 System.out.println("x = " + 90); // 문자열 결합 "Hello" + "Java" => "HelloJava"
		 // +는 산술연산과 문자열 결합을 하는 기능이다.
		 
		 char c = 'A';
		 // 'A'를 저장 => 'A'를 'B'로 바꾼다.
		 c = 'B';
		 System.out.println("최종 저장된 값은 " + c + "입니다.");
		 // 변수는 반드시 초기값을 대입해야한다.
		 // 4byte 정수를 3개를 만들고 100, 200, 300을 저장해라.
		 int a = 100;
		 int b = 200;
		 int d = 300;
		 
			/*
			 * 	1. 선언(변수 설정)
			 * 		= 선언과 동시에 초기값을 대입
			 * 			int a = 100; (default)
			 * 		= 선언하고 나중에 초기값을 대입
			 * 			int a;  ==> 입력을 받거나 외부에서 데이터를 갖고 올 때, 난수가 발생할 때
			 * 			a = 100;
			*/
		 
		 
		 float f = 10.9f; // float f = (float)10.9 ==> 형변환
		 // Up Casting (데이터형이 커진다) Down Casting (데이터형이 작아진다)
		 // 프로그램이 어려워지는 이유 : 같은 결과를 개발자마다 소스 코딩이 다르다.
		 
		 double q = 10.9;
		 double w = 100;
		 System.out.println(w);
		 // 100이 자동으로 100.0으로 바뀐다.
		 int u = 'A';
		 System.out.println("u : " + u);
		 System.out.println("w : " + w);
		 
		 // 값을 저장시에는 왼쪽에 있는 데이터형이 저장하는 값보다 항상 크거나 같아야 한다.
			/*
				데이터형의 크기
				===========
				byte < short, char < int < long < float < double
										  ==============
										  정수보다는 실수가 항상 크다.
				메모리 크기로 설정하는 것이 아니라 숫자를 표현할 수 있는 갯수로 설정한다.
				1
				1.0000000
				1.000000000000000
			*/
		 System.out.println("byte의 최소값: " + Byte.MIN_VALUE);
		 System.out.println("byte의 최대값: " + Byte.MAX_VALUE);
		 
		 System.out.println("int의 최소값 " + Integer.MIN_VALUE);
		 System.out.println("int의 최대값 " + Integer.MAX_VALUE);

		 System.out.println("long의 최소값 " + Long.MAX_VALUE);
		 System.out.println("long의 최대값 " + Long.MIN_VALUE);
		 
		 
	}

}
