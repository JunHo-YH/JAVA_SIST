
// 3자리 정수를 입력하게 만든다.
/*
 * 		1. 조건문
 * 			단일 조건문
 * 			선택 조건문
 * 			다중 조건문
 * 		2. 반복문
 * 			while
 * 			for
 * 		3. 반복 제어문
 * 			break;
 * ========================> Web
 * 		switch-case, do~while, continue ==> 가 ~~~~~~~~~~~~~ 끔 사용한다.
 */
import java.util.Scanner;

public class 반복문_for4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.print("세자리 정수를 입력하세요: ");
			int user = scan.nextInt();
			if (user < 100 || user > 999) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
				// continue나 break 밑에는 코딩이 불가능하다.
			}
			
			int a = user / 100;
			int b = (user % 100) / 10;
			int c = (user % 10);
			System.out.println("백단위 : " + a);
			System.out.println("십단위 : " + b);
			System.out.println("단단위 : " + c);
			
			break; // 종료
		}

	}

}
