import java.util.Scanner;

// 정수 1개를 입력을 받아서 => 3, 5, 7의 배수여부를 확인
public class 단일조건문_1 {

	public static void main(String[] args) {
		// 입력받은 정수를 저장할 메모리 공간 : 변수
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 한 개를 입력: ");
		// 입력된 상태 ==> 입력하고 Enter
		num = scan.nextInt();
		
		// 조건 = 3의 배수
		// 조건에 맞는 모든 문장을 수행 => 단일조건문 여러 개를 사용한다. => 중복적으로 수행이 가능하다.
		if(num % 3 == 0)
		{
			System.out.println(num + "은(는) 3의 배수입니다.");
		}
		if(num % 5 == 0)
		{
			System.out.println(num + "은(는) 5의 배수입니다.");
		}
		if(num % 7 == 0)
		{
			System.out.println(num + "은(는) 7의 배수입니다.");
		}
		
		
	}

}
