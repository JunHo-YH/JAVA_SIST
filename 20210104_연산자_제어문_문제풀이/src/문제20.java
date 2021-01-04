// 20) 1 ~ 100 중에서 2의 배수이면서 3의 배수인 갯수를 구하시오
public class 문제20 {

	public static void main(String[] args) {
		// 갯수를 저장하는 변수
		int count = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0 && i % 3 == 0) {
				count++;
			}
		}
		System.out.println("2의 배수이면서 3의 배수인 갯수의 총 합은: " + count + "개입니다.");
	}

}
