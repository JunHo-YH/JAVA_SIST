/*
 * 	이중 반복문 (중첩 for)
 * 	형식)
 * 		가로: 이차 for
 * 		세로: 일차 for
 *            1     2      4
 * 		for (초기값; 조건식; 증감식) { ==> 줄 수 ===> 추천
 * 
 * 
 *              3
 *         ============================================
 *                1      2     4
 * 			for (초기값; 조건식; 증가식) { ==> 실제 반복 내용 수행
 *                              
 *                3
 * 				반복수행 문장
 * 			}
 * 		   ============================================
 * 			다음 줄에 출력
 * 		}
 * 
 * 
 * 
 *   
 */
public class 이중반복문_for {

	public static void main(String[] args) {
//		for (int i = 2; i <= 9; i++) {
//			for (int k = 1; k <= 9; k++) {
//				System.out.println(i + " x " + k + "= " + i * k);
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i <= 5; i++) {
			for (int k = 1; k <= 5; k++) {
				System.out.println("i= " + i + ",k=" + k);
			}
			System.out.println();
		}
		
		
	}

}
