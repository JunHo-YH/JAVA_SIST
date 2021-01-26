package com.sist.lib;
// MessageFormat => SQL������ ���� ��

/*
 * SQL
 *   = DML
 *     = SELECT
 *     = INSERT
 *     = UPDATE
 *     = DELETE
 *   = DDL
 *   = DCL
 *   = TCL
 *   
 * PL/SQL
 */

import java.text.*; // Format�� text�� �� �ִ�.
//�����͸� ������ ������� ����� �� �ַ� ��� (����Ŭ ����)
public class MainClass4 {

	public static void main(String[] args) {
		String msg = "�̸�:{0}\n����:{1}\n��ȭ:{2}\n�ּ�:{3}\n����{4}\n";
		Object[] obj = {"ȫ�浿", "����", "010-1111-1111", "����", 30};
		// Object�迭�� ��� ���������� ���� �� �ִ�.
		
		String result = MessageFormat.format(msg, obj);
		System.out.println(result);
		
		
		
	}

}
