package solve;

public class 일번 {

	public static void main(String[] args) {

		int count = 0;
		int sum = 0;
		
		for (int i = 100; i <= 999; i++) {
			if (i % 7 == 0) {
				count++;
				sum += i;
			}
				
		}
		System.out.println("7의 배수의 개수는 총: " + count + "개입니다.");
		System.out.println("7의 배수의 합은: " + sum + "입니다.");
	}

}
