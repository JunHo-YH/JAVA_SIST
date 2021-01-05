package solve;

public class »ï¹ø {
	public static void main(String[] args) {
		
		int even = 0;
		int odd = 0;
		
		
		for (int i = 1; i <= 30; i++) {
			if (i % 2 == 0)
				even += i;
			
			if (i % 2 == 1)
				odd += i;
		}
		
		System.out.println("Â¦¼ö ÇÕ: " + even);
		System.out.println("È¦¼ö ÇÕ: " + odd);
	}
}
