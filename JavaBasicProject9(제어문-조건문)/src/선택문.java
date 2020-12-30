/*
 * 	선택문: 값 한 개가 선택이 된 경우에 처리(다중조건문) => 게임, 윈도우 제작시 주로 사용한다.
 * 	1-10
 * 	11-20
 * 	21-30
 * 	31-40
 * 	41-50 ==> case 1:
 * 	형식)
 * 		switch(정수, 문자, 문자열)
 * 				정수 => 3
 * 		switch(정수)
 * 		{
 * 			case1:
 * 				실행문장 1;
 * 				문장 수행후에 종료: break;
 * 			case 2:
 * 				실행문장 2;
 * 				문장 수행후에 종료: break;
 * 			case 3:
 * 				실행문장 3;
 * 				문장 수행후에 종료: break;
 * 			default: ================> 생략가능
 * 				실행문장 4;
 * 		}
 * 		
 * 		switch(문자)
 * 		{ 문자 = 'A'
 * 			case 'A':
 * 				실행문장 1;
 * 				문장 수행후에 종료: break;
 * 			case 'B':
 * 				실행문장 2;
 * 				문장 수행후에 종료: break;
 * 			case 'C':
 * 				실행문장 3;
 * 				문장 수행후에 종료: break;
 * 			default: ================> 생략가능
 * 				실행문장 4;
 * 		}
 * 		switch(문자열)
 * 		{ 
 * 			case "로그인";
 * 			case "회원가입";
 * 			case "영화목록";
 * 			case "상세보기";
 * 		}
 * 		final int LOGIN = 1;
 * 
 * 		case LOGIN:
 * 		
 */
public class 선택문 {

	public static void main(String[] args) {
		int no = (int) (Math.random() * 5) + 1; // 1 ~ 5
		// ====== =================== ====
//					2	       1			3

		switch (no) {
		case 1:	//(if i == 1)
				System.out.println("1이 선택됐습니다.");
				break; // 위에 문장을 수행하고 switch를 종료
		case 2:
			System.out.println("2가 선택됐습니다.");
			break;
		case 3:
			System.out.println("3이 선택됐습니다.");
			break;
		case 4:
			System.out.println("4가 선택됐습니다.");
			break;
		case 5:
			System.out.println("5가 선택됐습니다.");
		}
	}

}
