/*
 * �ֻ��� 2���� ������ ���� 6�� ����� ������ ����ϰ� �� ������ ����� ����Ͻÿ�.
 */
public class ����21 {

	public static void main(String[] args) {
		int count = 0;
		
		for (int i = 1; i <= 6; i++) {
			for(int k = 1; k <= 6; k++) {
				if(i + k == 6) {
					System.out.println("[" + i + "," + k + "]");
					count++;
				}
			}
		}
		System.out.println("���� 6�� ����� ������ �� ����: " + count + "���Դϴ�.");
	}

}
