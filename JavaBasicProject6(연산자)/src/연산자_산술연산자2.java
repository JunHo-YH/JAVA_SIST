/*
 * 	산술연산자
 * 	=======
 *   / , %
 *   나눗셈(/)
 *   	1. 0으로 나눌 수 없다. ex) 10 / 0 => error
 *   	2. 정수 / 정수 = 정수
 *   	   5 / 2 => 2.5(X)   5 / 2 = 2 ======> 5 / 2.0 = 2.5(O)
 *   	   double d = 5 / 2 ==> 2.0
 *   
 *   나누고 나머지값(%)
 *   	1. 주의점 : 결과값은 왼쪽편의 부호를 따라간다.
 *   		5 % 2 ===> 1      1 + 4/2
 *   	   -5 % 2 ===> -1     -1 -4/2
 *   		5 % -2  => 1	  1+ 4/-2
 *   	   -5 % -2  => -1	  -1 -4/-2
 *			
 *
 *   	
 */
public class 연산자_산술연산자2 {

	public static void main(String[] args) {
		int a1 = 5;
		int a2 = 2;
		int a3 = -5;
		int a4 = -2;
		byte a = 10;
		byte b = 20;
		int c = a + b;
		System.out.println(c);
		long l = (long)(3000 * 3000 * 3000);
		System.out.println(l);
		System.out.println(a1 % a2);
		System.out.println(a1 % a4);
		System.out.println(a3 % a2);
		System.out.println(a3 % a4);
	}
}
