
// ���� ���ϱ�
import java.util.Scanner;

public class �迭Ȱ��_1 {

	public static void main(String[] args) {
		String[] strWeek = {"��", "��", "ȭ", "��", "��", "��", "��"};
		/*
		 * 	1�⵵ 1�� 1��(��) ~ 2020.12.30 => �� ��¥ ��
		 * 	+ 20201.1�� 1�� ~ ���ޱ����� �� ��¥ ��
		 * 	+ �Էµ� ��¥
		 * =======================================
		 * % 7 => ����
		 * Calendar
		 */
		
		// ����ڰ� �⵵-��-���� �Է��ؼ� ó��
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է�: ");
		int year = scan.nextInt();
		
		System.out.print("�� �Է�: ");
		int month = scan.nextInt();
		
		System.out.print("�� �Է�: ");
		int day = scan.nextInt();
		
		// ���� ���ϱ�
		// 1. 2021�⵵ 1�� 1�� ~ �۳� (2020-12-31)
		int total = (year-1) * 365 + (year-1) / 4
								   - (year-1) / 100
								   + (year-1) / 400;
		
		int[] lastDay = {31, 28, 31, 30, 31, 30,
						 31, 31, 30, 31, 30, 31};
				
		// ���� ����
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
		{
			lastDay[1] = 29;
		}
		else
		{
			lastDay[1] = 28;
		}
		
		// ���ޱ����� ��
		for (int i = 0; i < month-1; i++) {
			total += lastDay[i];
		}
		
		// �Է��� ��¥ ÷��
		total += day;
		int week = total % 7;
		
		
		
		// ���
		System.out.printf("%d�� %d�� %d���� %s�����Դϴ�.", year, month, day,strWeek[week]);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
