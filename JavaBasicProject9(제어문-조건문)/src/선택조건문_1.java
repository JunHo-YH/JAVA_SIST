/*
 * 	형식)
 * 		if(조건문) => 조건문(연산자, 부정, 비교, 논리)
 * 		{
 * 			조건문이 true일 때, 처리하는 문장
 * 			(여러 문장을 수행할 수 있다)
 * 		}
 * 		else
 * 		{
 * 			조건문이 false일 경우에 처리되는 문장
 * 			(여러 문장을 수행할 수 있다)
 * 		}
 * 
 * 	오류)
 * 		if(조건문)
 * 			실행문장 1
 * 			실행문장 2 << if와 else의 관계를 끊어버린다.
 * 		else =================================> if 밑에서 처리 (else는 단독 실행문장을 만들 수 없다)
 * 			실행문장 3
 * 		
 *		자바
 * 		if(조건문) {
 * 			
 * 		}
 * 
 * 		C언어
 * 		if(조건문)
 * 		{
 * 
 * 		}
 */
// 3개의 정수를 입력 => 평균 ==> 60이상이면 Pass 아니면 Non-Pass
import java.util.Scanner;

public class 선택조건문_1 {

	public static void main(String[] args) {
		// 입력받은 데이터를 저장할 공간 => 정수 4개
		Scanner scan = new Scanner(System.in);
		int kor, eng, math, avg;
		System.out.print("국어 영어 수학 점수 입력 >> "); // enter, space
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		/*
		System.out.print("국어의 점수를 입력하세요 >> ");
		kor = scan.nextInt();
		
		System.out.print("영어의 점수를 입력하세요 >> ");
		eng = scan.nextInt();

		System.out.print("수학의 점수를 입력하세요 >> ");
		math = scan.nextInt();
		*/
		
		avg = (kor + eng + math) / 3;
		
		System.out.println("평균점수는 " + avg + "점입니다.");
		if(avg >= 60)
			System.out.println("Pass !");
		else
			System.out.println("Non-Pass");
		
	}

}



















