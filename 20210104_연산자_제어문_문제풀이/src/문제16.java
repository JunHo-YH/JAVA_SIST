import java.util.Scanner;

public class 문제16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		System.out.println("=====메뉴=====");
		while (true) {

			System.out.print("김치찌개 - 5000원? ");
			a = scan.nextInt();
			System.out.print("제육볶음 - 6000원? ");
			b = scan.nextInt();
			System.out.print("된장찌개 - 4000원? ");
			c = scan.nextInt();

			if (a + b + c == 5) {
				int res = (a * 5000) + (b * 6000) + (c * 4000);
				int d = res / 5;
				System.out.println("1인당 계산금액: " + d + "원입니다.");
				break;
			} else {
				System.out.println("잘못된 주문입니다.");
				continue;
			}
		}
	}

}
