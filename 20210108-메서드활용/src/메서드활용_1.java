
public class 메서드활용_1 {
	static void star(int a) {
		for (int i = 0; i < a; i++) {
			System.out.println("***** *****");
		}
	}

	static void star() {

		System.out.println("***** *****");

	}

	public static void main(String[] args) {
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		for (int i = 0; i < 10; i++) {
			System.out.println("***** *****");
		}
		System.out.println("===== method =====");
		star(10);
		System.out.println("===== method =====");
		star();star();star();star();star();
		star();star();star();star();star();
	}

}
