// ������ ����ϴ� �޼��� �����

import java.util.Scanner;

public class �޼���Ȱ��_2 {
	// �ݺ� ����
	static int input(String subject) {
		Scanner scan = new Scanner(System.in);
		System.out.print(subject + "���� �Է�: ");
		return scan.nextInt();

	}
	// ������ ���ϴ� �޼��� �����(������ ���ؼ�)
	static char getScore(int avg) {
		char score ='A';
		switch(avg) {
		case 10: case 9:
			score = 'A';
			break;
		case 8:
			score = 'B';
			break;
		case 7:
			score = 'C';
			break;
		case 6:
			score = 'D';
			break;
		default:
			score = 'F';
			break;
		
		}
		return score;
	}

	public static void main(String[] args) {
		int kor, eng, math;
		char score = 'A';
		// ����ڰ� �Է�
		/*
		 * Scanner scan = new Scanner(System.in); System.out.print("���� ���� �Է�: "); kor =
		 * scan.nextInt(); System.out.print("���� ���� �Է�: "); eng = scan.nextInt();
		 * System.out.print("���� ���� �Է�: "); math = scan.nextInt();
		 */
		kor = input("����");
		eng = input("����");
		math = input("����");
		
		// ����
		int avg = (kor + eng + math) / 30;
		score = getScore(avg); // => �޼��� ȣ�� => �޼��� ó������ ���� => ������� �Ѱ��ְ� ���� �������� �Ѿ��.
		/*
			switch(avg) {
			case 10: case 9:
				score = 'A';
				break;
			case 8:
				score = 'B';
				break;
			case 7:
				score = 'C';
				break;
			case 6:
				score = 'D';
				break;
			default:
				score = 'F';
				break;
			
			}
		*/
		

		System.out.println("����:" + kor);
		System.out.println("����:" + eng);
		System.out.println("����:" + math);
		System.out.println("����: " + (kor + eng + math));
		System.out.printf("���: %.2f\n", (kor + eng + math) / 3f);
		System.out.println("��������: " + score);

	}

}
