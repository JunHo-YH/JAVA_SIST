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
		// ���� ���ϱ�
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

		// Ȯ��
		/*
		 * for (int j : score) { // for-each���� ������ Ÿ���� ������ ������ �߻� -> �ٸ� ���� ����ؾ��Ѵ�.
		 * System.out.print(i + " "); }
		 */

		for (i = 0; i < score.length; i++) {
			System.out.println(score[i] + ":" + hakjum[i]);
		}

	}

}
