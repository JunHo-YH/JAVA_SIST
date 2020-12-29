// 2020 - 12 - 28 수업
/*
 * 	자바
 * 	1) 실행 과정
 * 		프로그래머만 아는 코드 (자바) => 원시소스
 * 		원시소스   ======> 컴퓨터가 알 수 있는 언어로 변경 ===> 실행요청(JVM) ===> 결과
 * 		(.java)  컴파일(javac) ==> .class			  인터프리터(java) ==> .java ==> JDK(javac, java)
 * 		= javac : 컴파일 (컴퓨터가 알 수 있는 언어로 변경) : 0,1 변경
 * 		= java  : 실행(컴파일된 자바 파일을 한 줄씩 읽어서 번역)
 * 	2) 프로그램에서 기본 => 데이터 저장
 * 		데이터 저장하는 방식
 * 		==============
 * 		= 데이터 한 개 저장 ==> 메모리주소의 별칭
 * 			1. 변경해서 사용 (변수)
 * 				데이터형 변수명;
 * 			2. 고정해서 사용 (상수)
 * 				final 데이터형 상수명
 * 				=====
 * 				1-1. 자바에서 지원하는 데이터형 (메모리 크기)
 * 					= 기본데이터형 : 자바에서 지원
 * 					  ==================================================================
 * 								1byte		2byte		4byte		8byte
 * 					  ==================================================================
 * 					  정수형		byte		short		int			long
 * 					  ==================================================================
 * 					  실수형								float		double
 * 					  ==================================================================
 * 					  문자형					char
 * 					  ==================================================================
 * 					  논리형		boolean
 * 					  ==================================================================
 * 					  byte    : 파일 입출력 => 응용 (파일 업로드, 파일 다운로드), 네트워크
 * 					  short   : C언어와 호환, 파이썬 (스프링 기반: AI) : 데이터 수집, 데이터 분석
 * 					  ===================================================================  
 * 					  int	  : default (현재 사용중인 프로그램에서 기본 정수 => int)
 * 								100, 200 => 컴퓨터는 int로 인식
 * 					  long	  : 금융권, 빅데이터, 증권
 * 					  ==============================int와 long을 구분하기 위해서 접미사(l,L) 사용==
 * 					  100 => int, 100L => long
 * 					  float	  : 실수 => 소수점 6자리
 * 					  double  : 실수의 default => 소수점 15자리
 * 					  ==================================== float과 double을 구분할 접미사(f, F)사용
 * 					  10.5 => double(10.5d, 10.5D도 가능), 10.5f(F) = > float 
 * 					  char    : 문자 한 개 저장 => 알파벳, 한글, 숫자 => 'A', '1', '홍' => UNICODE(2byte)
 * 					  boolean : true/false => (C언어: 0, 1)
 * 											  true = 1, false = 0
 * 					= 사용자정의 : 참조형 데이터(배열, 클래스)
 * 		= 같은 데이터형 여러개를 모아서 관리 : 배열
 * 		= 다른 데이터형 여러개를 모아서 관리 : 클래스
 * 		================================= 메모리에 저장 (휘발성(RAM): 프로그램 종료, 컴퓨터 종료 ==> 메모리가 사라진다)
 * 		= 파일
 * 		= RDBMS (오라클)
 * 	3) 저장된 데이터를 제어 (가공) : 사용자가 요청한 결과값을 도출
 * 		= 연산자
 * 			자바에서 지원하는 연산자
 * 			= 단항연산자 (연산대상(피연산자)가 1개일 경우)
 * 				=> 증감연산자 (++, --) : 한 개 증가(+1), 한 개 감소(-1)
 * 				=> 부정연산자 (!)		: boolean데이터형만 가능 (true -> false, false -> true)
 * 				=> 부호연산자 (+, -)   : 10, -10 => 양수, 음수
 * 				=> 캐스트연산자 (형변환) : (데이터형)값 (단,boolean은 제외)
 * 			= 이항연산자 (피연산자가 2개일 경우)
 * 				=> 산술연산자 (+, -, +, /, %)
 * 				==================================================================
 * 				=> 비트이동 연산자 (<<(왼쪽이동), >> (오른쪽 이동)
 * 				=> 비트 연산자 ( &, |, ^)
 * 				==================================================================
 * 				=> 비교연산자 : 결과값 (true / false) : ==(같다), !=(같지 않다), <(작다), >(크다), <=(작거나 같다)
 * 							 >=(크거나 같다) : 정수, 실수
 * 					=> 데이터형의 크기
 * 						byte < short, char < int < long < float < double
 * 						*** 정수보다 실수가 크다.
 * 				=> 논리연산자 : 결과값 (true / false) : &&(범위나 기간이 포함), ||(범위나 기간을 벗어났을 경우)
 * 							*** 효율적인 연산 (최적화)
 * 							int a = 10;
 * 							int b = 9;
 * 							a < b && ++b == a;
 * 							=====    =========
 * 							false ==> 뒷부분 연산 x
 * 							          a = 10, b = 9
 * 							&& => 왼쪽에 있는 조건이 false일 경우에 오른쪽은 연산하지 않는다.
 * 							|| => 왼쪽에 있는 조건이 true일 경우에 오른쪽은 연산이 안된다.
 * 				=> 대입연산자
 * 					=, +=, -=, *=, /=, >>=, <<=, |=, ^=, &=  : 복합 대입연산자
 * 			= 삼항연산자 (피연산자가 3개일 경우에 사용)
 * 				조건 ? 값1 : 값2
 * 				===
 * 				true => 값1
 * 				false => 값2
 * 				1,2,3,4 => 1,3(남자), 2,4(여자), 7(외국인)
 * 				sex == 1 || sex == 3 ? "남자" : "여자"
 * 			= 자바에서만 존재 : instanceOf : 클래스 크기
 * 										====
 * 										is-a(상속), has-a(포함)
 * 		= 제어문
 * 	
 * 	4) 객체지향 프로그램 : 재사용, 보안, 유지보수
 * 	5) 안전한 프로그램 (종료하지 않는 프로그램 : ERROR처리, 사전에 방지) : 예외처리
 * 	6) 라이브러리 : 자바에서 미리 만들어서 지원
 * 	7) 라이브러리 + 프로그래머가 만든 소스를 조립 
 * 				
 */

import java.util.Scanner;
/*
 * 	1. 대소문자 구분
 * 	2. 변수 사용 범위 지정 => {}
 * 	3. 명령문
 * 		프로그램 => 컴퓨터에 명령을 내려서 컴퓨터 수행
 * 		================================== 컴퓨터가 => 어디까지가 명령인지 인식해야한다. => ;
 * 	4. 들여쓰기
 * 	   =====
 * 		
 */
public class 수업정리 {

	public static void main(String[] args) {
		// 산술 연산자 (+, -, *, /, %)
		/*
		 * 	1. 형변환
		 * 		= 시스템(자바)에 의해 자동으로 변경 (자동 형변환) : UP Casting
		 * 			int => double
		 * 
		 * 			int + double => double + double
		 * 			컴퓨터에서 연산은 같은 데이터형 끼리만 연산된다.
		 * 
		 * 			'A' + 1 => 66
		 * 			===
		 * 			65(int) => char => int
		 * 			65 + 1 = 66(int)
		 * 
		 * 			'A' + 'B'
		 * 			char + char => 131(int)
		 * 			65  + 66
		 * 
		 * 
		 * 		= 프로그래머에 의해 강제로 변경 (강제 형변환) : Down Casting
		 * 			(int)double => int
		 * 			10.5 + 10.5 => 소수점이 필요없을 때
		 * 			(int)(10.5 + 10.5) => (int)(21.0) => 21
		 * 		= int이하 (byte, short, char) 데이터형이 연산이 되면 => 결과값은 int
		 * 	2. /
		 * 		= 0으로 나눌 경우에는 오류 발생 
		 * 		= 정수 / 정수 = 정수 ===> 5 / 2 = 2, 정수 / 실수 = 실수(소수점을 출력할 때)
		 * 	3. %
		 * 		= 부호가 왼쪽편 부호가 남는다.
		 * 			-5 % 2 => -1
		 * 			-5 % -2 => -1
		 * 			================> -5 * -2 = 10, -5 / -2 = 2
		 */
		
//		System.out.println(-5 * -2);
//		System.out.println(-5 / -2);
//		System.out.println(-5 % -2);
		
		// 정수 3개를 입력 받아서 3개를 저장하고 평균과 총점을 구하고 출력해라.
		// 저장할 공간을 만든다 (변수)
		int kor, eng, math;
		
		// Scanner를 통해서 사용자가 키보드로 입력한 값을 받아서 메모리공간(변수)에 저장
		Scanner scan = new Scanner(System.in);
		// 클래스를 메모리에 저장할 때 사용 => new (동적메모리 할당)
		
		/*
		 * 	===========================
		 *		메소드 영역 (메소드,static)
		 * 	===========================
		 * 		stack => 기본데이터형 (컴퓨터가 메모리 크기를 알고 있다)
		 * 	===========================
		 * 		heap  => 메모리 크기를 알 수 없다 (확인 후에 메모리 크기를 만들어 준다.)
		 * 									===============
		 * 									new => malloc(sizeOf(클래스명)
		 * 	===========================
		 */
		
		/*
		 * nextInt() = 정수값 입력시
		 * nextDouble() = 실수값 입력시
		 * nextBoolean() = true / false
		 * next = 문자열 입력시
		 */
		System.out.print("국어점수 입력: ");
		kor = scan.nextInt();
		System.out.print("영어점수 입력: ");
		eng = scan.nextInt();
		System.out.print("수학점수 입력: ");
		math = scan.nextInt();
		
		System.out.println("총점: " + (kor + eng + math));
		System.out.println("평균: " + (int)((kor + eng + math) / 3f * 10 + 0.5f) / 10f );
//		System.out.printf("평균: %.2f", (kor + eng + math)/3f );
		
		
		
		
	}

}
