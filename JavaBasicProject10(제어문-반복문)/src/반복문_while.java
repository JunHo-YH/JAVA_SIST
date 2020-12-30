
/*
 * 사용자가 단을 입력
 */
import java.util.Scanner;

public class 반복문_while {

	public static void main(String[] args) {
		int dan;
		Scanner scan = new Scanner(System.in);
		System.out.println("단(2 ~ 9) 입력: ");
		dan = scan.nextInt();
		
		//입력된 단의 구구단을 출력
		// while문을 사용하지 않고 출력
		System.out.println(dan + "단");
		//출력
		System.out.printf("%d * %d = %d\n", dan, 1, dan * 1);
		System.out.printf("%d * %d = %d\n", dan, 2, dan * 2);
		System.out.printf("%d * %d = %d\n", dan, 3, dan * 3);
		System.out.printf("%d * %d = %d\n", dan, 4, dan * 4);
		System.out.printf("%d * %d = %d\n", dan, 5, dan * 5);
		System.out.printf("%d * %d = %d\n", dan, 6, dan * 6);
		System.out.printf("%d * %d = %d\n", dan, 7, dan * 7);
		System.out.printf("%d * %d = %d\n", dan, 8, dan * 8);
		System.out.printf("%d * %d = %d\n", dan, 9, dan * 9);
		System.out.println("******* 반복문(while) 사용 *******");
		int i = 1;
		while(i <= 9) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			i++; // i <= 9 i = 10 => false가 되면서 종료
		}
	}

}
