package com.sist.main;

/*
 * ����
 * ȸ��
 * ��ȯ => ���Ƿ� ������ �߻��� �� �ִ�.
 */
public class MainClass3 {

	public static void main(String[] args) throws Exception {
		try {
			String s = " 100";
			int i = Integer.parseInt(s); // ���ڿ��� ������ ��ȯ
		} catch (NumberFormatException ex) {

			try {
				System.out.println("���� ��ȯ ����");
				throw new Exception(); // ���� ó�� ȣ��
				// throw => ����� ���� ����ó�� ȣ���� �� �ַ� ���
				// throw => �������ٿ� �ҽ��ڵ�
			} catch (Exception e) {
				System.out.println("�ٽ� �Է��ϼ���!!");
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("�迭 ���� �ʰ�");
		} catch (Exception e) {

		}
	}

}
