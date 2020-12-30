/*
 * page 156p
 *  for은 주로 반복횟수를 알고 있는 경우에 적합
 *  
 *  1. 초기화
 *  	for(int i = 0;
 *  		==========> 프로그램에 맞게 초기화를 한다. (기본값 0, 1)
 *  		==========> 자바는 보통 0
 *  2. 조건식
 *  	for(int i = 0; i <= 10;
 *  				  ==========
 *  				  반복 횟수 설정
 *  3. 증감식
 *  	for(int i = 0; i < 10; i++)
 *  						  =====
 *  						i--, i+=2, i*=3 ...
 * 
 */
public class 반복문_for2 {

	public static void main(String[] args) {
		
		// A ~ Z
		for (char alpha = 'A'; alpha <= 'Z'; alpha++) {
			System.out.print(alpha);
		}
		System.out.println();
	
		// z ~ a까지 출력
		
		for (char alpha_ = 'z'; alpha_ >= 'a'; alpha_--) {
			System.out.print(alpha_);
		}
		
	}

}
