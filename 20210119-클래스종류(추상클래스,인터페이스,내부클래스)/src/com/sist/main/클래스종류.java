package com.sist.main;
/*
 * Ŭ������ ����
 * 1) �Ϲ� Ŭ����
 * ���� ������ class className {
 * 
 * 
 * }
 * 
 * 2) �߻�Ŭ����: �̿ϼ� Ŭ���� (�޼��� ��) => �������� ����� �ִ� ���, ���� ���
 *    ���������� abstract class className {
 *            ================
 *            ���� (����, ����)            
 *            ================
 *              ������ �޼���
 *            ================
 *              ����� �޼��� => �ݵ�� ��ӹ��� Ŭ������ �����ؼ� ���
 *              ��) �Դ´�(), �ȴ´�() ...
 *              ��) ��ư Ŭ��, ���콺 Ŭ��
 *              �������̵�: ���α׷��� �°� �����ؼ� ���
 *            ================
 *              ������
 *            ================
 *    
 *            }
 *            
 *            
 * 3) �߻�Ŭ������ ���� => �������̽� (���߻��)
 *    ��, �ڵ���, �����
 *    class Ʈ�������� implements ��,�ڵ���,�����
 *    ���������� interface interfaceName {
 *    ================
 *     ����: ����� ����
 *    ================
 *     ����� �޼���
 *    ================
 *     ������ �޼��� => JDK 1.8�̻�
 *      default
 *      static
 *    ================
 * 4) ���� Ŭ����: ������ ���α׷�, ������ ���α׷�, ��Ʈ��ũ ���α׷�
 *     = ���Ŭ����: �������� ���Ǵ� ����, �޼��尡 ���� �� �ַ� ����Ѵ�.
 *       class A {
 *         
 *         class B { => AŬ������ ������ �ִ� ��� �޼���, ���� ����� �����ϴ�. (��ü ����X)
 *         
 *         }
 *       }
 *     = �͸��� Ŭ����: ��Ӿ��� �������̵��� �����ϴ�.
 *       class A {
 *           public void display() {}
 *       }
 *       class B {
 *           A a = new A() {
 *               public void display() {} => 
 *           }
 *       }
 *     = ����Ŭ����: �޼���ȿ� Ŭ����, ���󵵰� ���� ����.
 *     class A {
 *         public void display() {
 *             class B {
 *             
 *             }
 *         }
 *     }
 * 5) ���� Ŭ����: ����� �� �� ���� Ŭ���� (���������θ� ����� ����) => ���� Ŭ����
 *               String, Math, System ... (������ ��� �״�� ���)
 *    ���������� final class className {
 *       ================
 *        ����
 *       ================
 *        �޼���
 *       ================
 *        ������
 *       ================
 *    
 *    
 *    }
 *    
 *    
 *    
 *    
 *    
 *    }
 */
import javax.swing.*;
import javax.swing.table.*;
// extedns JFrame => (JFrame�� ����) => ��ӹ��� ���븸 ����
public class Ŭ�������� extends JFrame{
	JTable table;
	DefaultTableModel model;
	public Ŭ��������() {
		String[] col = {"�̸�", "�ּ�", "��ȭ"};
		String[][] row = new String[0][3];
		model = new DefaultTableModel(row, col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			// �������̵�
			
		};
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		add("Center", js);
		String[] data = {"ȫ�浿", "����", "010-0000-0000"};
		model.addRow(data);
		setSize(450, 500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ŭ��������();
	}

}
