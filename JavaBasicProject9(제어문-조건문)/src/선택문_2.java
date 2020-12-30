// 계절 3,4,5: 봄 / 6,7,8: 여름 / 9,10,11: 가을/ 12,1,2: 겨울
// 사용자가 월을 입력

import java.util.Scanner;

public class 선택문_2 {

	public static void main(String[] args) {
		int month;
		Scanner scan = new Scanner(System.in);
		System.out.print("월을 입력: ");
		month = scan.nextInt();
		
		//처리
		/*
		 * 	case 3: case 4: case5:
		 * 	if(month == 3 || month == 4 || month == 5)
		 */
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("봄입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println("여름입니다.");
			break;
		case 9: case 10: case 11:
			System.out.println("가을입니다.");
			break;
		case 12: case 1: case 2:
			System.out.println("겨울입니다.");
		default:
			System.out.println("잘못입력하셨습니다.");
		}
	}

}
