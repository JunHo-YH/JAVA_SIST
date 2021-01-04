/*
 * 17) 문자 하나를 입력받아 대문자인지 소문자인지를 판별하는 프로그램
 */

import java.util.Scanner;

public class 문제17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열을 입력하세요: ");
		String s = scan.next();
//		char c = s.charAt(0);
		// s.length() => 입력된 문자의 갯수
		/*
		 * 
		 */
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				System.out.println(c + "은(는) 대문자입니다 !");
			} else if ( c >= 'a' && c <= 'z') {
				System.out.println(c + "은(는) 소문자입니다.");
			} else {
				System.out.println(c + "은(는) 알파벳이 아닙니다.");
			}
		}
	}

}
