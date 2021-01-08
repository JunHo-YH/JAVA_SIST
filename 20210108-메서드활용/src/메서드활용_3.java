
public class 메서드활용_3 {
	// void => 결괏값은 존재하지 않는다 (메서드에서 출력)
	static void aMethod() {
		System.out.println("aMethod 호출 시작");
		System.out.println("aMethod 기능 처리");
		System.out.println("aMethod 종료");
	}

	static void bMethod() {
		System.out.println("bMethod 호출 시작");
		System.out.println("bMethod 기능 처리");
		System.out.println("bMethod 종료");
	}

	static void cMethod() {
		System.out.println("cMethod 호출 시작");
		System.out.println("cMethod 기능 처리");
		System.out.println("cMethod 종료");
	}

	public static void main(String[] args) { // main => 시작과 종료를 나타내는 메서드
		System.out.println("메인 시작");
		aMethod();
		aMethod();
		bMethod();
		cMethod();
		System.out.println("Main 종료");

	}

}
