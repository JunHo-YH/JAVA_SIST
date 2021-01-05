/*
 * 배열을 복사
 * 한 개씩 복사
 * 라이브러리 이용 => arraycopy()
 * 향상된 for
 */
public class 배열복사_1 {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };

		int[] temp = new int[10];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		for (int i : temp) { // for-Ecah, 향상된 for => 출력할 때 사용 / temp에 저장된 실제 데이터값을 받아온다.
			System.out.print(i + " ");
		}

		System.out.println("\n==============forEach================"); //JDK1.5이상, 값을 변경하지 못한다, 출력담당
		char[] alpha = { 'A', 'B', 'C', 'D', 'E' };
		System.out.println("저장된 데이터의 개수: " + alpha.length);
		System.out.println("첫번째 저자된 데이터: " + alpha[0]); // 배열의 첫번째 요소 출력
		System.out.println("마지막에 저장된 데이터: " + alpha[alpha.length - 1]); // 배열의 마지막 요소 출력

		// 전체 데이터 출력

		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i]);
		}

		System.out.println("======향상된 for(forEach)========");
		int i = 1;
		for (char c : alpha) {
			System.out.print(c);
			System.out.println(i);
			i++;
		}
		System.out.println();
	}

}
