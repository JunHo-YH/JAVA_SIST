// equals: 문자열 비교 (일반 데이터 ==)

import java.util.Scanner;

public class 배열활용_7_문자열비교 {

	public static void main(String[] args) {
		final String ID = "Admin"; // char[] id ={'A', 'd', 'm', 'i', 'n'}
		final String PWD = "1234";

		Scanner scan = new Scanner(System.in);
		String myId = "";
		String myPwd = "";

		System.out.print("ID를 입력하세요: ");
		myId = scan.next();

		System.out.print("비밀번호를 입력하세요: ");
		myPwd = scan.next();
		
		
		/*
		 * equalsIgnoreCase = 대소문자 구분없이
		 * equals = 대소문자 구분
		 */
		if (myId.equals(ID) && myPwd.equals(PWD)) { // 대소문자 구분, ==이 아니라 equals로 비교해야 값을 비교한다. ==은 저장 공간의 주소값을 비교한다.
			System.out.println(myId + "님 로그인되었습니다.");

		} else {
			System.out.println("ID나 비밀번호가 틀렸습니다.");
		}
	}

}
