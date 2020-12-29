// Scanner : 키보드 입력값을 받아서 메모리에 저장
// BufferedReader : 예외처리
// Scanner를 사용하기 위해서 반드시 클래스를 불러와야 한다.
// 이미 만들어진 클래스를 읽어올 때 사용 : import
import java.util.Scanner;
/*
 * 	import : 자바, 코틀린
 * 	include : C
 * 	using : C#
 *
 * 	
 */
public class 변수_4 {

	public static void main(String[] args) {
	// Scanner를 사용하는 방법
		Scanner scan = new Scanner(System.in);
		// new => 메모리 할당, System.in => 키보드 입력값
//		System.out.print("정수 입력: ");
		// 키보드로 입력한 정수를 저장한다.
//		int input = scan.nextInt();
//		System.out.println("키보드 입력값 : " + input);
		int kor, eng, math;
		
		System.out.print("국어 점수 입력 >> ");
		kor = scan.nextInt();
		System.out.print("영어 점수 입력 >> ");
		eng = scan.nextInt();
		System.out.print("수학 점수 입력 >> ");
		math = scan.nextInt();
		int total = kor + eng + math;
		double avg = (total) / 3.0;
		// 결과값을 출력
		System.out.println("총점 : " + total);
		System.out.printf("%.2f", avg );
		
		// 사용자로부터 입력값을 받아서 처리 Scanner
		/*
		 * 입력
		 * 	Scanner => 키보드 입력값을 받는 경우에 주로 사용
		 * 	// Scanner => 클래스
		 * 	= import java.util.Scanner
		 * 	= Scanner를 저장
		 * 	  *** 클래스를 저장할 시에는 반드시 new를 사용해서 저장
		 * 	  Scanner scan = new Scanner(System.in);
		 * 	= 입력이 되면
		 * 	  *** scan.nextInt() =>  정수를 입력 할 때
		 * 	  ** scan.next(); => 문자열을 입력할 때
		 * 	  scan.nextDouble(); => 실수를 입력할 때
		 * 	  scan.nextBoolean(); => 논리값을 입력할 때
		*/		
		
	}

}
