/*
 * 		do~while: ���� �˻��� ���߿� �ϱ� ������ �ݵ�� �� �� �̻� ����
 * 		����)
 * 			�ʱⰪ int i = 1;
 * 			do {
 * 				�ݺ����� ====> 2
 * 				������  ====> 3	
 * 			}
 * 			while(���ǽ�);====> 4 ====> 2 ===> 3 ===> 4
 * 									   =================> 4(false�� ��쿡 ����)
 */
public class �ݺ���_doWhile {

	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("i = " + i);
			i++;
		}while(i <= 5);
	}

}
