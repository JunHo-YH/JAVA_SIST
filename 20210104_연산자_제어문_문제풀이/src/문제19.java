
// ������ �Է¹޾Ƽ� ���� ���, ����, �������� ����ϼ���: ���� ���ǹ�
import java.util.Scanner;

public class ����19 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է�: ");
		// �Էµ� ���� �޾Ƽ� �޸� ����
		int input = scan.nextInt();

		if (input > 0)
			System.out.println(input + "��(��) ����Դϴ�.");
		else if (input < 0)
			System.out.println(input + "��(��) �����Դϴ�.");
		else
			System.out.println(input + "��(��) �����Դϴ�.");
	}

}
