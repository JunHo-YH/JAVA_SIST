import java.util.Scanner;

public class ���ǹ�_�������ǹ� {

	public static void main(String[] args) {
		char alpha;
		Scanner scan = new Scanner(System.in);
		// System.in => Ű���� �Է°��� �޴� ���
		System.out.print("���ĺ��� �Է����ּ��� >> ");
		String s = scan.next();
		alpha = s.charAt(0); // ��ó�� ���ڸ� char�� ������ ���� ��� (�޼���)
		// ���
		System.out.println(alpha);

		if (alpha >= 'A' && alpha <= 'Z')
			System.out.println(alpha + "��(��) �빮���Դϴ�.");
		if ('a' <= alpha && alpha <= 'z')
			System.out.println(alpha + "��(��) �ҹ����Դϴ�.");
		if (!((alpha >= 'A' && alpha <= 'Z') || ('a' <= alpha && alpha <= 'z')))
//		if(^A-Za-z)
			System.out.println(alpha + "��(��) ���ĺ��� �ƴմϴ�.");
	}

}
