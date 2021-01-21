package com.sist.main;

public class MainClass4 {

	public static void main(String[] args) {
		try {
			int a = 10;
			if (a % 2 == 0) {
				throw new MyException("홀수만 사용이 가능하다");
				// 사용자 정의 예외는 자바시스템에서 찾지 못하기 때문에 직접 호출

			}
		} catch (NumberFormatException ex) {

		} catch (MyException m) {
			System.out.println(m.getMessage());
		} catch (Exception e) {

		}
	}

}
