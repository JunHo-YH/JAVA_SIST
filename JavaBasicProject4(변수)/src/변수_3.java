//  ������ ����
public class ����_3 {

	public static void main(String[] args) {
		// �� ���� ���� x = 10, y = 20;
		int x = 10, y = 20;
		x = y; // y�� ������ �ִ� �������� x�� �����϶� ==> x = 20;
		y = x; // x�� ������ �ִ� �������� y�� �������� ==> y = 20;

		// ��������, ��������, �������� => ������ ������ �Ŀ� ��� ����, ����, ����, ����, ��� ���
		int kor = 100;
		int eng = 95;
		int math = 90;
		int total = kor + eng + math;
		double avg = total / 3f;
		System.out.println("��������: " + kor);
		System.out.println("��������: " + eng);
		System.out.println("��������: " + math);
		System.out.println("����: " + total);

		System.out.println("���: " + avg);

		System.out.printf("%.5f\n", 10 / 3.0);
		/*
		 * ������ �ִ� ��� ����ȣ %d ==> ���� %c ==> ���� %s ==> ���ڿ� %f ==> �Ǽ�
		 * 
		 * Ư�� ��ȣ \n => new Line : ���� �ٿ� ��� \t => tab : �������� ��� ��
		 * 
		 * System.out.println()
		 * 
		 */

		System.out.printf("%d\n", 100);
		System.out.printf("%s\n", "Hello");
		System.out.printf("%c\n", 'A');

		System.out.println("100  80  70");
		System.out.printf("%-5d %-5d %-5d", 100, 80, 70);
	}

}
