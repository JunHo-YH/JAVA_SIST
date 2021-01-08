// 학점을 계산하는 메서드 만들기

import java.util.Scanner;

public class 메서드활용_2 {
	// 반복 제거
	static int input(String subject) {
		Scanner scan = new Scanner(System.in);
		System.out.print(subject + "점수 입력: ");
		return scan.nextInt();

	}
	// 학점을 구하는 메서드 만들기(재사용을 위해서)
	static char getScore(int avg) {
		char score ='A';
		switch(avg) {
		case 10: case 9:
			score = 'A';
			break;
		case 8:
			score = 'B';
			break;
		case 7:
			score = 'C';
			break;
		case 6:
			score = 'D';
			break;
		default:
			score = 'F';
			break;
		
		}
		return score;
	}

	public static void main(String[] args) {
		int kor, eng, math;
		char score = 'A';
		// 사용자가 입력
		/*
		 * Scanner scan = new Scanner(System.in); System.out.print("국어 점수 입력: "); kor =
		 * scan.nextInt(); System.out.print("영어 점수 입력: "); eng = scan.nextInt();
		 * System.out.print("수학 점수 입력: "); math = scan.nextInt();
		 */
		kor = input("국어");
		eng = input("영어");
		math = input("수학");
		
		// 학점
		int avg = (kor + eng + math) / 30;
		score = getScore(avg); // => 메서드 호출 => 메서드 처음부터 실행 => 결과값을 넘겨주고 다음 문장으로 넘어간다.
		/*
			switch(avg) {
			case 10: case 9:
				score = 'A';
				break;
			case 8:
				score = 'B';
				break;
			case 7:
				score = 'C';
				break;
			case 6:
				score = 'D';
				break;
			default:
				score = 'F';
				break;
			
			}
		*/
		

		System.out.println("국어:" + kor);
		System.out.println("영어:" + eng);
		System.out.println("수학:" + math);
		System.out.println("총점: " + (kor + eng + math));
		System.out.printf("평균: %.2f\n", (kor + eng + math) / 3f);
		System.out.println("최종학점: " + score);

	}

}
