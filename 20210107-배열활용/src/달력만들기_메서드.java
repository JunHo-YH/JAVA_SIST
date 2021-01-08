/*
 * 1. 입력
 * 2. 처리
 * 3. 출력
 * 
 * 
 * ==== 메서드
 * 1. 매개변수: 사용자 입력값
 * 2. 결과값: 
 */


import java.util.Scanner;

public class 달력만들기_메서드 {
	static int input(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + " 입력:");
		return scan.nextInt();
	}
	// 요일 출력
	static void weekPrint() {
		String[] strWeek = { "일", "월", "화", "수", "목", "금", "토" };
		for (String week : strWeek)
			System.out.print(week + "\t");
		System.out.println(); // 다음줄에 출력
	}
	
	static boolean isYear(int year) {
		boolean bCheck = false;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			bCheck = true;
		}
		return bCheck;
	}
	
	
	// 요일 구하기 (처리)
	static int weekData(int year, int month) {
		// 1. 전년도까지의 합
		int total = (year - 1) * 365 + (year - 1) / 4 
									 - (year - 1) / 100 
									 + (year - 1) / 400;
		// 2. 전달까지의 합
		int[] lastDay = { 31, 28, 31, 30, 31, 30,
						  31, 31, 30, 31, 30, 31 };
		/*
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // 윤년 2월 => 29
				lastDay[1] = 29;
				else
					lastDay[1] = 28;
				
				for (int i = 0; i < month - 1; i++) {
					total += lastDay[i];
				}
		*/
		if(isYear(year)) {
			lastDay[1] = 29;
		} else {
			lastDay[1] = 28;
		}
				
		// 3. +1
		total++; // 각 달의 1일자 확인

		int week = total % 7; // 요일 구하기
				
		return week;
	}
	static int getLastDay(int month) {
		int[] lastDay = { 31, 28, 31, 30, 31, 30,
				  31, 31, 30, 31, 30, 31 };
		return lastDay[month - 1];
	}
	
	// 출력 메서드
	static void dataPrint(int month, int week) {
		
		for (int i = 1; i <= getLastDay(month); i++) {
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
	
	
	public static void main(String[] args) {
		int year = input("년도");
		int month = input("월");
		
		System.out.println(year + "년도 " + month + "월");
		
		// 요일 출력
		weekPrint();
		int week = weekData(year, month);
		
		// 출력
		dataPrint(month, week);
	}

}
