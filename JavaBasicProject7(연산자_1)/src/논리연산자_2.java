/*
 * 	|| 연산자
 * 	형식)
 * 		조건 || 조건
 * 		==	   ==	조건은 항상 true / false ==> 최종 결과값: true / false
 * 		조건을 만들 때 : 사용할 수 있는 연산자 (부정연산자, 비교연산자)
 * 										!(boolean), ==, !=, <, >, <=, >=
 * 										
 * 		조건 || 조건
 * 		==     ==
 * 		true	true	=> true
 * 		true	false	=> true
 * 		false	true	=> true
 * 		false	false	=> false
 * 		=====	=====		
 * 		  1	 ||   2
 * 			====
 * 			 3 ===========> 결과값
 * 		*** 효율적인 연산
 * 			= 왼쪽편의 조건이 true일 경우
 * 
 * 		*** 예매할 수 있는 기간을 나타낼 때 사용할 수 있다.
 */
public class 논리연산자_2 {

	public static void main(String[] args) {
		int a = 10;
		int b = 9;
		boolean bCheck =  (a % 2 == 0 || ++b == a);
		//								==========> 조건을 검색 X
		
		System.out.println(bCheck);
		System.out.println(a);
		System.out.println(b);
		
		bCheck = (a % 2 != 0 || ++b == a);
		/*
		 * 	a % 2 != 0 => false
		 * 	++b == a => true ==> 조건을 검색
		 * 	false || true
		 */
		
		System.out.println("a % 2 != 0 ?" + bCheck);
		System.out.println(a);
		System.out.println(b);
	}

}
