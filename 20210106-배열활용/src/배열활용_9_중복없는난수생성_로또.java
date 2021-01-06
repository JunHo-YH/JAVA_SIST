/*
 * 로또 => 1 ~ 45 中 6개 ==> 배열
 */
public class 배열활용_9_중복없는난수생성_로또 {

	public static void main(String[] args) {
		// 6개의 번호를 저장하는 메모리 공간: 배열

		int[] lotto = new int[6];

		// 초기화
		for (int i = 0; i < lotto.length; i++) {
			
			lotto[i] = (int) (Math.random() * 45) + 1;
			int k = 0;
			for (; k < i; k++) {
				
			}
		}
		for (int i : lotto) {
			System.out.print(i + " ");
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
			}
		}
	}

}
