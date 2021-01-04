
// 정수를 입력받아서 수가 양수, 음수, 제로인지 출력하세요: 다중 조건문
import java.util.Scanner;

public class 문제19 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력: ");
		// 입력된 값을 받아서 메모리 저장
		int input = scan.nextInt();

		if (input > 0)
			System.out.println(input + "은(는) 양수입니다.");
		else if (input < 0)
			System.out.println(input + "은(는) 음수입니다.");
		else
			System.out.println(input + "은(는) 제로입니다.");
	}

}
