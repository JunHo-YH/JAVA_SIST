package solve;

public class ���� {

	public static void main(String[] args) {
		int tens; // ���� �ڸ�
		int units; // ���� �ڸ�
		
		for (int i = 10; i <= 99; i++) {
			tens = i / 10;
			units = i % 10;
			
			if(tens == units)
				System.out.print(i + " ");
		}
	}

}
