import java.util.Scanner;

// ���� 1���� �Է��� �޾Ƽ� => 3, 5, 7�� ������θ� Ȯ��
public class �������ǹ�_1 {

	public static void main(String[] args) {
		// �Է¹��� ������ ������ �޸� ���� : ����
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("���� �� ���� �Է�: ");
		// �Էµ� ���� ==> �Է��ϰ� Enter
		num = scan.nextInt();
		
		// ���� = 3�� ���
		// ���ǿ� �´� ��� ������ ���� => �������ǹ� ���� ���� ����Ѵ�. => �ߺ������� ������ �����ϴ�.
		if(num % 3 == 0)
		{
			System.out.println(num + "��(��) 3�� ����Դϴ�.");
		}
		if(num % 5 == 0)
		{
			System.out.println(num + "��(��) 5�� ����Դϴ�.");
		}
		if(num % 7 == 0)
		{
			System.out.println(num + "��(��) 7�� ����Դϴ�.");
		}
		
		
	}

}
