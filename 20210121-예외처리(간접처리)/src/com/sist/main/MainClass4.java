package com.sist.main;

public class MainClass4 {

	public static void main(String[] args) {
		try {
			int a = 10;
			if (a % 2 == 0) {
				throw new MyException("Ȧ���� ����� �����ϴ�");
				// ����� ���� ���ܴ� �ڹٽý��ۿ��� ã�� ���ϱ� ������ ���� ȣ��

			}
		} catch (NumberFormatException ex) {

		} catch (MyException m) {
			System.out.println(m.getMessage());
		} catch (Exception e) {

		}
	}

}
