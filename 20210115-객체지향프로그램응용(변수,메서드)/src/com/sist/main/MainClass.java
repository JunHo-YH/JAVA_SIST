package com.sist.main;
import com.sist.recipe.*;	
/*
 * �ڹ��� �ҽ��� ����
 * 1. package�� ==> 1���� ����� ����
 * 2. �ʿ��� ���̺귯�� import ==> ���� �� ����� ����
 *    ��Ű���� �ִ� Ŭ������ �о�� ��
 *    import com.sist.main.*;
 * 3. class className{
 *        ============
 *         ���� ���� (�ν��Ͻ�����, Ŭ��������)
 *        ============
 *          ������
 *        ============
 *          ���(�޼���)
 *        ============
 *          main�޼��� {
 *          }
 *        ============
 *    }
 */
public class MainClass {

	public static void main(String[] args) {
		RecipeManager rm = new RecipeManager();
		int no = rm.main_menu();
		String data = rm.su_menu(no);
		System.out.println(data);
		
		
		
		
		
		
		
		
	}

}
