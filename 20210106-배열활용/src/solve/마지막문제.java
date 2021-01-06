package solve;

import java.util.Scanner;

public class 마지막문제 {

	public static void main(String[] args) {
		String[] course = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드" };
		int[] score = { 95, 88, 76, 62, 55 };
		String subject;
		int i = 0;

		while (true) {
//			boolean bCheck = false;
			Scanner scan = new Scanner(System.in);
			System.out.println("점수를 알고 싶은 과목을 입력하세요: (java, c++, HTML5, 컴퓨터구조, 안드로이드)");
			subject = scan.next();

			if (subject.equals("그만")) {
				System.out.println("프로그램이 종료됐습니다.");
				break;
			}

			for (i = 0; i < course.length; i++) {
				if (course[i].equalsIgnoreCase(subject)) {
//					bCheck = true;
					System.out.print(course[i] + "의 점수는: " + score[i] + "점입니다.");
					System.out.println();
					break;
				}
			}
//			if(bCheck == false)
			if (i == course.length) {
				System.out.print("없는 과목입니다.");
				System.out.println();
			}

		}

	}

}
