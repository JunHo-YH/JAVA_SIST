/*
 * �ζ� => 1 ~ 45 �� 6�� ==> �迭
 */
public class �迭Ȱ��_9_�ߺ����³�������_�ζ� {

	public static void main(String[] args) {
		// 6���� ��ȣ�� �����ϴ� �޸� ����: �迭

		int[] lotto = new int[6];

		// �ʱ�ȭ
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
