package com.sist.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMain extends JFrame implements KeyListener, MouseListener {
	GameView gv = new GameView(); // 포함클래스 (있는 그대로 사용)

	public GameMain() {
		// 윈도우 위에 그림을 올린다 => add
		add("Center", gv);

		// 윈도우 크기 결정
		setSize(1024, 768);
		setVisible(true);
		gv.addMouseListener(this);
		gv.addKeyListener(this);
		gv.setFocusable(true);
	}

	public static void main(String[] args) {
		GameMain am = new GameMain();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gv.x = e.getX();
		gv.y = e.getY();
		gv.repaint(); // paint()호출
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		gv.setImage();
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			gv.start();
			gv.y -= 5;
			if (gv.y < 0) gv.y = 768;
			gv.repaint();
			break;
		case KeyEvent.VK_DOWN:
			gv.start();
			gv.y += 5;
			if (gv.y > 768) gv.y = 0;
			gv.repaint();
			break;
		case KeyEvent.VK_LEFT:
			gv.start();
			gv.x -= 5;
			if(gv.x < 0) gv.x = 1024;
			gv.repaint();
			break;
		case KeyEvent.VK_RIGHT:
			gv.start();
			gv.x += 5;
			if(gv.x > 1024) gv.x = 0;
			gv.repaint();
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
