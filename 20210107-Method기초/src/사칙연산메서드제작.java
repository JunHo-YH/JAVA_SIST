import java.util.Scanner;

/*
 * 연산처리하는 메서드를 만든다 ==> 1유형 (매개변수 O, 리턴형 O)
 *  +
 *  -
 *  *
 *  /
 *  ===> 세분화
 *  회원가입
 *    가입, 아이디 중복체크, 우편번호
 */
public class 사칙연산메서드제작 {
	// 더하기
	static int plus(int a, int b) {
		return a + b;
	}

	static int minus(int a, int b) {
		return a - b;
	}

	static int mul(int a, int b) {
		return a * b;
	}

	static double div(int a, int b) {
		return (double) a / b;
	}

	public static void main(String[] args) {
		// 메서드 호출
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		int a = scan.nextInt();
		System.out.print("두번째 정수 입력:");
		int b = scan.nextInt();
		System.out.print("연산자 입력(+ - * /): ");
		String op = scan.next();

		int c;

		switch (op) {
		case "+":
			c = plus(a, b);
			System.out.printf("%d + %d = %d\n", a, b, c);
			break;
		case "-":
			c = minus(a, b);
			System.out.printf("%d - %d = %d\n", a, b, c);
			break;
		case "*":
			c = mul(a, b);
			System.out.printf("%d * %d = %d\n", a, b, c);
			break;
		case "/":
			if (b == 0)
				System.out.println("0으로 나눌 수 없습니다.");
			else {
				double d = div(a,b);
				System.out.printf("%d / %d = %.2f\n", a, b, d);
			}
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
		}

	}

}
