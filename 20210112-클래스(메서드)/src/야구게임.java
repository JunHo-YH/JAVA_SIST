
/*
 *    int[] com : 컴퓨터 난수 
 *    int[] user : 사용자 입력값 
 *    int s, int b;
 *    
 *    1) 컴퓨터가 난수 발생  => int[] com
 *    2) 사용자 입력       => int[] user
 *    3) 비교 => int[] com,int[] user
 *    4) 힌트 => s, b
 *    5) 종료여부 => s
 */
import java.util.Scanner;

public class 야구게임 {
	// 변수
	// 멤버변수 자동 초기화
	int[] com = new int[3];
	int[] user = new int[3];
	int s, b; // s=0,b=0
	// 난수 발생 => int[] com

	void rand() {
		int su = 0;// 난수를 저장하는 변수
		boolean bCheck = false; // 지역변수 => 반드시 초기화
		// true: 중복 , false:중복이 안됨
		// 중복된 수가 있으면 안된다
		// 난수 => 3번을 발생
		for (int i = 0; i < 3; i++) {
			// 저장된 데이터 중복이 있는지 확인
			bCheck = true;
			while (bCheck) {
				// 난수 발생 1~9사이의 정수 발생
				su = (int) (Math.random() * 9) + 1; // 1~9
				bCheck = false;// while종료
				// com에 저장된 데이터와 난수를 비교 => 중복이 있는지 확인
				for (int j = 0; j < i; j++) {
					if (com[j] == su) {
						// 중복이 있으면 => while을 다시 수행한다
						bCheck = true;
						break;
					}
				}
			}
			com[i] = su; // 중복수가 없다
		}
	}

	// 사용자 입력 => int[] user
	void userInput() {
		Scanner scan = new Scanner(System.in);// System.in => 키보드 입력값을 받는다
		// 자바 => 모든 메소드는 클래스에 존재
		while (true) {
			System.out.print("세자리 정수 입력:");
			int input = scan.nextInt();
			// 오류 처리
			// 1. 세자리 정수가 아닌 경우 100~999
			if (input < 100 || input > 999) {
				System.out.println("세자리 정수만 사용이 가능합니다!!");
				// while=>처음으로 이동
				continue;
			}
			// 789
			user[0] = input / 100; // 789/100 => 7
			user[1] = (input % 100) / 10; // 789%100 => 89/10 => 8
			user[2] = input % 10; // 789%10 => 9
			// 2. 중복된 수를 사용할 수 없다
			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("중복된 수는 사용할 수 없습니다!!");
				continue;
			}
			// 3. 0은 사용할 수 없다 => 012
			if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0은 사용할 수 없는 숫자입니다!!");
				continue;
			}
			// while 종료
			break;
		}
	}

	// 비교 => int[] com,int[] user
	void compare() {
		s = 0;
		b = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (com[i] == user[j])// 같은 숫자이고
				{
					if (i == j) // 같은 자리수
					{
						s++;
					} else {
						b++;
					}
				}
			}
		}
		/*
		 * 789 com 756 user ========= 1S-0B 789 798 ==== 1S-2B 789 789 ==== 3S-0B ==> 종료
		 */
	}

	// 힌트 => int[] user,s,b
	void hint() {
		System.out.printf("Input Number:%d%d%d,Result:%dS-%dB\n", user[0], user[1], user[2], s, b);
	}

	// 종료 => s(3)
	boolean isEnd() {
		if (s == 3)
			return true;// 메소드는 return을 만나면 종료
		return false;
	}

	void process() {

		rand();// 난수 발생
		while (true) {
			// 사용자 정의 입력
			userInput();
			compare();
			hint();
			if (isEnd() == true) {
				Scanner scan = new Scanner(System.in);
				System.out.print("종료할까요?(y|n):");
				char c = scan.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					System.out.println("Game Over!!");
					System.exit(0);
				} else {
					System.out.println("새게임을 시작합니다!!!");
					process();// 재귀호출
				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		야구게임 baseball = new 야구게임();
		baseball.process();
	}

}
