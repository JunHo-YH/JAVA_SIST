/*
 * 		break: �ݺ���(while, do~while, for), switch ==> �ݺ����� ����
 * 				break => ���ѷ���(while)
 */
public class �ݺ����_break {

	public static void main(String[] args) {
		// i���� ��� => 1�������� 100����
		for(int i = 1; i<= 100; i++) {
			if (i == 10)
				break;
			System.out.println("i= " + i);
		}
	}

}
