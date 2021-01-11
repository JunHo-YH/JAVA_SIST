
public class Chef {
	String writer;
	String poster;
	String clip;
	String view;
	String follower;
	public static void main(String[] args) {
		Chef c = new Chef();
		c.writer = "시크제이맘";
		c.poster = "1,712";
		c.clip = "1,027,593";
		c.view = "33,561,876";
		c.follower = "21,771";
		
		
		System.out.println("작성자: " + c.writer);
		System.out.print(c.poster + "\t" + c.clip + "\t" + c.view + "\t" + c.follower);
	}

}
