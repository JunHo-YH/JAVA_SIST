
// 요일 구하기
import java.util.Scanner;

public class 배열활용_1 {

	public static void main(String[] args) {
		String[] strWeek = {"일", "월", "화", "수", "목", "금", "토"};
		/*
		 * 	1년도 1월 1일(월) ~ 2020.12.30 => 총 날짜 수
		 * 	+ 20201.1월 1일 ~ 전달까지의 총 날짜 수
		 * 	+ 입력된 날짜
		 * =======================================
		 * % 7 => 요일
		 * Calendar
		 */
		
		// 사용자가 년도-월-일을 입력해서 처리
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력: ");
		int year = scan.nextInt();
		
		System.out.print("월 입력: ");
		int month = scan.nextInt();
		
		System.out.print("일 입력: ");
		int day = scan.nextInt();
		
		// 요일 구하기
		// 1. 2021년도 1월 1일 ~ 작년 (2020-12-31)
		int total = (year-1) * 365 + (year-1) / 4
								   - (year-1) / 100
								   + (year-1) / 400;
		
		int[] lastDay = {31, 28, 31, 30, 31, 30,
						 31, 31, 30, 31, 30, 31};
				
		// 윤년 조건
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
		{
			lastDay[1] = 29;
		}
		else
		{
			lastDay[1] = 28;
		}
		
		// 전달까지의 합
		for (int i = 0; i < month-1; i++) {
			total += lastDay[i];
		}
		
		// 입력한 날짜 첨부
		total += day;
		int week = total % 7;
		
		
		
		// 출력
		System.out.printf("%d년 %d월 %d일은 %s요일입니다.", year, month, day,strWeek[week]);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
