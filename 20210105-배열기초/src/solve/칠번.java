package solve;

import java.util.Scanner;

public class 칠번 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int score = scan.nextInt();
		
		if (score >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");
	}

}
