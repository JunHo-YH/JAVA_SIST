
// 가위 바위 보 게임
/*
 * 	사용자 입력 : 0(가위), 1(바위), 2(보)
 * 	컴퓨터 입력 : 난수 (0, 1, 2)
 * 	================================
 * 	결과 : 중첩 if
 * if()
 * {
 * 	if()
 * 	{
 * 
 * 	}
 * }
 */
import java.util.Scanner; // 입력을 받는 경우에 사용하는 클래스(문법)

public class 단일조건문_2 {

	public static void main(String[] args) {
		//사용자가 입력을 할 수 있게 처리
		Scanner scan = new Scanner(System.in);
		// 사용자가 입력한 값을 받는다 (0,1,2)		
		System.out.print("가위(0), 바위(1), 보(2) 입력: ");
		int user = scan.nextInt();
		int com = (int)(Math.random() * 3);
		/*
		// 확인 => 사용자가 뭘 냈는지
		if(user == 0) // 사용자가 입력한 값이 0이면
			System.out.println("사용자: 가위");
		if(user == 1)
			System.out.println("사용자: 바위");
		if(user == 2)
			System.out.println("사용자: 보");
		
		/// 컴퓨터
		int com = (int)(Math.random() * 3);
		
		if(com == 0)
			System.out.println("컴퓨터: 가위");
		if(com == 1)
			System.out.println("컴퓨터: 바위");
		if(com == 2)
			System.out.println("컴퓨터: 보");
		
		/// 결과값을 출력
		System.out.println("**********결과값**********");
		if(com == 0 && user == 0)
			System.out.println("비겼습니다.");
		if(com == 0 && user == 1)
			System.out.println("사용자 Win !!");
		if(com == 0 && user == 2)
			System.out.println("컴퓨터 Win !!");
		
		if(com == 1 && user == 0)
			System.out.println("컴퓨터 Win !!.");
		if(com == 1 && user == 1)
			System.out.println("비겼습니다.");
		if(com == 1 && user == 2)
			System.out.println("사용자 Win !!");
		
		if(com == 2 && user == 0)
			System.out.println("사용자 Win !!.");
		if(com == 2 && user == 1)
			System.out.println("컴퓨터 Win !!");
		if(com == 2 && user == 2)
			System.out.println("비겼습니다.");
		*/
		
		int res = com - user;
		if(res == - 1|| res == 2)
			System.out.println("사용자 Win !!");
		if(res == -2 || res == 1)
			System.out.println("컴퓨터 Win !!");
		if(res == 0)
			System.out.println("비겼다!!");
		
	}

}




















