package com.sist.main;

/*
 * 1. 클래스 만들기: 재사용 ===> import
 *    = 변수
 *      = 메모리를 따로 생성(new 사용) => 인스턴스 변수
 *      = 메모리를 한 개만 사용 = static 변수
 *    = 메서드 => 리턴형(결과값) / 매개변수 (사용자로부터 전송받은 값)
 *               => 기본데이터형 => 모아서 한 개의 데이터형 => 클래스
 *               1) 리턴형
 *                  결과값이 없다 void
 *                  일반데이터 (int, double, char, boolean, long...)
 *                  클래스: 상세보기
 *                  배열: 목록
 *               2) 매개변수
 *                  기본데이터형
 *                  클래스, 배열, 
 *      = 연산자: 항상 같은 데이터형끼리만 연산이 가능
 *        단항연산자 (++, --, !, (type))
 *        이항연산자 
 *          = 산술( +, -, * , /, % )
 *          = 비교( ==, != , < , >, <=, >= )
 *          = 논리( &&, || )
 *          = 대입( = , += , -=, *=, /= )
 *      = 제어문
 *        조건문( if, if ~ else, if ~else if ~ else )
 *        반복문( while, for )
 *        반복제어( break )
 * 2. 에러발생 방지하는 프로그램: 예외처리
 *    미리 예측해서 구현
 *    = 예외 복구 => try ~ catch
 *      try: 정상수행 할 수 있는 문장
 *      catch: 프로그래머의 실수
 *      finally (생략이 가능) => 오라클, 네트워크, 파일 => 종료:close
 *      => 자동으로 에러를 처리하는 것은 아니다(점프)
 *      => catch는 예상되는 에러처리 (여러개 사용이 가능) => 예외처리 클래스의 순서
 *      => 잘 모른다 catch(Exception e)
 *      => 에러메세지 확인
 *         = getMessage() : 오라클 연결 (null) => 에러메세지만 출력
 *         = printStackTrace() *** 권장 => 위치 지정
 *         
 * 3. 라이브러리 활용
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame implements ActionListener {
	// JFrame 윈도우 => MainClass 윈도우의 모든 기능을 사용할 수 있다.
	// ActionListener => Menu, Button, TextField(Enter)
	// 포함클래스

	JTextField tf; // 입력창(한줄) => ID<Password
	JTextArea ta; // 입력창 => 여러줄 입력
	JButton bu1, bu2;
	// class 안에서 변수: 기본데이터형, 배열, 클래스

	int[] com = { 5, 8, 3 };
	int[] user = new int[3];
	int s, b; // 멤버변수 => 초기화가 안된 상태 => 0값으로 초기화

	public MainClass() { // 멤버변수에 대한 초기화 담당
		tf = new JTextField(10); // 클래스는 초기화 => new
		tf.setEnabled(false);
		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta);
		ta.setEnabled(false);// 비활성화 => 힌트 출력
		bu1 = new JButton("시작");
		bu2 = new JButton("종료");
		// 윈도우에 배치
		JPanel p = new JPanel();
		p.add(tf);
		p.add(bu1);
		p.add(bu2);

		add("Center", js);
		add("South", p);

		// 윈도우 크기 결정
		setSize(350, 500);
		setVisible(true);

		tf.addActionListener(this);// 숫자를 입력하고 엔터 치면 => actionPerformed
		bu1.addActionListener(this);
		bu2.addActionListener(this);
	}

	public static void main(String[] args) {
		MainClass m = new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bu2) {
			System.exit(0);// 프로그램 종료
		} else if (e.getSource() == bu1) {
			JOptionPane.showMessageDialog(this, "게임을 시작합니다!!");
			bu1.setEnabled(false); // 비활성화
			tf.setEnabled(true); // 활성화
			tf.requestFocus(); // focus

		} else if (e.getSource() == tf) {
			// 입력한 값을 가지고 온다
			String strNum = tf.getText();
			if (strNum.length() < 1) {
				String msg = "세자리 정수를 입력하세요";
				ta.append(msg + "\n");
			}
			try {
				int num = Integer.parseInt(strNum);
			} catch (NumberFormatException ex) { // RuntimeException : 생략 가능
				String msg = "정수만 입력이 가능합니다!!";
				ta.append(msg + "\n");
				tf.setText("");
				tf.requestFocus();
				// 처음으로 다시 돌아간다
				return;

			}
		}
	}

}
