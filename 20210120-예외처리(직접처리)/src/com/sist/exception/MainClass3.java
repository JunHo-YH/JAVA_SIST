package com.sist.exception;

/*
 * ����ڷκ��� 2���� ������ �޾Ƽ� �迭�� ������ ������ �ΰ��� �������� ������� ���
 *                          =========             =====              
 */
import java.util.Scanner;

public class MainClass3 {

	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("ù��° ���� �Է�");
			int a = scan.nextInt();
			System.out.println("�ι��� ���� �Է�");
			int b = scan.nextInt();

			int[] arr = { a, b };
			int res = arr[0] / arr[1];
			System.out.println("res" + res);
			// catch�� ����� ����ó��Ŭ������ ������ �����Ѵ�
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ������ �ʰ��߽��ϴ�.");

		} catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} catch (RuntimeException e) {
			System.out.println("���� ���� ���� �߻��߽��ϴ�.");
		}
		System.out.println("���α׷� ����");

	}

}
