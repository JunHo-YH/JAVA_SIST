// equals: ���ڿ� �� (�Ϲ� ������ ==)

import java.util.Scanner;

public class �迭Ȱ��_7_���ڿ��� {

	public static void main(String[] args) {
		final String ID = "Admin"; // char[] id ={'A', 'd', 'm', 'i', 'n'}
		final String PWD = "1234";

		Scanner scan = new Scanner(System.in);
		String myId = "";
		String myPwd = "";

		System.out.print("ID�� �Է��ϼ���: ");
		myId = scan.next();

		System.out.print("��й�ȣ�� �Է��ϼ���: ");
		myPwd = scan.next();
		
		
		/*
		 * equalsIgnoreCase = ��ҹ��� ���о���
		 * equals = ��ҹ��� ����
		 */
		if (myId.equals(ID) && myPwd.equals(PWD)) { // ��ҹ��� ����, ==�� �ƴ϶� equals�� ���ؾ� ���� ���Ѵ�. ==�� ���� ������ �ּҰ��� ���Ѵ�.
			System.out.println(myId + "�� �α��εǾ����ϴ�.");

		} else {
			System.out.println("ID�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
	}

}
