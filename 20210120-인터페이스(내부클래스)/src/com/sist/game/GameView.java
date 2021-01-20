package com.sist.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * class ===> class
 *        extends
 * interface ==> interface
 *      extends
 * interface ===> class
 *        implements
 * class =====> interface ===> class
 *       extends           implements
 *      
 */
public class GameView extends JPanel {
	Image back, avata;
	// 초기값 => 구현 : 초기화 블럭, 생성자
	int x = 100, y = 300;

	public GameView() {
		back = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\background.jpg"); // static 메서드
		avata = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\player\\my_00.png");
	}

	public void setImage() {
		for (int i = 0; i < 9; i++) {
			avata = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\player\\my_0" + i + ".png");
			repaint();
			try {
				Thread.sleep(10);
			} catch(Exception ex) {
				repaint();
				
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(avata, x, y, this);

	}
	public void start() {
		AvataMove a = new AvataMove();
		a.start();
	}

	// 윈도우 그림을 그린다
	class AvataMove extends Thread {
		public void run() {
			setImage();
			avata = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\player\\my_00.png");
			repaint();
		}
	
	}

}
