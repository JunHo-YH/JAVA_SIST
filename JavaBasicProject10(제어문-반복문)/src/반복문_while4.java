// while: 반복횟수가 정해지지 않은 경우에 주로 사용
// UP - DOWN 게임
/*
 * 		게임: 난수 (1 ~ 100 사이의 난수 발생)
 * 				===================== 맞추는 게임
 * 				HINT: UP, DOWN
 * 				난수: 70
 * 				사용자: 80 ==> DOWN
 * 				사용자: 65 ==> UP
 * 
 * 		게임 제작
 * 		======
 * 		1. 난수 발생 => 메모리 저장
 * 		2. 사용자 입력
 * 		3. 난수와 사용자 입력값을 비교
 * 		4. HINT
 * 		5. 종료여부 확인 => true => 종료
 * 						false => 2번으로 이동
 */

import java.util.Scanner;

public class 반복문_while4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int com = (int) (Math.random() * 100) + 1;

		while (true) {
			// 1. 사용자 입력값을 받는다.
			System.out.println("1 ~ 100 사이의 정수 입력: ");
			
			// 저장
			int user = scan.nextInt();
			
			if(com > user) {
				System.out.print("입력값보다 큰 값을 입력해주세요."); // UP
			}
			else if(com < user) {
				System.out.print("입력값보다 작은 값을 입력해주세요."); // DOWN
			}
			else {
				System.out.println("정답입니다 !");
				System.exit(0); // 프로그램 정상 종료
				//break;
			}
			
			
		}
		//System.out.println("프로그램 종료");
	}

}
