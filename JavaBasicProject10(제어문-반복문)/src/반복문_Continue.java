/*
 * 		continue: 특정부분을 제외하고 다시 실행한다
 * 		======== 반복문에서만 사용
 * 	
 * 		for(초기값; 조건식; 증감식) {
 * 			반복수행 문장
 * 			if(조건문)
 * 				break; ===> if에 있는 조건문이 true => for문을 중단
 * 		}
 * 
 * 		초기값
 * 		while(조건식) {
 * 			반복실행문장
 * 			if(조건문)
 * 				continue; ==> 조건문이 true일 때 while문의 조건식으로 이동
 * 
 * 			증감식
 * 		}

 * 		for(초기값; 조건식; 증감식) {
 * 			반복실행문장
 * 			if(조건문) {
 * 				continue; ==> true ==> 증감식으로 이동
 * 			}
 * 		}
 * 
 */
public class 반복문_Continue {

	public static void main(String[] args) {
//		int i = 0;
//		while (i < 10) {
//			i++;
//			if (i == 5)
//				continue;
//			System.out.println("i = " + i);
//			
//		}
		
		for(int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println("i = " + i);
		}
	}

}










