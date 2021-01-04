// 임의의 문자열을 저장후에 a,A가 몇 개인지 여부를 확인

import java.util.Scanner;

public class 문제22 {

	public static void main(String[] args) {

		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.print("영어를 입력해보세요: ");
			String s = scan.next();
			int count = 0;

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == 'a' || c == 'A') {
					count++;
				}
			}
			if (count == 0) {
				System.out.println("a나 A가 포함되는 문자가 없습니다. 다시 입력하세요");
				continue;
			} else {
				System.out.println("a나 A의 총 개수는: " + count + "개입니다.");
			}
		}
	}

}
