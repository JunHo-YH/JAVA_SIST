/*
 * 1. (1~9) 중복이 없는 난수 3개 설정 => 배열
 *    =========================
 * 2. 사용자가 입력해서 맞추는 게임 
 *  2-1. 사용자 입력값을 받는다.	=> 배열
 *  2-2. 비교
 *  2-3. 힌트 ==>  Strike, Ball
 *       ==
 *       1) 숫자가 동일 & 자리수가 맞는 경우
 *       2) 숫자가 동일 & 다른 자리에 있는 경우
 *          369 => 378 ==> 1S
 *          369 => 123 ==> 1B
 *          369 => 398 => 1S-1B
 * 3. 종료여부 확인 => S(3)
 * 
 * 메소드 VS 함수 +> 클래스 종속
 */

import java.util.Scanner;

public class 숫자야구게임 {
	static void baseBallGame() {
		// 컴퓨터 정수 3개를 저장
		int[] com = { 3, 6, 9 };

		// 사용자가 입력한 정수를 저장
		int[] user = new int[3];

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("세자리 정수를 입력하세요>>> ");
			int input = scan.nextInt();
			// 오류 처리
			if (input < 100 || input > 999) {
				System.out.println("잘못된 입력입니다.");
				continue; // 처음으로 돌아간다. => while문의 조건식으로 이동
			}
			user[0] = input / 100;
			user[1] = (input % 100) / 10;
			user[2] = input % 10;

			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("중복된 수는 사용할 수 없습니다.");
				continue; // 다시 입력 요청

			}

			// 비교 시작
			int s = 0, b = 0;
			for (int i = 0; i < 3; i++) { // com
				for (int k = 0; k < 3; k++) { // user
					// 같은 수가 있는지 확인
					if (com[i] == user[k]) {
						if (i == k)
							s++;
						else
							b++;
					}
				}
			}

			// 힌트
//					System.out.printf("Input Number: %d, Result: %dS-%dB\n", input, s, b);
			System.out.println("===== 결과 =====");
			System.out.print("S: ");
			for (int i = 0; i < s; i++)
				System.out.print("●");

			System.out.println();
			System.out.print("B:");
			for (int i = 0; i < b; i++)
				System.out.print("○");
			System.out.println();

			if (s == 3) {
				System.out.println("Game Over!!");
				break;
			}

		}

	}

	public static void main(String[] args) {
		baseBallGame();
		
	}

}
