package solve;

public class 육번 {

	public static void main(String[] args) {
		int tens; // 십의 자리
		int units; // 일의 자리
		
		for (int i = 10; i <= 99; i++) {
			tens = i / 10;
			units = i % 10;
			
			if(tens == units)
				System.out.print(i + " ");
		}
	}

}
