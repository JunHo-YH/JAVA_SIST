package com.sist.lib;

/*
 * java.util.*
 * ===========
 * ����: �� (Spring(Java,Kotline), Django(Python))
 *      ==
 *      �����ͺ��̽� (����Ŭ) : ���ڿ�,���ڳ�¥
 *                         =====
 *                         String, int(Integer), double, Date(Calendar)
 * 1. StringTokenizer: split(�迭) => ������(�м�)
 *    = hasMoreTokens(): boolean
 *    = NextToken(): ���� �����͸� ������ �´�. : return String
 *    = counterTokens(): ����: return int
 *    = �����ͺ��̽�, ��Ʈ��ũ
 * 2. Date: �ý����� �ð��� �д´�., ��¥ ����: Calendar (�޷�: ����ǥ, ����)
 * 3. ��ȯ
 *    = SimpleDateFormat: ��¥�� ��ȯ�ؼ� ���
 *                        �⵵: yyyy (yy)
 *                        ��: MM(M) => 01(1) => 08���ʹ� 8���� ǥ����� �ɸ���.=> �ǵ����̸� M�� �������
 *                        ��: dd(d)
 *                        �ð�: hh(h)
 *                        ��: mm(m)
 *                        ��: ss(s)
 *    = ChoiceFormat
 *    = MessageFormat
 * 
 */

import java.util.*;
import java.text.*; //��ȯ(Format)

class A {
	int aa = 10;
	public void dispaly() {
		System.out.println("A: display Call");
	}
}

// TO_CHAR('123456789', '99,999,999') => 12,345,678 ���� ��ȯ�� ����Ŭ����, ���ڴ� �ڹٿ��� ��ȯ�ϴ°� ���ϴ�.
public class MainClass {

	public static void main(String[] args) {
		// 1. �ý����� �ð� �б�
		Date date = new Date();

		// 2. ��¥�� ��ȯ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		String today = sdf.format(date);

		// 3. ����
		System.out.println(today);
		
		// �и�
		StringTokenizer st = new StringTokenizer(today, "-");
		String strYear = st.nextToken();
		String strMonth = st.nextToken();
		String strDay = st.nextToken();
		
//		strMonth = "08";
		System.out.println("�⵵: " + strYear);
		System.out.println("��: " + strMonth);
		System.out.println("��: " + strDay);
		
		// 5. ���������� ��ȯ
		int year = Integer.parseInt(strYear);
		int month = Integer.parseInt(strMonth);
		int day = Integer.parseInt(strDay);
		System.out.println("������ ��ȯ �� ���");
		System.out.println("�⵵: " + year);
		System.out.println("��: " + month);
		System.out.println("��: " + day);
		/*
		String today2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		System.out.println(today2);

		A a = new A();
		a.dispaly();
		a.aa = 10;
	
		new A().dispaly();
		new A().aa = 30;
		*/
	}

}
