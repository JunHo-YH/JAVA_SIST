/*
 * 	중첩 => if안에 if가 첨부(이중 if)
 * 	형식)
 * 		if(조건문)
 * 		{
 * 			if(조건문)
 * 			{
 * 
 * 			}
 * 		}
 * 
 * 		==> if(조건문 &&(||) 조건문)
 */

// 3개정수의 정수를 받아서 평균, 총점, 학점 ( >= 98 A+    94 <= A- )
import java.util.Scanner;

public class 중첩조건문 {

	public static void main(String[] args) {
		// 저장하는 데이터 => 메모리 (변수)
		int kor, eng, math, total, avg;
		char score = ' ', option = ' '; // + - 0
		// 초기값
		Scanner scan = new Scanner(System.in);
		// 국어, 영어, 수학
		System.out.print("국어 영어 수학( 90 90 90)");
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		// 총점
		total = kor + eng + math;
		// 평균
		avg = total / 3;
		// 학점
		if(avg > 90) {
			score = 'A';
			if(avg >= 98) {
				option = '+';
			}
			else if(avg <= 94) {
				option = '-';
			}
			else {
				option = '0';
			}
		}
		else if(avg >= 80) {
			score = 'B';
			if(avg >= 88) {
				option = '+';
			}
			else if(avg <= 94) {
				option = '-';
			}
			else {
				option = '0';
			}
		}
		else if(avg >= 70) {
			score = 'C';
			if(avg >= 78) {
				option = '+';
			}
			else if(avg <= 94) {
				option = '-';
			}
			else {
				option = '0';
			}
		}
		else if(avg >= 60) {
			score = 'D';
			if(avg >= 68) {
				option = '+';
			}
			else if(avg <= 94) {
				option = '-';
			}
			else {
				option = '0';
			}
		}
		else {
			score = 'F';
		}
		// 출력
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
		System.out.printf("학점: %c%c\n", score, option);
	}

}
