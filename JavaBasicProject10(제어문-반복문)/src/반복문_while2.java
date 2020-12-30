// 1 ~ 100까지의 합
// 1 + 2 + 3 + 4 + .... + 100 ?
public class 반복문_while2 {

	public static void main(String[] args) {
		// 변수 => 1부터 100까지 변경되는 변수 => 루프 변수
		int i = 1;
		// 1 ~ 100까지 더한 값을 누적하는 변수
		int sum = 0; // (누적) + =>(0), * => 1
		while (i <= 100) {
			sum += i;
			System.out.println("i= " + i + ", sum = " + sum);
			i++;
		}
		System.out.println("1 ~ 100까지의 총 합은: " + sum + "입니다.");
	}

}
