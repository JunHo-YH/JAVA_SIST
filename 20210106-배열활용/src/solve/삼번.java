package solve;

public class 삼번 {

	public static void main(String[] args) {
		// 1) 10개의 문자를 가지는 배열 c를 생성하는 코드를 한 줄로 쓰라.
		char[] c = new char[10];

		// 2) 0에서 5까지 정수 값으로 초기화된 정수 배열 n을 선언하라.
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		// 3) '일', '월', '화', '수', '목', '금', '토'로 초기화된 배열 day를 선언하라.
		char[] day = {'일', '월', '화', '수', '목', '금', '토'};
		
		// 4) 4개의 논리 값을 가진 배열 bool을 선언하고 true, false, false, true로 선언하라.
		boolean[] b = {true, false, false, true};
	}

}
