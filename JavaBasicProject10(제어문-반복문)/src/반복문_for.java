/*
 * 	for
 * 	1. 사용처 => 반복 횟수가 지정된 경우에 주로 사용
 * 	2. while, do~while(1차) ==> for(2차)
 * 	3. for의 형식
 * 		1-1. 일반 for	    false => 종료
 * 				 ①  →   ②  ← ④								← → ↑ ↓ ↗ ↘
 * 			for(초기값; 조건식; 증감식) {
 * 						↓true
 * 					③       ↗
 * 				반복 수행문장
 * 			}
 * 			실행 과정
 * 			초기값 => 조건식( 조건검색) 
 * 						= true	=> 반복 수행문장으로 이동 => 초기값을 변경(증감식)		
 * 						= false => for문을 종료			
 * 
 * 
 * 		***1-2. 향상된 for (JDK 1.5이상) => web (forEach구문)
 * 			==========
 * 			1. 배열, 2. 컬렉션
 */
public class 반복문_for {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			if(i % 3 == 0 ) {
				System.out.print("☆");
			}
			else {
				System.out.print("★");
			}
		}
		
		
		
		
//		for(int i = 1; i <= 10; i++) {
//			if(i % 2 == 1) {
//				System.out.print("☆");
//			}
//			else {
//				System.out.print("★");
//			}
//		}
	}

}
