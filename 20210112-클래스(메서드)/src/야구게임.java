
/*
 *    int[] com : ��ǻ�� ���� 
 *    int[] user : ����� �Է°� 
 *    int s, int b;
 *    
 *    1) ��ǻ�Ͱ� ���� �߻�  => int[] com
 *    2) ����� �Է�       => int[] user
 *    3) �� => int[] com,int[] user
 *    4) ��Ʈ => s, b
 *    5) ���Ῡ�� => s
 */
import java.util.Scanner;

public class �߱����� {
	// ����
	// ������� �ڵ� �ʱ�ȭ
	int[] com = new int[3];
	int[] user = new int[3];
	int s, b; // s=0,b=0
	// ���� �߻� => int[] com

	void rand() {
		int su = 0;// ������ �����ϴ� ����
		boolean bCheck = false; // �������� => �ݵ�� �ʱ�ȭ
		// true: �ߺ� , false:�ߺ��� �ȵ�
		// �ߺ��� ���� ������ �ȵȴ�
		// ���� => 3���� �߻�
		for (int i = 0; i < 3; i++) {
			// ����� ������ �ߺ��� �ִ��� Ȯ��
			bCheck = true;
			while (bCheck) {
				// ���� �߻� 1~9������ ���� �߻�
				su = (int) (Math.random() * 9) + 1; // 1~9
				bCheck = false;// while����
				// com�� ����� �����Ϳ� ������ �� => �ߺ��� �ִ��� Ȯ��
				for (int j = 0; j < i; j++) {
					if (com[j] == su) {
						// �ߺ��� ������ => while�� �ٽ� �����Ѵ�
						bCheck = true;
						break;
					}
				}
			}
			com[i] = su; // �ߺ����� ����
		}
	}

	// ����� �Է� => int[] user
	void userInput() {
		Scanner scan = new Scanner(System.in);// System.in => Ű���� �Է°��� �޴´�
		// �ڹ� => ��� �޼ҵ�� Ŭ������ ����
		while (true) {
			System.out.print("���ڸ� ���� �Է�:");
			int input = scan.nextInt();
			// ���� ó��
			// 1. ���ڸ� ������ �ƴ� ��� 100~999
			if (input < 100 || input > 999) {
				System.out.println("���ڸ� ������ ����� �����մϴ�!!");
				// while=>ó������ �̵�
				continue;
			}
			// 789
			user[0] = input / 100; // 789/100 => 7
			user[1] = (input % 100) / 10; // 789%100 => 89/10 => 8
			user[2] = input % 10; // 789%10 => 9
			// 2. �ߺ��� ���� ����� �� ����
			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("�ߺ��� ���� ����� �� �����ϴ�!!");
				continue;
			}
			// 3. 0�� ����� �� ���� => 012
			if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0�� ����� �� ���� �����Դϴ�!!");
				continue;
			}
			// while ����
			break;
		}
	}

	// �� => int[] com,int[] user
	void compare() {
		s = 0;
		b = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (com[i] == user[j])// ���� �����̰�
				{
					if (i == j) // ���� �ڸ���
					{
						s++;
					} else {
						b++;
					}
				}
			}
		}
		/*
		 * 789 com 756 user ========= 1S-0B 789 798 ==== 1S-2B 789 789 ==== 3S-0B ==> ����
		 */
	}

	// ��Ʈ => int[] user,s,b
	void hint() {
		System.out.printf("Input Number:%d%d%d,Result:%dS-%dB\n", user[0], user[1], user[2], s, b);
	}

	// ���� => s(3)
	boolean isEnd() {
		if (s == 3)
			return true;// �޼ҵ�� return�� ������ ����
		return false;
	}

	void process() {

		rand();// ���� �߻�
		while (true) {
			// ����� ���� �Է�
			userInput();
			compare();
			hint();
			if (isEnd() == true) {
				Scanner scan = new Scanner(System.in);
				System.out.print("�����ұ��?(y|n):");
				char c = scan.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					System.out.println("Game Over!!");
					System.exit(0);
				} else {
					System.out.println("�������� �����մϴ�!!!");
					process();// ���ȣ��
				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		�߱����� baseball = new �߱�����();
		baseball.process();
	}

}
