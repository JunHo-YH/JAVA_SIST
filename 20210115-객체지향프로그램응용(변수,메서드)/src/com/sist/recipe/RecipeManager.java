package com.sist.recipe;

import java.util.Scanner;

/*
 * class���� ����Ǵ� ��� ���� => private
 * => method�� �̿��ؼ� �����ش�.
 */
public class RecipeManager {
	private static String[] menu1 = { "�ع���", "���ι���", "�", "����Ʈ", "����", "	��", "��", "ǻ��", "��ġ", "����", "���", "���", "�ҽ�", "��",
			"���", "������", "����", "��", "����", "����", "��" };
	private static String[] menu2 = { "�ϻ�", "�ʽ��ǵ�", "�մ�����", "������", "���̾�Ʈ���ö�", "�����", "����", "�߽�", "Ǫ�彺Ÿ�ϸ�", "����", "����",
			"������" };
	private static String[] menu3 = { "�Ұ��", "�������", "�߰��", "����", "ä�ҷ�", "�ع���", "�ް�", "����ǰ", "������ǰ��", "��", "�а���",
			"�Ǿ��", "������", "���Ϸ�", "��", "�߰���", "���" };
	private static String[] menu4 = { "����", "���̱�", "��ħ", "����", "��ħ", "���", "��", "����", "Ƣ��", "���", "����", "��ġ��", "ȸ" };

	public int main_menu() {
		System.out.println("================ Main Menu ================");
		System.out.println("1. ������, 2. ��Ȳ��,  3. ��Ằ,  4. �����");
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �޴��� �����ϼ���: ");
		int no = scan.nextInt();
		return no;
	}

	public String su_menu(int no) {
		String data ="";
		String[] menu = null;
		switch (no) {
		case 1:
			menu = menu1;
			break;
		case 2:
			menu = menu2;
			break;
		case 3:
			menu = menu3;
			break;
		case 4:
			menu = menu4;
			break;

		}
		System.out.println("==================== Sub Menu ====================");
		int i = 1;
		for (String s : menu) {
			System.out.println(i + ". " + s);
			i++;
		}	
		Scanner scan = new Scanner(System.in);
		System.out.print("�����Ǹ� �����ϼ���: ");
		int r = scan.nextInt();
		data = menu[r -1];
		
		return data;
	}

	public static void main(String[] args) {

		RecipeManager rm = new RecipeManager();
		int no = rm.main_menu();
		String data = rm.su_menu(no);
		System.out.println("������ �����Ǵ� " + data);
	}

}
