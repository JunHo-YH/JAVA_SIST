
/*
 * 12) 사용자로부터 두 개의 정수를 입력 받아서 뺄셈과 곱셈 연산의 결과를 출력하는 프로그램을 작성
 */
import java.util.Scanner;

public class 문제12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("두 개의 정수를 입력( num1, num2) ");

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
	}

}
