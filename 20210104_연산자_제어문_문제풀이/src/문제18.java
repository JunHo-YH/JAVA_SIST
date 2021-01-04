/*
 * 18) 연도를 입력받아 윤년인지 아닌지를 판별하는 프로그램( 윤년은 4년마다 한번씩 있고 100으로 나누어떨어지면 윤년이 아니지만, 100으로 나누어떨어지는 년도중 400으로 나누어떨어지는 년도는 윤년)


 */

import java.util.Scanner;

public class 문제18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력: ");
		int year = scan.nextInt();

		// 윤년 여부 확인
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "년도는 윤년입니다.");
		} else {
			System.out.println(year + "년도는 윤년이 아닙니다.");
		}
	}

}
