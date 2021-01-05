package solve;

public class 구번 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		int total = 0;
		double avg;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
			total += arr[i];
		}

		System.out.print("배열에 든 숫자: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("평균: " + (double)total / arr.length);

	}

}
