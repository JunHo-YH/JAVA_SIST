
public class �ݺ���_for3 {

	public static void main(String[] args) {
		// 1 ~ 9
		for (int i = 1; i <= 9; i++) {
			System.out.print(i);
		}
		System.out.println();
		// 9 ~ 1
		for (int i = 9; i >= 1; i--) {
			System.out.print(i);
		}

		int i = 1;
		for (;;) { // while(true) ���ѷ���
			if (i > 100)
				break;
			System.out.println("i = " + i);
			i++;
		}
	}

}
