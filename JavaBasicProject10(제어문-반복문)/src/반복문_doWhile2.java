// 1 ~ 100 ��� ����, ¦���� ��, Ȧ���� �� => do~while
// ���α׷��� ������ ����
public class �ݺ���_doWhile2 {

	public static void main(String[] args) {
		// 1. �ʱⰪ = 1
		int i = 1;
		
		// 1 ~ 100 ���� ������ �� �ִ� ����, ¦���� ����, Ȧ���� ����
		int sum = 0, even = 0, odd = 0;
		do {
			// ����
			sum += i;
			
			// ¦�� ��, Ȧ�� ��
			if(i % 2 == 0) {
				even += i;
			}
			else {
				odd += i;
			}
			i++;
		} while(i <= 100);
		// ������ �����͸� ���
		System.out.println("1 ~ 100���� ����: " + sum);
		System.out.println("1 ~ 100���� ¦�� ��: " + even);
		System.out.println("1 ~ 100���� Ȧ�� ��: " + odd);
	}

}
