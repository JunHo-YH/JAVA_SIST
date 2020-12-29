/*
 * 	형식
 * 	===
 * 	(데이터형)값 => 데이터형을 변경할 때 사용
 * 	예)	=> 제외하는 데이터형 (boolean)
 * 		정수를 문자로 변경
 * 		(char)68 ==> 'D'
 * 		실수를 정수로 변경
 * 		(int)10.8
 * 		
 */
public class 연산자_형변환연산자 {

	public static void main(String[] args) {
		double d = 100.99;
		float f = (float) 100.99;
		
		System.out.println("d = " + d);
		System.out.println("f = " + f);
		// 명령어 => double => 정수 (int)
		int a = (int)d; // 100
		System.out.println("a= " + a);
		
		// 명령어 float => 문자
		char c = (char)f;
		System.out.println("c = " + c);
	}
}
