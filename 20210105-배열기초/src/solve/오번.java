package solve;

public class ���� {

	public static void main(String[] args) {
		int sum7 = 0;
		int sum9 = 0;
		
		for (int i = 1; i <= 1000; i++) {
			if (i % 7 == 0) {
				sum7 += i;
			}
			
			if (i % 9 == 0) {
				sum9 += i;
			}
		}
		System.out.println("7�� ���: " + sum7);
		System.out.println("9�� ���: " + sum9);
		System.out.println("7�� ��� + 9�� ���: " + (sum7 + sum9));
	}

}
