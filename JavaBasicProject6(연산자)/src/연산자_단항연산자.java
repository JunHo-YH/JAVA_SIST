/*
 * 자바 연산자
 * ========
 * 1. 단항 연산자
 * 		= 증감연산자 (한 개 증가, 한 개 감소)
 * 		  ============================> 제어문 (반복문)
 * 		  게임에서 키보드를 눌러서 캐릭터, 비행기 이동할 때 사용
 * 		  ++(1증가), --(1감소)
 * 		= 부정연산자 : ! => boolean
 * 		  true  => !true  => false
 * 		  false => !false => true
 * 		  ========================
 * 		  게임 : 턴제 게임
 * 		  boolean bCheck = false;
 * 		  while(true)
 * 		  {
 * 			bCheck = !bCheck
 * 			if(bCheck == true)
 * 				본인
 * 			else
 * 				컴퓨터
 * 		  }
 * 		  = (데이터형) 형변환 연산자
 * 2. 이항 연산자 (연산대상 2개)
 * 		= 산술연산자 ( +, -, x, /, %)
 * 		  5 % 2 ==> 1(나머지 값)
 * 
 * 		= 비트연산자 (&, |, ^) => 논리회로
 * 		= 비트이동연산자 ( <<, >> ) => 쉬프트 연산자
 * 		= 비교연산자 ( == 같다, != 같지 않다, < 작다, > 크다, <= 작거나 같다, >= 크거나 같다)
 * 		  =======> boolean (true / false)
 * 		= 논리연산자 (&&, ||)
 * 		  && => 범위 안에 포함된 경우
 * 			score >= 80 && score < 90  ==>  B
 * 		  || => 범위 밖에 있는 경우
 * 		= 대입연산자 (=)
 * 		  => 복합대입연산자 (+=, -=, *=, /= ...)
 * 3. 삼항 연산자 (연산대상 3개)
 * 	  조건 ? 값1 : 값2 => 조건이 참 => 값1
 *                      조건이 거짓 => 값2
 * 
 */


/*
 * 1. 증감연산자 (++, --)
 * 		+1, -1 하는 연산자
 * 		= 전치연산자
 * 		int a = 10;
 * 			++a;
 * 		
 * 		= 후치연산자
 * 		  int a = 10;
 * 			a++;
 * 		
 */
public class 연산자_단항연산자 {

	public static void main(String[] args) {
		/*
		// 메모리에 데이터 저장
		int a = 10;

		// 저장된 데이터를 출력해라.
		System.out.println("a = " + a);

		// a값을 1 증가
		++a; // 전치연산자 ==> a = 11
		System.out.println("a = " + a);
		
		a++; // 후치연산자 ==> a = 12
		System.out.println("a = " + a);
		*/
		
		/*
		 *  b = ++a ==> a값을 증가한 다음에 b에 대입          ++(우선적용), =(나중에 적용)
		 *  	===
		 *  	1
		 *  ===
		 *   2
		 *  	
		 *  
		 *  b = a++ ==> a값을 b에 대입하고 a값을 1 증가		=(대입하고), ++(나중에 증가)
		 *  =====
		 *    1
		 *      ====
		 *       2
		 *  
		 *  
		 *  
		 */
		
		int a = 10; // 저장
		int b = ++a;
		System.out.println("a = " + a + ", b = " + b);
		
		
		int c = 10;
		int d = c++;
		System.out.println("c = " + c + ", d = " + d);
		
		
		/*
		 * 	int a = 10;
		 * 	int b = ++a + a++ + ++a + a++
		 */
		
		int i = 10;
		i--; // i = 9;
		System.out.println("i = " + i);
		
		--i;
		System.out.println("i = " + i);
		
		
		
		
		
	}

}
