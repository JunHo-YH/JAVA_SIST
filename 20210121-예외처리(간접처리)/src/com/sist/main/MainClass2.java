package com.sist.main;
/*
 * ���� ȸ��: �ý��ۿ��� ó�� => throws
 * ����)
 *     ���������� ������ �޼����(�Ű�����...) throws ����Ǵ� ���� ���
 *     ex)
 *        public void display() throws NumberFormatException, NullPointerException
 *        								, ClassCastingException, Exception
 *                                     ==================================== ������ ����.
 *                                     
 */
import java.io.*;
public class MainClass2 {
	public void display() throws Exception, NumberFormatException, ArithmeticException, ArrayIndexOutOfBoundsException {
		
	}
	public static void main(String[] args) throws Exception{ //main�� ���� ȣ���ϳ�? �Լ�ó�� ȣ���� �����Ѱ�?
		MainClass2 m = new MainClass2();
		m.display();
		FileReader fr = new FileReader("c:\\javaDev\\movie.json");
	}

}
