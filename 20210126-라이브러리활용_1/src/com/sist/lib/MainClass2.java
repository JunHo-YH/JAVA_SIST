package com.sist.lib;

// ChoiceFormat
import java.util.*; // Scanner
import java.text.*; // ChoiceFormat

public class MainClass2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] score = new int[10];
		Random r = new Random();
		int i = 0;
		for (i = 0; i < score.length; i++) {
			score[i] = r.nextInt(50) + 51; // 51 ~ 100
		}
		// 학점 구하기
		char[] hakjum = new char[10];
		for (i = 0; i < score.length; i++) {
			switch (score[i] / 10) {
			case 10:
			case 9:
				hakjum[i] = 'A';
				break;
			case 8:
				hakjum[i] = 'B';
				break;
			case 7:
				hakjum[i] = 'C';
				break;
			case 6:
				hakjum[i] = 'D';
				break;
			default:
				hakjum[i] = 'F';

			}
		}

		// 확인
		/*
		 * for (int j : score) { // for-each문은 데이터 타입이 빠지면 오류가 발생 -> 다른 변수 사용해야한다.
		 * System.out.print(i + " "); }
		 */

		for (i = 0; i < score.length; i++) {
			System.out.println(score[i] + ":" + hakjum[i]);
		}

	}

}
