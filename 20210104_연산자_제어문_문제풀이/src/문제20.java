// 20) 1 ~ 100 �߿��� 2�� ����̸鼭 3�� ����� ������ ���Ͻÿ�
public class ����20 {

	public static void main(String[] args) {
		// ������ �����ϴ� ����
		int count = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0 && i % 3 == 0) {
				count++;
			}
		}
		System.out.println("2�� ����̸鼭 3�� ����� ������ �� ����: " + count + "���Դϴ�.");
	}

}
