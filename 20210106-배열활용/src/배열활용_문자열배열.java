// ���ڿ� => String => char[]
/*
 *  String: ��������, Ŭ������ (���ڿ��� ������ �� �ִ� ��� = �޼���)
 *  ���ڿ����� ���� �� ���� ������ �� �� => charAt()
 *  ABCDEFG
 *  0123456
 *  ���ڿ��� ���� Ȯ�� => length()
 *  ���ڿ� �� => Login (id, pwd) => equals()
 *  ���ڿ� ���Ե� �ܾ� => contains()
 *  ============================
 *  �����ϴ� ���ڿ� => startsWith()
 *  ������ ���ڿ� => endsWith()
 *  ============================ ������Ʈ => �ڵ��ϼ� ���( ~ �� �����ϴ� �˻���) => �˻���ɿ��� ���
 *  ���ڿ��� �ڸ��� ��� => sub��tring() ==> A.java (Ȯ����, Ư�� �ܾ ������ �� ���)
 *  ���ڿ� => �빮��, �ҹ��� 
 *          ====  ====
 * toUpperCase(), toLowerCase()
 * 
 */

import java.util.Scanner;

public class �迭Ȱ��_���ڿ��迭 {

	public static void main(String[] args) {

		// 1. ������ ���� ������ ���� (length())
		String data = "Hello Java!!"; // ���鵵 ����
		System.out.println("������ ����: " + data.length());

		// 2. �빮�ڷ� ��ȯ (toUpperCase())
		// char c = 'a' => (c-32) => 'A'
		System.out.println("�빮�� ��ȯ:" + data.toUpperCase()); // ���ĺ��� ����

		// 3. �ҹ��ڷ� ��ȯ (toLowerCase())
		// char c = 'A' => (c+32) => 'a'
		System.out.println("�ҹ��� ��ȯ: " + data.toLowerCase());

		// 4. charAt(index) => ���ڿ��� ��ȣ 0�� ���� ����

		/*
		 * Hello Java!! 012345678910111
		 * 
		 * J ==> charAt(6)
		 */
		System.out.println("���� �� �� �б�: " + data.charAt(8));

		// 5. contains() => ���ڿ��߿� Ư�����ڰ� ���� => true / false
		System.out.println("���Կ���: " + data.contains("Java")); // ����Ŭ�� LIKE�� ����. ==> �����ȣ �˻�
		
		Scanner scan = new Scanner(System.in);
		String[] find_data = {"�ڹٶ��ڹ�",
								"�ڹ�",
								"�ڹٶ� ĭ����",
								"�ڹٶ� ȣ��",
								"�ڹ���",
								"�ڹ� �ٿ�ε�",
								"�ڹٶ� ��",
								"�ڹٶ� �ڹ�",
								"�ڹٶ� Ŀư",
								"�ڹ� ��ũ��Ʈ",
								"�ڹ��� ��� �Ǿ��޿� �ڹ�",
								"�ڹٶ� õ��",
								"�ڹٳ��� �ڹ�",
								"�ڹٽ�ũ��Ʈ ���� �ذ�",	
								"�ڹ� ����"};
		System.out.print("�˻��� �Է�: ");
		String fd = scan.next(); // �˻�� �޴´�.
		for (String s : find_data) { // �ڵ� �ϼ��� (�˻���)
			if (s.endsWith(fd)) {
				System.out.println(s);
			}
		}
	}

}
