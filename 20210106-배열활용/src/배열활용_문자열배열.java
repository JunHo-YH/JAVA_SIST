// 문자열 => String => char[]
/*
 *  String: 데이터형, 클래스형 (문자열을 제어할 수 있는 기능 = 메서드)
 *  문자열에서 문자 한 개를 가지고 올 때 => charAt()
 *  ABCDEFG
 *  0123456
 *  문자열의 개수 확인 => length()
 *  문자열 비교 => Login (id, pwd) => equals()
 *  문자열 포함된 단어 => contains()
 *  ============================
 *  시작하는 문자열 => startsWith()
 *  끝나는 문자열 => endsWith()
 *  ============================ 서제스트 => 자동완성 기능( ~ 로 시작하는 검색어) => 검색기능에서 사용
 *  문자열을 자르는 경우 => subㄴtring() ==> A.java (확장자, 특정 단어를 추출할 때 사용)
 *  문자열 => 대문자, 소문자 
 *          ====  ====
 * toUpperCase(), toLowerCase()
 * 
 */

import java.util.Scanner;

public class 배열활용_문자열배열 {

	public static void main(String[] args) {

		// 1. 문자의 갯수 가지고 오기 (length())
		String data = "Hello Java!!"; // 공백도 포함
		System.out.println("문자의 갯수: " + data.length());

		// 2. 대문자로 변환 (toUpperCase())
		// char c = 'a' => (c-32) => 'A'
		System.out.println("대문자 변환:" + data.toUpperCase()); // 알파벳만 변경

		// 3. 소문자로 변환 (toLowerCase())
		// char c = 'A' => (c+32) => 'a'
		System.out.println("소문자 변환: " + data.toLowerCase());

		// 4. charAt(index) => 문자열은 번호 0번 부터 시작

		/*
		 * Hello Java!! 012345678910111
		 * 
		 * J ==> charAt(6)
		 */
		System.out.println("문자 한 개 읽기: " + data.charAt(8));

		// 5. contains() => 문자열중에 특정문자가 포함 => true / false
		System.out.println("포함여부: " + data.contains("Java")); // 오라클의 LIKE와 같다. ==> 우편번호 검색
		
		Scanner scan = new Scanner(System.in);
		String[] find_data = {"자바라자바",
								"자바",
								"자바라 칸막이",
								"자바라 호스",
								"자반증",
								"자바 다운로드",
								"자바라 문",
								"자바라 자바",
								"자바라 커튼",
								"자바 스크립트",
								"자발적 퇴사 실업급여 자바",
								"자바라 천막",
								"자바나스 자바",
								"자바스크립트 오류 해결",	
								"자반 고등어"};
		System.out.print("검색어 입력: ");
		String fd = scan.next(); // 검색어를 받는다.
		for (String s : find_data) { // 자동 완성기 (검색기)
			if (s.endsWith(fd)) {
				System.out.println(s);
			}
		}
	}

}
