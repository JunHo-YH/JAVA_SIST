import javax.swing.*;

public class MyWindow2 { // has-a
	JFrame f = new JFrame();

	public MyWindow2() {
		f.setSize(480, 480);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		MyWindow m = new MyWindow();
	}

}
