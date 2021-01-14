import javax.swing.*;

public class MyWindow extends JFrame { // is-a
	JButton b = new JButton("Click");
	JButton b1 = new JButton("Click");
	JButton b2 = new JButton("Click");
	JButton b3 = new JButton("Click");
	JButton b4 = new JButton("Click");
	
	public MyWindow() {
		add("North", b);
		add("Center", b1);
		add("South", b2);	
		add("East", b3);
		add("West", b4);
		setSize(640, 480);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyWindow m = new MyWindow();

	}

}
