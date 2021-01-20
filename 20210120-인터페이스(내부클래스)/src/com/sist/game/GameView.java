package com.sist.game;
import javax.swing.*;
import java.awt.*;
/*
 *    /  => //
 *    "  => /"
 *    
 *    JFrame 
 *    JPanel
 *    JWindow
 *    JDialog
 */
public class GameView extends JPanel{
    Image back,avata;
    // �ʱⰪ => ���� : �ʱ�ȭ �� , ������
    int x=100,y=300;
    public GameView()
    {
    	back=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\background.jpg");
    	avata=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\player\\my_00.png");
    }
    public void setImage()
    {
    	for(int i=0;i<9;i++)
    	{
    		avata=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\player\\my_0"+i+".png");
    		
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception e){}
    		repaint();
    	}
    }
	@Override
	public void paint(Graphics g) {
		g.drawImage(back,0,0,getWidth(),getHeight(),this);
		g.drawImage(avata,x,y,this);
	}
    public void start()
    {
    	AvataMove a=new AvataMove();
    	a.start();
    }
    // ������ �׸��� �׸��� 
	class AvataMove extends Thread
	{
		public void run()
		{
			setImage();
			avata=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\player\\my_00.png");
			repaint();
		}
	}
    
    
}
