/*
 * 1. �Է�
 * 2. ó��
 * 3. ���
 * 
 * 
 * ==== �޼���
 * 1. �Ű�����: ����� �Է°�
 * 2. �����: 
 */


import java.util.Scanner;

public class �޷¸����_�޼��� {
	static int input(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + " �Է�:");
		return scan.nextInt();
	}
	// ���� ���
	static void weekPrint() {
		String[] strWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };
		for (String week : strWeek)
			System.out.print(week + "\t");
		System.out.println(); // �����ٿ� ���
	}
	
	static boolean isYear(int year) {
		boolean bCheck = false;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			bCheck = true;
		}
		return bCheck;
	}
	
	
	// ���� ���ϱ� (ó��)
	static int weekData(int year, int month) {
		// 1. ���⵵������ ��
		int total = (year - 1) * 365 + (year - 1) / 4 
									 - (year - 1) / 100 
									 + (year - 1) / 400;
		// 2. ���ޱ����� ��
		int[] lastDay = { 31, 28, 31, 30, 31, 30,
						  31, 31, 30, 31, 30, 31 };
		/*
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // ���� 2�� => 29
				lastDay[1] = 29;
				else
					lastDay[1] = 28;
				
				for (int i = 0; i < month - 1; i++) {
					total += lastDay[i];
				}
		*/
		if(isYear(year)) {
			lastDay[1] = 29;
		} else {
			lastDay[1] = 28;
		}
				
		// 3. +1
		total++; // �� ���� 1���� Ȯ��

		int week = total % 7; // ���� ���ϱ�
				
		return week;
	}
	static int getLastDay(int month) {
		int[] lastDay = { 31, 28, 31, 30, 31, 30,
				  31, 31, 30, 31, 30, 31 };
		return lastDay[month - 1];
	}
	
	// ��� �޼���
	static void dataPrint(int month, int week) {
		
		for (int i = 1; i <= getLastDay(month); i++) {
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
	
	
	public static void main(String[] args) {
		int year = input("�⵵");
		int month = input("��");
		
		System.out.println(year + "�⵵ " + month + "��");
		
		// ���� ���
		weekPrint();
		int week = weekData(year, month);
		
		// ���
		dataPrint(month, week);
	}

}
