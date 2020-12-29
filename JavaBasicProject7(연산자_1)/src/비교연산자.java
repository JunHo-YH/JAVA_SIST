/*
 * 	숫자를 비교해서 정답 => true, 오답 => false
 * 	6 == 9 => false
 * 	6 == 6 => true
 * ================== 비교연산자의 결과값은 true / false
 * 비교연산자의 종료
 * ==================
 * == 같다
 * != 같지 않다
 * < 작다
 * > 크다
 * <= 작거나 같다
 * >= 크거나 같다
 * 
 * ==
 * 	10 == 10 true
 *  10 != 10 false
 *  10 < 11 true
 *  10 > 11 false
 *  10 <= 10 true (10 == 10 || 10 < 10)
 *  10 >= 10 true (10 == 10 || 10 > 10)
 *  			========================== ||는 둘 중에 한 개만 true => true (오른쪽 계산하지 않는다)
 *  
 *  => 원하는 데이터만 출력하고 싶을 때 비교연산자를 사용한다.
 * 
 */
public class 비교연산자 {

	public static void main(String[] args) {
//		long l = (long)(27000000000);
		
		int a = 10;
		int b = 11;
		System.out.println("a == b? " + (a == b));
		System.out.println("a == b? " + (a != b));
		System.out.println("a < b? " + (a < b));
		System.out.println("a > b? " + (a > b));
		System.out.println("a <= b? " + (a <= b));
		System.out.println("a >= b? " + (a >= b));
//		System.out.println("a < b? " + (a < b));
		System.out.println();
		System.out.println(++a == b);
		System.out.println(a);
		// 제어문 ==> 조건문, 반복문(조건_에서 주로 사용
		// 총알 => 비행기안에 들어 갔는지 여부
		
		String dap = a % 2 == 0 ? "짝수" : "홀수";
		System.out.println(dap);
		
	}

}
