/*
 * �迭�� ����
 * �� ���� ����
 * ���̺귯�� �̿� => arraycopy()
 * ���� for
 */
public class �迭����_1 {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };

		int[] temp = new int[10];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		for (int i : temp) { // for-Ecah, ���� for => ����� �� ��� / temp�� ����� ���� �����Ͱ��� �޾ƿ´�.
			System.out.print(i + " ");
		}

		System.out.println("\n==============forEach================"); //JDK1.5�̻�, ���� �������� ���Ѵ�, ��´��
		char[] alpha = { 'A', 'B', 'C', 'D', 'E' };
		System.out.println("����� �������� ����: " + alpha.length);
		System.out.println("ù��° ���ڵ� ������: " + alpha[0]); // �迭�� ù��° ��� ���
		System.out.println("�������� ����� ������: " + alpha[alpha.length - 1]); // �迭�� ������ ��� ���

		// ��ü ������ ���

		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i]);
		}

		System.out.println("======���� for(forEach)========");
		int i = 1;
		for (char c : alpha) {
			System.out.print(c);
			System.out.println(i);
			i++;
		}
		System.out.println();
	}

}
