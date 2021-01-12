class Music {
	String title;
	String singer;
	void print() {
		System.out.println("노래명: " + title);
		System.out.println("가수명: " + singer);
	}
}
public class MainClass {

	public static void main(String[] args) {
		Music m1 = new Music();
		m1.title = "aaa";
		m1.singer = "bbb";
		m1.print();
		
		Music m2 = new Music();
		m2 = m1;
		m2.print();
		
		Music m3 = m1;
		m3.print();
		
		m3.title = "ccc";
		m3.singer = "ddd";
		
		m1.print();
	
	
	
	}

}
