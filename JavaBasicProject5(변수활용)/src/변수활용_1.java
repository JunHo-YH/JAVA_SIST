/*
 * 	변수 : 저장, 읽기, 쓰기 (수정)
 * 		 =================== 한 개만 저장 가능하다.
 * 		 정수, 실수, 문자, 논리 : 무엇을 저장하냐에 따라서 타입이 달라진다.
 * 	1. 변수 선언
 * 	2. 변수 초기화
 * 	3. 변수값 변경
 * 	4. 데이터 출력
 * 
 * 	1) 정수를 출력하는 방법
 * 		= 10진법 (주로 사용)
 * 		= 2진법
 * 		= 8진법
 * 		= 16진법 : HTML 색상표 (16진법)
 * 
 * 		8진법
 * 		27
 * 		==> 11|011
 * 			== ====
 * 			3	3 => 033
 * 					=====       8^1x3   8^0x3
 *								=====	======
 *								24	+	3 =====> 27
 *
 *		16진법
 *		100(2)
 *		=====> 110|0100
 *				6  4 ====> 0x64(16)
 *
 */		
public class 변수활용_1 {

	public static void main(String[] args) {
		System.out.println("100의 2진법: " + Integer.toBinaryString(100)); //2진법
		System.out.println("27의 2진법: " + Integer.toBinaryString(27));
		System.out.println("27의 8진법: " + Integer.toOctalString(27)); // 8진법
		System.out.println("100의 16진법: " + Integer.toHexString(100)); // 16진법
		//16진법 : A(10), B(11), C(12), D(13), E(14), F(15)
		System.out.println("033:" + 0332);
		System.out.println("0x64: " + 0x64);
		//10진법, 16진법, 2진법, 8진법
//				0x__   0b__  0__
		System.out.println(~78);
		
		
		/* page(42 ~ 52)정리
		 * 10진법 ==> 2진법
		 * 	Integer.toBinaryString(정수)
		 * 10진법 ==> 8진법
		 * 	Integer.toOctalString(정수)
		 * 10진법 ==> 16진법
		 * 	Integer.toHexString(정수)
		 *  
		 * 
		 * 2진법 ==> 10진법
		 * 	0b(2진법)
		 * 8진법 ==> 10진법
		 * 	0(8진법)
		 * 16진법 ==> 10진법
		 * 	0x(16진법)
		 * 양수 => 음수
		 *  ~정수값
		 */
		
		/* page(55 ~ 73)정리
		 * 기본데이터형
		 * 논리형
		 * 	boolean : 조건식, 반복문 ==> 제어문
		 * 
		 * 정수형
		 * 	byte 	: 	파일관련(파일 다운로드, 파일 업로드)
		 * 	short 	:	C언어와 호환(자바에서는 많이 사용하지 않는다)
		 * 	int  	:	주로 사용하는 데이터형(default => 컴퓨터에서는 모든 숫자를 int로 인식한다)
		 * 	long 	: 	금융권, 증권, 빅데이터	
		 * 
		 * 문자형
		 * 	char : 인코딩 / 디코딩
		 * 		   ====   ====				  인코딩    디코딩 ===> 필요시마다 정수로 변환
		 * 			숫자		문자 		=> 'A'  ==> 65 ==> 'A'(UTF-8) 1byte => 2byte
		 * 									   저장값    출력물]
		 * 실수형
		 * 	float  : 소수점을 6자리 이상
		 * 	double : 주로 사용(default) : 건축 (소수점을 15자리 이상)
		 * 
		 */
		
		System.out.println('A');
		System.out.println((int)'A');
		System.out.println((char)65);
		
		System.out.println("\"홍길동\""); // "홍길동"
		System.out.println("c:\\jdk-14.0.2"); // 경로명
	}

}
