// 사용자가 입력
/*
 * 	1입력 => Home
 * 	2입력 => Join
 * 	3입력 => 영화 목록
 * 	4입력 => 영화 추천
 * 	5입력 => 영화 예매
 * 	6입력 => 프로그램 종료
 */
import java.util.Scanner;

public class 다중조건문_1 {

	public static void main(String[] args) {
		int no;
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택하세요(1.홈 2.회원가입 3.영화목록 4.영화추천 5.영화예매 6.종료): ");
		no = scan.nextInt();
		
		//결과값
		if(no == 1)
			System.out.println("영화 홈입니다.");
		else if(no == 2)
			System.out.println("회원가입 페이지입니다.");
		else if(no == 3)
			System.out.println("영화목록을 보여줍니다.");
		else if(no == 4)
			System.out.println("영화를 추천합니다.");
		else if(no == 5)
			System.out.println("영화예매 페이지입니다.");
		else
			System.exit(0); // 프로그램 종료시 (0 => 정상종료, 1=> 비정상 종료)
	}

}





















