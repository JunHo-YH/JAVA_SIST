/*
 * 		do~while: 조건 검색을 나중에 하기 때문에 반드시 한 번 이상 수행
 * 		형식)
 * 			초기값 int i = 1;
 * 			do {
 * 				반복문장 ====> 2
 * 				증가식  ====> 3	
 * 			}
 * 			while(조건식);====> 4 ====> 2 ===> 3 ===> 4
 * 									   =================> 4(false일 경우에 종료)
 */
public class 반복문_doWhile {

	public static void main(String[] args) {
		// 1.초기값
		int i = 1;
		do {
			// 2. 반복으로 수행되는 문장
			System.out.println("i = " + i);
			i++;
		} while (i <= 10);

	}

}
