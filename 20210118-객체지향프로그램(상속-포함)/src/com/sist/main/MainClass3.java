package com.sist.main;

// �������̵� (������)
// ��� Ŭ������ Object�κ��� ��ӹ޴´�.
/*
 * �ڹٿ����� �����ϴ� ���̺귯���� �������� Object => �ʿ�ø��� ����ȯ�� ��Ų��.
 *                                          ====================== ���׸���
 *                                          List<String>
 * 
 * 
 */
public class MainClass3 {
	// Object�� ������ �ִ� �޼��带 ������
	private String name, addr, tel;
	// ������ �� ����ڷκ��� ���� �޾Ƽ� ��������� �ʱ�ȭ
	public MainClass3(String n, String a, String t) { // �Ű������� �ִ� �����ڰ� �ֱ� ������ default �����ڴ� �߰�X
		this.name = n;
		addr = a;
		tel = t;
	}
/*
	public String toString() {
		return "�̸�:" + name + ", �ּ�: " + addr + ", ��ȭ: " + tel;
	}
*/
	public static void main(String[] args) {
		Object m = new MainClass3("ȫ�浿", "����", "010-0000-0000");
		MainClass3 m2 = (MainClass3) m;
		/*
		 * ����Ŭ������ ��ü �ּҸ� �޴� ��� => �������̵��� �޼��常 ȣ���� ����
		 */
		String result = m.toString();
		System.out.println(result);
	}

}
