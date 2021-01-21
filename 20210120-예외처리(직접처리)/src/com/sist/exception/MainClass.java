package com.sist.exception;

/*
 * 에러
 *  1. 에러: 소스상에서 수정할 수 없는 에러: 메모리 부족, 운영체제 문제
 *  2. 예외: 소스상에서 수정할 수 있는 에러: 사용자의 입력이 잘못된 경우, 파일명이 틀리다.
 *     ==================================================================
 *     예외 회피: 간접 처리 throws
 *     예외 처리: 직접 처리 try~catch
 *              임의 발생 throw
 *              사용자 정의 예외처리
 *     ===================================================================
 *     예외처리 목적: 비정상 종료 방지하고 정상 종료를 할 수 있게 만드는 과정
 */
public class MainClass {

	public static void main(String[] args) {

		try {
			int a = 10;
			int b = 0;
			int result = a / b;
		} catch (ArithmeticException e) {
			System.out.println("나누는 수를 다시 확인하세요");
		}
		System.out.println("프로그램 종료");

	}

}
