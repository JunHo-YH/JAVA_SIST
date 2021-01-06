import java.util.Scanner;

// 32767 (양수만 처리
/*
 * 	1. 정렬
 * 		= 선택정렬
 * 		= 버블정렬
 * 1-1 빈도수 확인
 *  		12311122222 => 문자열
 * 	2. 윤년 => 달력
 * 	3. 숫자 야구 게임 (중복이 없는 난수 발생)
 * 				   ===============
 * 					로또 => 6개
 * 	4. 문자열배열
 */

// 정수 1개를 입력받아서  2진법으로 변경해서 출력 => 16bit (0,1 16개)
/*
 * 	1. 변수(저장공간)
 * 		= 0과 1을 16개 저장할 수 있는 공간 => 배열
 * 		= 사용자 입력값 저장
 * 		= 배열 => 16 => index번호를 제어할 변수
 */
public class 배열활용_2 {

	public static void main(String[] args) {
		int[] binary = new int[16]; // 0, 1
		int input; // 사용자가 입력한 정수 저장
		int index = 15; // 배열에 값을 채울 경우 (뒤(length -1), 앞(0) 잘 선택하기)
		// 사용자로부터 정수값을 받는다
		Scanner scan = new Scanner(System.in);
		System.out.print("0 ~ 32767 사이의 정수를 입력(16bit)	: ");
		input = scan.nextInt(); // 사용자 입력을 받았다 => 입력된 정수를 2진법으로 출력 요청

		// 입력된 정수에 따라서 반복수행이 다르다 => while 반복문 사용
		/*
		 * 1. 정수를 나누고 나머지 저장 2. 정수를 2로 나눈다.
		 */
		System.out.println("=====라이브러리=====");
		System.out.println(Integer.toBinaryString(input));
		
		
		while (true) {
			// 나머지 저장
			binary[index] = input % 2; // 0 or 1 저장
			input = input / 2;
			if (input == 0)
				break;
			index--;
		}

		// 출력
		for (int i = 0; i < binary.length; i++) {
			if (i % 4 == 0 && i != 0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}
	}

}
