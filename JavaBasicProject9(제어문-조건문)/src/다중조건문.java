/*
 * 	�������ǹ�
 * 		=> �������� �����߿� �� ���� ������ ������ �� �ְ� ����� ���
 * 		
 */

// 3���� ������ �޾Ƽ� ���, ����, �������ϱ�
import java.util.Scanner; // �ڹٿ��� �����ϴ� Ŭ������ ������ �� ��쿡 ��� ( import )

public class �������ǹ� {

	public static void main(String[] args) {
		// �����ϴ� �޸� ������ ����
		int kor, eng, math, total;
		double avg;
		char score;
		
		// 3���� ������ �������Ƽ� ���� => ������ �ʱ�ȭ
		Scanner scan = new Scanner(System.in); // Ű����� �Էµ� �����͸� �о���� ����
		System.out.print("�������� �������� �������� �Է�(90 80 70):");
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		// ���� (������)
		total = kor + eng + math;
		avg = total / 3.0;
		
		// ����
		// avg = 72.33
		score = 'A';
		if(avg >= 90) 
			score = 'A';
		else if(avg >= 80) 
			score = 'B';
		else if(avg >= 70)
			score = 'C';
		else if(avg >= 60)
			score = 'D';
		else
			score = 'F';
		
		
		// ���
		System.out.println("���� ����: " + kor);
		System.out.println("���� ����: " + eng);
		System.out.println("���� ����: " + math);
		System.out.println("����: " + total);
		System.out.printf("���: %.2f\n", avg);
		System.out.println("����: " + score);
		
		
	}

}
