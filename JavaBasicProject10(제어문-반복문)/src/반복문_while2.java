// 1 ~ 100������ ��
// 1 + 2 + 3 + 4 + .... + 100 ?
public class �ݺ���_while2 {

	public static void main(String[] args) {
		// ���� => 1���� 100���� ����Ǵ� ���� => ���� ����
		int i = 1;
		// 1 ~ 100���� ���� ���� �����ϴ� ����
		int sum = 0; // (����) + =>(0), * => 1
		while (i <= 100) {
			sum += i;
			System.out.println("i= " + i + ", sum = " + sum);
			i++;
		}
		System.out.println("1 ~ 100������ �� ����: " + sum + "�Դϴ�.");
	}

}
