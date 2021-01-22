package com.sist.string;

/*
 * trim(): �¿쿡 �ִ� ���鹮�� ����
 * 		ex) "  Heelo Java ".trim() ==> "Hello Java" ��� ������ �������� �ʴ´�. �¿��� ���鸸 ����
 *      ���) �˻���, �α��� ó��, ���̵� �ߺ�üũ, �Խ��� ��й�ȣ ó��
 * ������: String
 * �Ű�����: ����
 * ����: public String trim()
 * 
 * valueOf(): ��� ���������� ���ڿ��� ��ȯ�� �� ���
 *            100 => "100"
 *            true = > "true"
 * ������: String
 * ����: public static String valueOf(��������)
 * 
 * 100 => int a = 100;
 *        String s = (String)a; => (X)
 *                   a.toString() (X)
 *                   String.valueOf(a)
 * String s = "Hello Java";
 * String s1 = "Oracle";
 * substring(0,3)
 * Web, Widow => String
 */
public class MainClass8 {
	public static void main(String[] args) {
		String msg = " Hello Java ";
		System.out.println(msg);
		System.out.println(msg.length());
	
		String msg2 = msg.trim();
		System.out.println(msg2);
		System.out.println(msg2.length());
		System.out.println(String.valueOf(100));
		
		
		int a = 100;
		int b = 200;
		String s = String.valueOf(a); // s = "100"
		String s1 = String.valueOf(b); // b = "200"
		String s2 = String.valueOf(true); // s2 = "true"
		String s3 = String.valueOf(10.5); // s3 = "10.5"
		
	}

}
