/*
 * 		continue: Ư���κ��� �����ϰ� �ٽ� �����Ѵ�
 * 		======== �ݺ��������� ���
 * 	
 * 		for(�ʱⰪ; ���ǽ�; ������) {
 * 			�ݺ����� ����
 * 			if(���ǹ�)
 * 				break; ===> if�� �ִ� ���ǹ��� true => for���� �ߴ�
 * 		}
 * 
 * 		�ʱⰪ
 * 		while(���ǽ�) {
 * 			�ݺ����๮��
 * 			if(���ǹ�)
 * 				continue; ==> ���ǹ��� true�� �� while���� ���ǽ����� �̵�
 * 
 * 			������
 * 		}

 * 		for(�ʱⰪ; ���ǽ�; ������) {
 * 			�ݺ����๮��
 * 			if(���ǹ�) {
 * 				continue; ==> true ==> ���������� �̵�
 * 			}
 * 		}
 * 
 */
public class �ݺ���_Continue {

	public static void main(String[] args) {
//		int i = 0;
//		while (i < 10) {
//			i++;
//			if (i == 5)
//				continue;
//			System.out.println("i = " + i);
//			
//		}
		
		for(int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println("i = " + i);
		}
	}

}










