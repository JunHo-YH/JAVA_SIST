// 3���� �л� => �̸�, ����, ���� => ���, ����, �п���(���� �п�)
public class Student_1_�迭 {
	public static void main(String[] args) {
		// �迭 => �ε��� => ���� ��ȣ ==> �� �� ���� ����
		String[] name = { "ȫ�浿", "��û��", "�ڹ���" };
		int[] kor = { 89, 67, 90 };
		int[] eng = { 80, 90, 70 };
		int[] math = { 78, 79, 90 };
		String[] school = { "SIST", "SIST", "SIST" };
		int[] total = new int[3];
		// �ʱ�ȭ
		total[0] = kor[0] + eng[0] + math[0];
		total[1] = kor[1] + eng[1] + math[1];
		total[2] = kor[2] + eng[2] + math[2];
		double[] avg = new double[3];
		avg[0] = total[0] / 3.0;
		avg[1] = total[1] / 3.0;
		avg[2] = total[2] / 3.0;

		// Ŭ����

		// ���
		for (int i = 0; i < name.length; i++) {
			System.out.println("�̸�: " + name[i]);
			System.out.println("����: " + kor[i]);
			System.out.println("����: " + eng[i]);
			System.out.println("����: " + math[i]);
			System.out.println("����: " + total[i]);
			System.out.println("���: " + avg[i]);
			System.out.println("�п���: " + school[i]);
			System.out.println("=========================");
		}
	}

}
