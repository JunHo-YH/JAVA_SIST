package solve;

public class ÀÌ¹ø {

	public static void main(String[] args) {

		int count = 0;
		int sum = 0;
		for (int i = 100; i <= 999; i++) {
			if (!(i % 4 == 0)) {
				count++;
				sum += i;
			}
		}
		System.out.println("°¹¼ö: " + count);
		System.out.println("ÇÕ: " + sum);
	}

}
