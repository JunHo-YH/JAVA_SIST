import java.util.Scanner;

public class �迭����_1 {

	public static void main(String[] args) {
		// 3���� �л� => ����, ����, ���� ������ �Է� �޾Ƽ� ����, ���, ���� ���ϱ�
		/*
		 * �迭 => ���õ� �����͸� ��Ƽ� ����
		 */
		// ���� => 3��
		int[] kor = new int[3];

		// ���� => 3��
		int[] eng = new int[3];

		// ���� 3��
		int[] math = new int[3];

		// ����
		int[] total = new int[3];

		// ���
		double[] avg = new double[3];

		// ����
		char[] score = new char[3];
		
		// ����� ������ ���� => 3�� ��� ó��
		int[] rank = new int[3];
		

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.print((i + 1) + "��° ���� ������ �Է�: ");
			kor[i] = scan.nextInt();

			System.out.print((i + 1) + "��° ���� ������ �Է�: ");
			eng[i] = scan.nextInt();

			System.out.print((i + 1) + "��° ���� ������ �Է�: ");
			math[i] = scan.nextInt();
			System.out.println();
		}
		// ����
		for (int i = 0; i < 3; i++)
			total[i] = kor[i] + eng[i] + math[i];

		// ���
		for (int i = 0; i < 3; i++)
			avg[i] = total[i] / 3.0;

		// ���� ���ϱ�
		for (int i = 0; i < 3; i++) {
			switch ((int) (avg[i] / 10)) {
			case 10:
			case 9:
				score[i] = 'A';
				break;
			case 8:
				score[i] = 'B';
				break;
			case 7:
				score[i] = 'C';
				break;
			case 6:
				score[i] = 'D';
				break;
			default:
				score[i] = 'F';
			} // ���� ���� ���ڿ�
		}
		
		// ��� ���ϱ� => �� (���� for)
		for (int i = 0; i < 3; i++) {
			rank[i] = 1;
			for (int k = 0; k < 3; k++) {
				if (total[i] < total[k])
					rank[i]++;
			}
		}

		// ���
		for (int i = 0; i < 3; i++) {
			System.out.printf("����� %d��, ����� %d��, ������ %d��, ������ %d��, �����%.2f���Դϴ�. %d��° �л��� ������ %c�Դϴ�. ���: %d��\n", kor[i], eng[i], math[i], total[i],
					avg[i], i+1, score[i], rank[i]);
		}

	}

}
