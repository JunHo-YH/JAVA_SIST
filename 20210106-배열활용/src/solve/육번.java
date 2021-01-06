package solve;

public class À°¹ø {

	public static void main(String[] args) {

		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
		}

		int sum = 0;
		double avg = 0;
		for (int k : arr) {
			sum += k;

			avg = (double) sum / arr.length;
			System.out.print(k + " ");
		}
		System.out.println("\nÆò±Õ: " + avg);
	}

}
