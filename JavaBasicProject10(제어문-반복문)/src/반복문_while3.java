// 1 ~ 100까지의 합, 짝수합, 홀수합

/*
 * 		while 형식
 * 		=========
 * 		초기값 ==> 시작			==> int i = 1
 * 		while(조건식)	==> 끝  ==> i <= 10
 * 		{
 * 			반복문장 => 시작, 끝 지정된 갯수만큼 수행
 * 			증가식 i++;
 * 			
 * 		}
 * 
 * 		초기값 ==> 시작 	==> int i = 10;
 * 		while(i >= 1)
 * 		{
 * 			반복문장
 * 			증감식 i--;	2개씩 ==> i += 2;, 3개씩 ==> i += 3;
 * 		}
 * 
 * 
 * 		=======> while은 횟수가 없는 경우에 주로 사용한다.
 * 				while(true) => 무한루프
 * 				{
 * 					종료 => break;
 * 				}
 * 		
 */
public class 반복문_while3 {

	public static void main(String[] args) {
		int i = 1;
		
		int sum = 0;
		int even = 0;
		int odd = 0;
		while(i <= 100) {
			sum += i; // 100까지의 합
			if(i % 2 == 0) { // 홀수만 구하고 싶다면 if(i % 2 == 1)
				even += i;
			}
			else {
				odd += i;
			}
			i++;
		}
		
		
		System.out.println("총 합은 = " + sum);
		System.out.println("짝수 합은 = " + even);
		System.out.println("홀수 합은 = " + odd);

	
	
	
	}

}
