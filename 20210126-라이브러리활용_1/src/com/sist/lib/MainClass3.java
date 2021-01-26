package com.sist.lib;

import java.text.*;
import java.util.Random;
import java.util.Scanner;

public class MainClass3 {
	// 예매율 => rating => 왓차
	public static void main(String[] args) {
		double[] limits = { 50, 60, 70, 80, 90 };
		String[] grades = { "F", "D", "C", "B", "A" };
		
		Scanner scan = new Scanner(System.in);
		int[] score = new int[10];
		Random r = new Random();
		for (int i = 0; i < score.length; i++) {
			score[i] = r.nextInt(50) + 51; // 51 ~ 100
		}
		
		ChoiceFormat format = new ChoiceFormat(limits, grades);
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i] + ":" + format.format(score[i]));
			                                                 //score[i]의 값과 매칭되는 값을 가져온다.
		}

	}

}
