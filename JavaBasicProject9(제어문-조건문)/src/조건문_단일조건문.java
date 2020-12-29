import java.util.Scanner;

public class 조건문_단일조건문 {

	public static void main(String[] args) {
		char alpha;
		Scanner scan = new Scanner(System.in);
		// System.in => 키보드 입력값을 받는 경우
		System.out.print("알파벳을 입력해주세요 >> ");
		String s = scan.next();
		alpha = s.charAt(0); // 맨처음 글자를 char로 가지고 오는 기능 (메서드)
		// 출력
		System.out.println(alpha);

		if (alpha >= 'A' && alpha <= 'Z')
			System.out.println(alpha + "는(은) 대문자입니다.");
		if ('a' <= alpha && alpha <= 'z')
			System.out.println(alpha + "는(은) 소문자입니다.");
		if (!((alpha >= 'A' && alpha <= 'Z') || ('a' <= alpha && alpha <= 'z')))
//		if(^A-Za-z)
			System.out.println(alpha + "는(은) 알파벳이 아닙니다.");
	}

}
