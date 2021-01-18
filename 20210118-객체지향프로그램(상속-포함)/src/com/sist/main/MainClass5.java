package com.sist.main;
/*
 * ������ (page 344)
 * ================
 * ���� ������: public, protected, default, private
 * Ŭ����
 * =====
 *      Ŭ����: public, default
 *      �������: public, protected, default, private
 *      
 *      �޼���:  public, protected, default, private
 *      ������:  public, protected, default, private 
 *      =====> �޼���� �����ڴ´ٸ� Ŭ������ ������ ���� ������ ũ�Ƿ� public ����� ����
 *      
 *      final, static, abstract, synchronized
 *      =====
 *      ����� �� �� ���� Ŭ����, ���
 *      static: ��������
 *      abstract: �߻����� => �������� �ʰ� ����
 *      synchronized: ����ȭ, �񵿱�ȭ
 *                    ====
 *                    �޼���� �⺻������ ����ȭ
 *                    
 *      ����� (353page)
 *      Ŭ����
 *      ���������� �ɼ� class className
 *              [final, abstract]
 *      [public, dafault]
 *      
 *      
 *      public final class
 *      public abstract class
 *      
 *      (default) final class
 *      (default) abstract class
 *      =============================
 *      
 *      �޼���
 *      ���������� �ɼ�	������ �޼����()
 *      ======= === 
 *      ����������: [public|private|default|protected]
 *      �ɼ�: [final|abstract|static]
 *      
 *      �������
 *      ���������� �ɼ� �������� ������
 *      ======= ===
 *      ����������: [public|private|default|protected]
 *      �ɼ�: [final|static]
 *      
 *      => ���������� �ɼ�
 *         public static
 *      => �ɼ� ����������
 *         static public2
 *      
 */

class Student {
	private int hakbun;
	public String name;
	protected String sex;
	int kor;

	public Student() {
	}

	protected Student(int a) {
	}

	Student(int a, int b) {
	}

	private Student(int a, int b, int c) {
	}

}

public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
