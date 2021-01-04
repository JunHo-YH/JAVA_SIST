import java.util.Scanner;

public class Scan {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				count++;
			}
		}

		System.out.println("2와 3의 배수의 총 갯수는: " + count + "개입니다.");
	}
}
