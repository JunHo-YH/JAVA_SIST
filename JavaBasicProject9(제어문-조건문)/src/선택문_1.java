/*
 * 		switch(조건식) => 정수, 문자, 문자열
 * 		switch(avg / 10)
 * 		1) 조건식을 계산 => 정수, 문자
 * 		2) 계산된 동일한 case를 찾는다.
 * 		3) case밑에 있는 문장을 수행
 * 		4) break;가 있는 경우에는 switch를 종료 => break가 없는 경우에는 밑에 있는 case를 수행
 * 		***** 순서는 상관없다, 같은 라벨은 사용할 수 없다.
 * 		***** 무조건 break;를 사용하는 것은 아니다.
 * 	
 * 
 * 		page 148
 * 		문자열 : JDK1.7이상 사용가능
 * 		** char는 정수취급
 * 		byte < char < int < long < float < double
 * 			  ======
 * 		
 * 		** case의 값이 중복되면 안된다.
 * 
 * 
 * 
 * 		switch(정수)
 * 		{
 * 			case 1:
 * 			case 1:
 * 			===========> 오류
 * 		}
 */

// 사칙연산( + - * /)

import java.util.Scanner; // 사용자로부터 키보드 입력값을 받는다.
/*
 * 	프로그램 구성
 * 	=========
 * 		변수(배열, 클래스)
 * 		연산자
 * 		제어문
 * 		==============
 * 			재사용(메서드 => 연산자 + 제어문)
 * 			메서드 여러 개 => 클래스
 */

public class 선택문_1 {

	public static void main(String[] args) {
		// 산술 연산자 => 이항연산자(피연산자 2개 필요)
		int num1, num2;
		String op;
		// 사용자로부터 데이터 받기
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		num1 = scan.nextInt();
		System.out.print("두번째 정수 입려: ");
		num2 = scan.nextInt();
		
		System.out.println("연산자 입력(+ - * /): ");
		// Scanner => char는 받지 못하고=> 문자열로만 받는다 => 문자열 데이터형 String
		op = scan.next();
		char c = op.charAt(0); // 문자열에서 첫번째 문자를 읽어온다.
		
		// 데이터처리 => 겨우의 수 => 5
		switch(c) {
		case '+':
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
			break;
		case '-':
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
			break;
		case '*':
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
			break;
		case '/':
			if(num2 == 0)
				System.out.println("0으로 나눌 수 없습니다.");
			else
				System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
		}

	}

}
