// 1 ~ 100 출력 총합, 짝수의 합, 홀수의 합 => do~while
// 프로그램은 정답이 없다
public class 반복문_doWhile2 {

	public static void main(String[] args) {
		// 1. 초기값 = 1
		int i = 1;
		
		// 1 ~ 100 합을 누적할 수 있는 변수, 짝수합 변수, 홀수합 변수
		int sum = 0, even = 0, odd = 0;
		do {
			// 총합
			sum += i;
			
			// 짝수 합, 홀수 합
			if(i % 2 == 0) {
				even += i;
			}
			else {
				odd += i;
			}
			i++;
		} while(i <= 100);
		// 가공된 데이터를 출력
		System.out.println("1 ~ 100까지 총합: " + sum);
		System.out.println("1 ~ 100까지 짝수 합: " + even);
		System.out.println("1 ~ 100까지 홀수 합: " + odd);
	}

}
