
public class ����ȯ_2 {

	public static void main(String[] args) {
		int i = 10;
		byte b = (byte) i;
		System.out.println(b);
		// byte b = 10;
		System.out.println("i = " + i + ", b = " + b);

		i = 350;
		b = (byte) i; // �����÷ο�
		System.out.println("i = " + i + ", b = " + b);
		// 0010 1100 ==> 32 + 8 + 4 = > 44

		// b ==> 8bit (0,1 => 8���� ����)
		/*
		 * 256 128 64 32 16 8 4 2 0(1) 1 0 0 1 0 1 1 0 0
		 *
		 * 300 => 2���� 1 0010 1100 =========
		 */
		System.out.println((byte) 350);
		System.out.println((char) 65);
//		System.out.println(Integer.toBinaryString(94));
		
//		int���� (byte, short, char)�� ����ó���ϸ� ������� int�� ���Ѵ�.
		byte b1 = 10;
		byte b2 = 20;
		byte b3 = (byte)(b1 + b2);
		System.out.println(b3);
		
		int c = 'A' + 'B';
		System.out.println(c);
	
//		short + char + byte = int
		System.out.println();
	}

}
