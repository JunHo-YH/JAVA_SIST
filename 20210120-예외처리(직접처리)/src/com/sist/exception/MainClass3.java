package com.sist.exception;

/*
 * 사용자로부터 2개의 정수를 받아서 배열에 저장한 다음에 두개를 나누기한 경과값을 출력
 *                          =========             =====              
 */
import java.util.Scanner;

public class MainClass3 {

	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("첫번째 정수 입력");
			int a = scan.nextInt();
			System.out.println("두번쨰 정수 입력");
			int b = scan.nextInt();

			int[] arr = { a, b };
			int res = arr[0] / arr[1];
			System.out.println("res" + res);
			// catch에 등록한 예외처리클래스에 순서가 존재한다
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 범위를 초과했습니다.");

		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (RuntimeException e) {
			System.out.println("예측 못한 예외 발생했습니다.");
		}
		System.out.println("프로그램 종료");

	}

}
