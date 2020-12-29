/*
 * 	논리연산자 : 효율적인 계산처리
 * 	&& : 왼쪽편의 조건이 false => false
 * 	|| : 왼쪽편의 조건이 true => true
 */
public class 논리연산자_1 {

	public static void main(String[] args) {
		int a = 10;
		int b = 9;
		boolean bCheck = (a > b && b == a);
		/*
		 * 
		 */
		System.out.println("a" + a);
		System.out.println("b" + b);
		System.out.println("결과: " + bCheck);
		
		
		
		
		
	}

}
