import java.util.Scanner;

public class 문제15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		while (true) {
			System.out.print("두 자리 정수를 입력하세요(10 ~ 99): ");
			input = scan.nextInt();
			//input < 10 || input > 99
			if (!(10 <= input && input >= 99)) {
				System.out.println("잘못된 입력입니다.");
				continue; // while문 조건식으로 이동
			}
			break; // 정상적으로 입력이 됐다면 while을 종료

		}
		
		int tens  = input / 10;
		int units = input % 10;
		
		if ( tens == units ) {
			System.out.println("YES! ");
		} else {
			System.out.println("NO! ");
		}
	}

}
