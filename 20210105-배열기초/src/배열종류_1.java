import java.util.Scanner;

public class 배열종류_1 {

	public static void main(String[] args) {
		// 3명의 학생 => 국어, 영어, 수학 점수를 입력 받아서 총점, 평균, 학점 구하기
		/*
		 * 배열 => 관련된 데이터를 모아서 관리
		 */
		// 국어 => 3명
		int[] kor = new int[3];

		// 영어 => 3명
		int[] eng = new int[3];

		// 수학 3명
		int[] math = new int[3];

		// 총점
		int[] total = new int[3];

		// 평균
		double[] avg = new double[3];

		// 학점
		char[] score = new char[3];
		
		// 등수를 저장할 변수 => 3개 묶어서 처리
		int[] rank = new int[3];
		

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.print((i + 1) + "번째 국어 점수를 입력: ");
			kor[i] = scan.nextInt();

			System.out.print((i + 1) + "번째 영어 점수를 입력: ");
			eng[i] = scan.nextInt();

			System.out.print((i + 1) + "번째 수학 점수를 입력: ");
			math[i] = scan.nextInt();
			System.out.println();
		}
		// 총점
		for (int i = 0; i < 3; i++)
			total[i] = kor[i] + eng[i] + math[i];

		// 평균
		for (int i = 0; i < 3; i++)
			avg[i] = total[i] / 3.0;

		// 학점 구하기
		for (int i = 0; i < 3; i++) {
			switch ((int) (avg[i] / 10)) {
			case 10:
			case 9:
				score[i] = 'A';
				break;
			case 8:
				score[i] = 'B';
				break;
			case 7:
				score[i] = 'C';
				break;
			case 6:
				score[i] = 'D';
				break;
			default:
				score[i] = 'F';
			} // 정수 문자 문자열
		}
		
		// 등수 구하기 => 비교 (이차 for)
		for (int i = 0; i < 3; i++) {
			rank[i] = 1;
			for (int k = 0; k < 3; k++) {
				if (total[i] < total[k])
					rank[i]++;
			}
		}

		// 출력
		for (int i = 0; i < 3; i++) {
			System.out.printf("국어는 %d점, 영어는 %d점, 수학은 %d점, 총점은 %d점, 평균은%.2f점입니다. %d번째 학생의 학점은 %c입니다. 등수: %d등\n", kor[i], eng[i], math[i], total[i],
					avg[i], i+1, score[i], rank[i]);
		}

	}

}
