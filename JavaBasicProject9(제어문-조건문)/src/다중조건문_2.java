// 계산기 (4칙연산)
// 저장 => 정수 2개, 연산자 1개
// 입력 Scanner

import java.util.Scanner;

public class 다중조건문_2 {

	public static void main(String[] args) {
		// 저장 공간 만들기
		int num1 ,num2;
		char op; // 연산자 => +,-,*,/
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수 입력: ");
		num1 = scan.nextInt();
		
		System.out.print("두번째 정수 입력: ");
		num2 = scan.nextInt();
		
		System.out.print("연산자를 입력(+,-,*,/): ");
		String s = scan.next();
		op = s.charAt(0);
		
		// 사칙연산 처리
		if(op == '+') {
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		}
		else if(op == '-') {
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		}
		else if(op == '*') {
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		}
		else if(op == '/') {
			if(num2 == 0)
				System.out.println("0으로 나눌 수 없습니다.");
			else
				System.out.printf("%d / %d = %.2f\n", num1, num2, num1 / (float)num2);
		}
		else {
			System.out.println("연산자를 잘못 입력하셨습니다.");
		}
	}

}
