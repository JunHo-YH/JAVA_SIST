// for-each
public class �迭��� {

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		//�ʱ�ȭ => index��ȣ �̿�
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100)  + 1; // 1 ~ 100 ������ ���� ����
		}
		//��� => for-each����
		for (int i : arr) {
			System.out.println(i + " ");
		}
	}

}
