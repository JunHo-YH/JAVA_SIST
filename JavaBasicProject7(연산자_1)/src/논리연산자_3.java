// char를 선언 => 대문자, 소문자를 확인하는 프로그램 구현 ==> 두 개의 조건을 이용해서 연산처리 => 논리연산자
// 산술연산자 => char변수가 연산이 되면 정수형으로 변경
/*
 *	char alpha = 'K'
 *	65 <= alpha && alpha <= 90
 *	'A' <= alpha && alpha <= 'Z'
 *	모든 char변수 => 연산시 무조건 정수형으로 변경
 */
public class 논리연산자_3 {

	public static void main(String[] args) {
		//System.out.println((int) 'Z');
		char alpha =(char)((Math.random()*26) + 65); //alpha값이 대문자? 소문자?
		/*
		 * 
		 */
		boolean bCheck = 'A' <= alpha && alpha  <= 'Z'; // 'A'와 'Z' 사이에 있는지 확인
		String result = bCheck == true ? "대문자" : "소문자";
		System.out.println(alpha + "은(는): " + result);
		
		/*
		 * 	변수 => 초기화
		 * 	1. 명시적 초기화 : int a = 10;
		 * 	2. 입력값 받기 : int a = scan.nextInt()
		 * 	3. 난수값 초기화 : Math.random()
		 * 
		 */
	}

}
