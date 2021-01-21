package com.sist.main;

/*
 * 복구
 * 회피
 * 전환 => 임의로 에러를 발생할 수 있다.
 */
public class MainClass3 {

	public static void main(String[] args) throws Exception {
		try {
			String s = " 100";
			int i = Integer.parseInt(s); // 문자열을 정수로 변환
		} catch (NumberFormatException ex) {

			try {
				System.out.println("정수 변환 오류");
				throw new Exception(); // 예외 처리 호출
				// throw => 사용자 정의 예외처리 호출할 때 주로 사용
				// throw => 마지막줄에 소스코딩
			} catch (Exception e) {
				System.out.println("다시 입력하세요!!");
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("배열 범위 초과");
		} catch (Exception e) {

		}
	}

}
