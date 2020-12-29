/*
 * 	선택조건문
 * 	예) 로기은 처리, 로그인 안된 상태
 * 		대문자, 소문자
 * 		ID중복체크 (중복, 중복 안된 경우)
 */

// 사용자가 정수를 입력한 후에 => 결과 (짝수 or 홀수)
import java.util.Scanner;
/*
 * 	프로그램 (가상 => 시뮬레이션) ==> 가정
 * 		1. 입력 => 저장 (변수를 설정)
 * 		2. 저장된 데이터를 가공
 * 		   ===============> 연산자
 * 		3. 사용자한테 보내줄 데이터를 처리
 * 		   ======================= 제어문
 * 		4. 처리된 결과를 보여준다
 */
public class 선택조건문 {

	public static void main(String[] args) {
		// 입력값을 저장할 공간(메모리) : 변수
		// 일반적인 정수 => int(default)
		int num;
		
		// 입력을 받아서 초기화
		// 사용자 입력을 유도
		Scanner scan = new Scanner(System.in);
		
		//사용자에게 요청
		System.out.print("정수 입력: ");
		
		//입력된 경우에 메모리에 저장 ==> num
		num = scan.nextInt();
		
		// 실제 결과 (짝수, 홀수) ==> num % 2 == 0
		if(num % 2 == 0) // num % 2 == 0
			System.out.println(num + "은(는) 짝수입니다."); // true일 경우에 처리되는 영역
		else // num % 2 != 0;
			System.out.println(num + "은(는) 홀수입니다."); // flase일 경우에 처리되는 영역
		
		// 삼항연산자
		// num % 2 == 0 ? num + "은(는) 짝수입니다." : num + "은(는) 홀수입니다.";
		
		
		
	}

}
