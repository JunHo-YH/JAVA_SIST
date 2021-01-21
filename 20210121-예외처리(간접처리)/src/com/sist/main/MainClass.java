package com.sist.main;

/*
 * 1. Ŭ���� �����: ���� ===> import
 *    = ����
 *      = �޸𸮸� ���� ����(new ���) => �ν��Ͻ� ����
 *      = �޸𸮸� �� ���� ��� = static ����
 *    = �޼��� => ������(�����) / �Ű����� (����ڷκ��� ���۹��� ��)
 *               => �⺻�������� => ��Ƽ� �� ���� �������� => Ŭ����
 *               1) ������
 *                  ������� ���� void
 *                  �Ϲݵ����� (int, double, char, boolean, long...)
 *                  Ŭ����: �󼼺���
 *                  �迭: ���
 *               2) �Ű�����
 *                  �⺻��������
 *                  Ŭ����, �迭, 
 *      = ������: �׻� ���� �������������� ������ ����
 *        ���׿����� (++, --, !, (type))
 *        ���׿����� 
 *          = ���( +, -, * , /, % )
 *          = ��( ==, != , < , >, <=, >= )
 *          = ��( &&, || )
 *          = ����( = , += , -=, *=, /= )
 *      = ���
 *        ���ǹ�( if, if ~ else, if ~else if ~ else )
 *        �ݺ���( while, for )
 *        �ݺ�����( break )
 * 2. �����߻� �����ϴ� ���α׷�: ����ó��
 *    �̸� �����ؼ� ����
 *    = ���� ���� => try ~ catch
 *      try: ������� �� �� �ִ� ����
 *      catch: ���α׷����� �Ǽ�
 *      finally (������ ����) => ����Ŭ, ��Ʈ��ũ, ���� => ����:close
 *      => �ڵ����� ������ ó���ϴ� ���� �ƴϴ�(����)
 *      => catch�� ����Ǵ� ����ó�� (������ ����� ����) => ����ó�� Ŭ������ ����
 *      => �� �𸥴� catch(Exception e)
 *      => �����޼��� Ȯ��
 *         = getMessage() : ����Ŭ ���� (null) => �����޼����� ���
 *         = printStackTrace() *** ���� => ��ġ ����
 *         
 * 3. ���̺귯�� Ȱ��
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame implements ActionListener {
	// JFrame ������ => MainClass �������� ��� ����� ����� �� �ִ�.
	// ActionListener => Menu, Button, TextField(Enter)
	// ����Ŭ����

	JTextField tf; // �Է�â(����) => ID<Password
	JTextArea ta; // �Է�â => ������ �Է�
	JButton bu1, bu2;
	// class �ȿ��� ����: �⺻��������, �迭, Ŭ����

	int[] com = { 5, 8, 3 };
	int[] user = new int[3];
	int s, b; // ������� => �ʱ�ȭ�� �ȵ� ���� => 0������ �ʱ�ȭ

	public MainClass() { // ��������� ���� �ʱ�ȭ ���
		tf = new JTextField(10); // Ŭ������ �ʱ�ȭ => new
		tf.setEnabled(false);
		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta);
		ta.setEnabled(false);// ��Ȱ��ȭ => ��Ʈ ���
		bu1 = new JButton("����");
		bu2 = new JButton("����");
		// �����쿡 ��ġ
		JPanel p = new JPanel();
		p.add(tf);
		p.add(bu1);
		p.add(bu2);

		add("Center", js);
		add("South", p);

		// ������ ũ�� ����
		setSize(350, 500);
		setVisible(true);

		tf.addActionListener(this);// ���ڸ� �Է��ϰ� ���� ġ�� => actionPerformed
		bu1.addActionListener(this);
		bu2.addActionListener(this);
	}

	public static void main(String[] args) {
		MainClass m = new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bu2) {
			System.exit(0);// ���α׷� ����
		} else if (e.getSource() == bu1) {
			JOptionPane.showMessageDialog(this, "������ �����մϴ�!!");
			bu1.setEnabled(false); // ��Ȱ��ȭ
			tf.setEnabled(true); // Ȱ��ȭ
			tf.requestFocus(); // focus

		} else if (e.getSource() == tf) {
			// �Է��� ���� ������ �´�
			String strNum = tf.getText();
			if (strNum.length() < 1) {
				String msg = "���ڸ� ������ �Է��ϼ���";
				ta.append(msg + "\n");
			}
			try {
				int num = Integer.parseInt(strNum);
			} catch (NumberFormatException ex) { // RuntimeException : ���� ����
				String msg = "������ �Է��� �����մϴ�!!";
				ta.append(msg + "\n");
				tf.setText("");
				tf.requestFocus();
				// ó������ �ٽ� ���ư���
				return;

			}
		}
	}

}
