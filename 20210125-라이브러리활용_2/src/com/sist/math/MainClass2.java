package com.sist.math;
/*
 *   Wrapper : �⺻���������� Ŭ����ȭ ��Ų Ŭ�������� ���� 
 *   =======
 *     ������ 
 *       byte     =============  Byte
 *       short    =============  Short
 *       int      =============  *****Integer  ��ȯ) ���ڿ� => ���� : parseInt("���ڿ�") 
 *                                    => ���� (������ȯ�� �ȵɶ� NumberFormatException)
 *                                    => http://localhost/board/list.jsp?page=true 
 *                                       String page=request.getParameter("page");
 *                                       int page=Integer.parseInt(page);
 *                                       String s="1";
 *                                       if(s.equals("1"))
 *                                         page=1  ==> 21�� 4õ 
 *       long     =============  *****Long  => Long.parseLong("100")
 *     �Ǽ���
 *       float    =============  Float
 *       double   =============  *****Double => Double.parseDouble("10.5")
 *     ������
 *       char     ============= Character
 *     ���� 
 *       boolean  ============= *****Boolean  => Boolean.parseBoolean("true")
 *       
 *     ===> ��������ó�� ����� ���� 
 *     Integer i=10;
 *     int j=i;
 *     
 *     
 */
import java.util.Scanner;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*Scanner scan=new Scanner(System.in);
        System.out.print("ù��° ���� �Է�:");
        String s1=scan.next();
        int i=Integer.parseInt(s1.trim());// ���鹮�� ������ ���������� ��ȯ
        System.out.print("�ι�° ���� �Է�:");
        String s2=scan.next();
        int j=Integer.parseInt(s2.trim());
        // ������ 
        System.out.println(s1+s2);
        System.out.println(i+j);*/
		int i=100;
		Integer ii=i;//����ڽ�
		int j=ii;//��ڽ�
		// �Ϲݵ������� <=> Ŭ������ 
		Boolean boo=true;
		boolean b=boo;
		Long l=10L;
		long l2=l;
		Double d=10.5;
		double d2=d;
		
		String ss="true";
		boolean bb=Boolean.parseBoolean(ss); // true
		
		String ss1="10.5";
		double dd=Double.parseDouble(ss1);
		
		String ss2="10000000000000000";
		long ll=Long.parseLong(ss2);
		
		System.out.println(bb);
		System.out.println(dd);
		System.out.println(ll);
		
		int k1=Integer.parseInt("1000",2);// 2���� ǥ��  => 100 => 4
		int k2=Integer.parseInt("1000"); //1000 (10���� ǥ��)
		int k3=Integer.parseInt("100",8);// 64 
		/*
		 *       1  0  0
		 *      8^2 8^1 8^0
		 */
		int k4=Integer.parseInt("FF",16);// F=>15  15*16+15
		System.out.println(k1);
		System.out.println(k2);
		System.out.println(k3);
		System.out.println(k4);
		/*
		 *   �ڹٿ��� ���� ǥ�� 
		 *   2����
		 *   8����
		 *   16����
		 *   10����
		 */
		int k5=789;
		System.out.println(Integer.toBinaryString(k5));//2 ***
		System.out.println(Integer.toHexString(k5));//16
		System.out.println(Integer.toOctalString(k5));//8
		
		Integer k6=10;
		String sss=k6.toString();// ���ڿ� ��ȯ ***
		Integer k7=20;
		
		System.out.println(k6+k7);
		
		
		long lll=10; // lll=10L
		Long k8=lll; // LongŬ�����ȿ��� �ݵ�� long�� ����� �� �ִ�
		
	}

}




















