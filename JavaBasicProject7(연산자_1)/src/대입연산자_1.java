/*
 * 	대입 연산자 ( = )
 * 	복합 대입연산자 ( +=, -=, *=, /=, %=, <<=, >>=, &=, |=, ^=)
 * 				=> 논리연산자, 비교연산자는 제외
 * 
 * 	문자열 비교 -> equals 
 * 	===============================================================
 * 	대입연산자 : 값을 대입
 * 				1. 초기화
 * 					int a = 10; 10을 a라는 메모리 공간에 대입해라.
 * 					
 * 				2. 연산결과를 대입
 * 					int a = 10 + 20;
 * 							======= 연산처리 (결과가 어떤 데이터형인지?)
 * 							double d = int + double
 * 
 * 	복합 대입연산자 :  연산자 두 개가 합쳐서 한 개의 연산자를 만들었다.
 * 					+=, -=, x=, /= ...  op = 
 */
public class 대입연산자_1 {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		boolean bCheck = s1.equals(s2);
		String result = bCheck == true ? "s1==s2" : "s1 != s2";
		System.out.println(result);
		
		byte a = 1;
		byte b = 2;
		byte c = (byte) (a + b);
	}

}
