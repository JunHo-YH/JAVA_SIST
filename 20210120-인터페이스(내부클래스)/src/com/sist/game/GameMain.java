package com.sist.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 *     class ===> class
 *          extends 
 *     interface ===> interface
 *          extends
 *     interface ===> class
 *          implements 
 *     class ===== interface ==== class  
 *          extends       implements 
 *     ���� ���� 
 *     interface A
 *     interface B
 *     class C implements A,B
 *     
 *     interface A
 *     interface B
 *     class C
 *     class D extends C implements A,B
 *     
 *     ==> Ŭ������ ������ 
 *         ����� ���� ===> ���� ������ Ʋ�� ��� => �������̽� 
 *         ���α׷� �°� �����ؼ� ��� 
 *         �������̽� : default => �ʿ��� ��쿡 �������̵� => ������ ���� ���
 *     
 *     
 */
public class GameMain extends JFrame implements KeyListener,MouseListener{
    GameView gv=new GameView();// ���� Ŭ���� (�ִ� �״�� ���) => has-a
    public GameMain()
    {
    	// ������ ���� �׸��� �ø��� => add
    	add("Center",gv);
    	// ������ ũ�� ����
    	setSize(1024, 768);
    	// �����츦 ������
    	setVisible(true);
    	gv.addMouseListener(this);
    	gv.addKeyListener(this);
    	gv.setFocusable(true);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GameMain am=new GameMain();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gv.x=e.getX();
		gv.y=e.getY();
		gv.repaint();// paint()ȣ�� 
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
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			 gv.start();
			 gv.y-=5;
			 if(gv.y<0) gv.y=768;
			 gv.repaint();
			 break;
		case KeyEvent.VK_DOWN:
			 gv.start();// run() 
			 gv.y+=5;
			 if(gv.y>768) gv.y=0;
			 gv.repaint();
			 break;
		case KeyEvent.VK_LEFT:
			 gv.start();
			 gv.x-=5;
			 if(gv.x<0) gv.x=1024;
			 gv.repaint();
			 break;
		case KeyEvent.VK_RIGHT:
			  gv.start();
			 gv.x+=5;
			 if(gv.x>1024) gv.x=0;
			 gv.repaint();
			 break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
