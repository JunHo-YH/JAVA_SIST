package com.sist.string;

/*
 * String 메서드
 * int length()
 * char charAt(int no)
 */
import java.util.Scanner;

public class MainClass2 {

	public static void main(String[] args) {
		/*
		 * Scanner scan = new Scanner(System.in); System.out.println("문자열 입력"); String
		 * msg = scan.next(); System.out.println("msg=" + msg);
		 * System.out.println("문자 개수: " + msg.length());
		 */
		// 문자열이 좌우 대칭인지? => Google
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력: ");
//		String msg = scan.next();
//		for (int i = msg.length() - 1; i >= 0; i--) {
//			System.out.print(msg.charAt(i));
//		}

		String msg = "";
		while (true) {
			System.out.print("문자열 입력: ");
			msg = scan.next();
			if (msg.length() % 2 != 0) {
				System.out.println("짝수개의 문자가 필요합니다.");
				// while 처음으로 이동
				continue;
			}
			break; // while문 종료
		}

		// 변수 => 사용범위 => {}

		boolean bCheck = true;
		for (int i = 0; i < msg.length() / 2; i++) {
			char s = msg.charAt(i);
			char e = msg.charAt(msg.length() - 1 - i);
			if (s != e) {
				bCheck = false;
				break;
			}
		}

		// 결과값
		if (bCheck) {
			System.out.println("좌우 대칭입니다.");
		} else {
			System.out.println("좌우 대칭이 아닙니다.");
		}

		// if의 사용 목적 => 오류 처리
	}

}
