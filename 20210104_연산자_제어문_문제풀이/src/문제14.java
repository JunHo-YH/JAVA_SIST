
/*
 * 14) 두 개의 정수를 입력 받아서 첫째 수를 둘째 수로 나눈 나머지를 출력하는 프로그램을 작성해 보자.


 */
import java.util.Scanner;

public class 문제14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("두개의 정수 입력(num1 num2): ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		System.out.printf("%d %% %d = %d\n", num1, num2, num1 % num2);

	}

}
