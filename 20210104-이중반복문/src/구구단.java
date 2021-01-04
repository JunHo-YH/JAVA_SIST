
public class 구구단 {

	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {      // 줄 수
			System.out.println(i + "단 ");
			for (int k = 1; k <= 9; k++) {
				System.out.print(i + " x " + k + "= " + i * k + "\t");
			}
			System.out.println();
		}
	}

}
