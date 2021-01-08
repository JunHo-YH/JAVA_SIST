/*
 * 	자바 => 알고리즘 (순서) => 라이브러리 => 조립
 * 		   ===========
 * 			=> 제어문
 * =====================================
 * 	재사용기법 (변경, 추가), 데이터 보호(캡슐화)
 * =====================================
 *  비정상 종료를 방지하는 프로그램(예외처리)
 * =====================================
 * 
 * 1. 사용자가 년도 / 월 입력
 * 2. 처리 => 달력 출력
 * 	2-1. 매월 1일자의 요일을 확인
 * 	2-2. 달력을 출력
 */

import java.util.Scanner;

public class 달력만들기 {

	public static void main(String[] args) {
		// 1. 사용자 입력을 받는다.
		Scanner scan = new Scanner(System.in); // System.in => 키보드 입력값을 읽어오는 기능

		// 년도 입력
		System.out.print("년도 입력: ");
		int year = scan.nextInt();
		System.out.print("월 입력: ");
		int month = scan.nextInt();
		
		// 사용자가 요청한 년/월에 대한 달력
		// 출력
		System.out.println(year + "년도 " + month + "월");
		System.out.println("\n");
		/*
		 * System.out.print("일\t");
		 * System.out.print("월\t"); 
		 * System.out.print("화\t");
		 * System.out.print("수\t"); 
		 * System.out.print("목\t"); 
		 * System.out.print("금\t");
		 * System.out.print("토\t");
		 */

		String[] strWeek = { "일", "월", "화", "수", "목", "금", "토" };
		for (String week : strWeek)
			System.out.print(week + "\t");
		System.out.println(); // 다음줄에 출력
		/*
		 * 2021년 1월 => 2021년 1월 1일 ~ 2020년 12월 31일 ============================= +1 (총날수
		 * % 7)
		 */

		// 1. 전년도까지의 합
		int total = (year - 1) * 365 + (year - 1) / 4 
				- (year - 1) / 100 
				+ (year - 1) / 400;
		// 2. 전달까지의 합
		int[] lastDay = { 31, 28, 31, 30, 31, 30,
				31, 31, 30, 31, 30, 31 };
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // 윤년 2월 => 29
			lastDay[1] = 29;
		else
			lastDay[1] = 28;
		
		for (int i = 0; i < month - 1; i++) {
			total += lastDay[i];
		}
		
		// 3. +1
		total++; // 각 달의 1일자 확인

		int week = total % 7; // 요일 구하기
		for (int i = 1; i <= lastDay[month - 1]; i++) {
			if (i == 1) {
				for (int k = 0; k < week; k++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t", i);
			week++;
			if (week > 6) {
				week = 0;
				System.out.println();
			}

		}

	}

}
