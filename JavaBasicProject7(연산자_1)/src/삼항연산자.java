
public class ���׿����� {

	public static void main(String[] args) {
		char c = 'K';
		boolean bCheck = c> 'A' ? true : false;
		System.out.println(bCheck);
		
		int a = 33;
		String s = a % 2 == 0 ? "¦��" : "Ȧ��";
		System.out.println(s);
		
		int  num = (int)(Math.random()*4 + 1); // ��Ģ���꺸�� ����ȯ�� �켱������ ����
		char sex = num == 1 || num == 3 ? '��' : '��';
		// int, long, float, double
		System.out.println(sex);
		
		sex = '��';
		int no = sex == '��' ? 1 : 2;
		// int, long, float, double
		System.out.println(no);
	}

}
