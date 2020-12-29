/*
 * 	산술연산자 = 이항연산자 (연산대상이 2개가 필요하다)
 * 	=======
 * 	+(덧셈), -(뺄셈), *(곱셈), /(나눗셈), %(나머지)
 * 	1) 우선순위 
 * 	   a. *, /, %
 * 	   b. +, -
 * 
 * 	2) 다른 데이터형이 연산된 경우 (가장 큰 데이터형으로 변경훙에 연산)
 * 		int + double
 * 	  	===
 * 		double + double (연산은 항상 같은 데이터형만 연산처리된다) => 자동 형변환
 * 
 * 		char + int
 * 		====
 * 		int + int
 * 	
 * 		int + long
 * 		====
 * 		long + long
 * 		
 * 		char + byte (결과값) int
 * 		===========
 * 		int + int
 * 		
 * 		short + short
 * 		=============
 * 		int + int
 */
public class 연산자_산술연산자 {

	public static void main(String[] args) {
		byte b1 = 10;
		byte b2 = 20;
		int b3 = b1 + b2;
		System.out.println("b3 = " + b3);
		
		/*
		 * byte b3 = (byte)(b1 + b2);
		 * int b3 = b1 + b2;
		 */
		
		int a = 10;
		double d = 10.5;
		// a + d한 결과를 출력해라
		int res = (int)(a + d);
		System.out.println(res);
		
		double d1 = 10.5;
		double d2 = 10.5;
//		int res1 = (int)(d1 + d2);
		int res1 = (int)d1 + (int)d2;
		System.out.println(res1);
		
		// 뺄셈 ==> (-)
		int i = 10;
		int j = 6;
		// i, j는 모양이 헷갈리기 때문에 사용을 지양한다.
		int z = i - j;
		System.out.println("z = " + z);
		
		// 곱셈 => (*)
		i = 10;
		j = 6;
		z = i * j;
		System.out.println("z = " + z);
		
		
		
	}

}
