import java.util.Scanner;

public class ��ɺи��ϱ�_�޷� {
	static int getYear(int year) {
		Scanner scan = new Scanner(System.in); // System.in => Ű���� �Է°��� �о���� ���
		// �⵵ �Է�
		System.out.print("�⵵ �Է�: ");
		return year = scan.nextInt();
	}

	static int getMonth(int month) {
		Scanner scan = new Scanner(System.in); // System.in => Ű���� �Է°��� �о���� ���
		System.out.print("�� �Է�: ");
		return month = scan.nextInt();

	}
	
	static void getWeek(String[] week) {
		String[] strWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };
		for (String week_day : strWeek)
			System.out.print(week_day + "\t");
		System.out.println(); // �����ٿ� ���
	}
	
	static int getTotal_year(int year) {
		int total = (year - 1) * 365 + (year - 1) / 4 
				 - (year - 1) / 100 
				 + (year - 1) / 400;
		return total;
	}
	
	static int getTotal_month(int year, int month) {
		int[] lastDay = { 31, 28, 31, 30, 31, 30,
						  31, 31, 30, 31, 30, 31 };
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // ���� 2�� => 29
			lastDay[1] = 29;
		else
			lastDay[1] = 28;
		
		for (int i = 0; i < month - 1; i++) {
			getTotal_year(year) += lastDay[i];
		}
		return getTotal_year(year);
	}
	

	public static void main(String[] args) {
		// 1. ����� �Է��� �޴´�.
				Scanner scan = new Scanner(System.in); // System.in => Ű���� �Է°��� �о���� ���

				// �⵵ �Է�
				System.out.print("�⵵ �Է�: ");
				int year = scan.nextInt();
				System.out.print("�� �Է�: ");
				int month = scan.nextInt();
				
				// ����ڰ� ��û�� ��/���� ���� �޷�
				// ���
				System.out.println(year + "�⵵ " + month + "��");
				System.out.println("\n");
				/*
				 * System.out.print("��\t");
				 * System.out.print("��\t"); 
				 * System.out.print("ȭ\t");
				 * System.out.print("��\t"); 
				 * System.out.print("��\t"); 
				 * System.out.print("��\t");
				 * System.out.print("��\t");
				 */

				String[] strWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };
				for (String week : strWeek)
					System.out.print(week + "\t");
				System.out.println(); // �����ٿ� ���
				/*
				 * 2021�� 1�� => 2021�� 1�� 1�� ~ 2020�� 12�� 31�� ============================= +1 (�ѳ���
				 * % 7)
				 */

				// 1. ���⵵������ ��
				int total = (year - 1) * 365 + (year - 1) / 4 
											 - (year - 1) / 100 
											 + (year - 1) / 400;
				// 2. ���ޱ����� ��
				int[] lastDay = { 31, 28, 31, 30, 31, 30,
								  31, 31, 30, 31, 30, 31 };
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // ���� 2�� => 29
					lastDay[1] = 29;
				else
					lastDay[1] = 28;

				for (int i = 0; i < month - 1; i++) {
					total += lastDay[i];
				}

				// 3. +1
				total++; // �� ���� 1���� Ȯ��

				int week = total % 7; // ���� ���ϱ�
				for (int i = 1; i <= lastDay[month - 1]; i++) {
					if (i == 1) {
						for (int k = 0; k < week; k++) {
							System.out.print("\t");
						}
					}
					System.out.printf("%2d\t", i);
					week++;
					if (week > 6) {
						week = 0;
						System.out.println();
					}

				}
	}

}
