package solve;

public class �ȹ� {

	public static void main(String[] args) {
		int[] num = { 94, 85, 95, 88, 90 };
		
		int max = num[0];
		int min = num[0];
		
		for (int i = 1; i < num.length; i++) {
			if (num[i] > max) max = num[i];
			if (num[i] < min) min = num[i];
		}
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
	}

}
