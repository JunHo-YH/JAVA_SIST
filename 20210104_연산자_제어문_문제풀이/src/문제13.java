
/*
 * 13) 사용자로부터 세 개의 정수를 입력받은 다음에 곱과 합을 순서대로 진행해서 그 결과를 출력하는 프로그램을 작성해 보 자.
 *  예를 들어 사용자로부터 순서대로 입력받은 세 개의 정수가 1, 2, 3 이라면 1 * 2 + 3의 계산 결과를 출력하는 프로그램을 작성하시오. 

 */
import java.util.Scanner;

public class 문제13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("세개의 정수 입력(num1, num2, num3): ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int result = num1 * num2 + num3;
		System.out.println("결과값: " + result);

	}

}
