import java.util.Scanner;

// 32767 (����� ó��
/*
 * 	1. ����
 * 		= ��������
 * 		= ��������
 * 1-1 �󵵼� Ȯ��
 *  		12311122222 => ���ڿ�
 * 	2. ���� => �޷�
 * 	3. ���� �߱� ���� (�ߺ��� ���� ���� �߻�)
 * 				   ===============
 * 					�ζ� => 6��
 * 	4. ���ڿ��迭
 */

// ���� 1���� �Է¹޾Ƽ�  2�������� �����ؼ� ��� => 16bit (0,1 16��)
/*
 * 	1. ����(�������)
 * 		= 0�� 1�� 16�� ������ �� �ִ� ���� => �迭
 * 		= ����� �Է°� ����
 * 		= �迭 => 16 => index��ȣ�� ������ ����
 */
public class �迭Ȱ��_2 {

	public static void main(String[] args) {
		int[] binary = new int[16]; // 0, 1
		int input; // ����ڰ� �Է��� ���� ����
		int index = 15; // �迭�� ���� ä�� ��� (��(length -1), ��(0) �� �����ϱ�)
		// ����ڷκ��� �������� �޴´�
		Scanner scan = new Scanner(System.in);
		System.out.print("0 ~ 32767 ������ ������ �Է�(16bit)	: ");
		input = scan.nextInt(); // ����� �Է��� �޾Ҵ� => �Էµ� ������ 2�������� ��� ��û

		// �Էµ� ������ ���� �ݺ������� �ٸ��� => while �ݺ��� ���
		/*
		 * 1. ������ ������ ������ ���� 2. ������ 2�� ������.
		 */
		System.out.println("=====���̺귯��=====");
		System.out.println(Integer.toBinaryString(input));
		
		
		while (true) {
			// ������ ����
			binary[index] = input % 2; // 0 or 1 ����
			input = input / 2;
			if (input == 0)
				break;
			index--;
		}

		// ���
		for (int i = 0; i < binary.length; i++) {
			if (i % 4 == 0 && i != 0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}
	}

}
