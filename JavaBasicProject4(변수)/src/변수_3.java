//  변수값 설정
public class 변수_3 {

	public static void main(String[] args) {
		// 두 개의 변수 x = 10, y = 20;
		int x = 10, y = 20;
		x = y; // y가 가지고 있는 정수값을 x에 대입하라 ==> x = 20;
		y = x; // x가 가지고 있는 정수값을 y에 대입히라 ==> y = 20;

		// 국어점수, 수학점수, 영어점수 => 점수를 저장한 후에 출력 국어, 영어, 수학, 총점, 평균 출력
		int kor = 100;
		int eng = 95;
		int math = 90;
		int total = kor + eng + math;
		double avg = total / 3f;
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + math);
		System.out.println("총점: " + total);

		System.out.println("평균: " + avg);

		System.out.printf("%.5f\n", 10 / 3.0);
		/*
		 * 서식이 있는 출력 사용기호 %d ==> 정수 %c ==> 문자 %s ==> 문자열 %f ==> 실수
		 * 
		 * 특수 기호 \n => new Line : 다음 줄에 출력 \t => tab : 일정간격 띄울 때
		 * 
		 * System.out.println()
		 * 
		 */

		System.out.printf("%d\n", 100);
		System.out.printf("%s\n", "Hello");
		System.out.printf("%c\n", 'A');

		System.out.println("100  80  70");
		System.out.printf("%-5d %-5d %-5d", 100, 80, 70);
	}

}
