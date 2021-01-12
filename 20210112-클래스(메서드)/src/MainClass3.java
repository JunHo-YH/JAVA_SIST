// 매개변수 전송
// 값만 전송하는 방식 (기본데이터형)
// 주소를 전송하는 방식 (배열, 클래스 => 넘겨준 주소의 데이터를 변경): String은 예외 (String은 기본데이터형과 유사)
class Data {
	int x = 10;
	int y = 20;
}

class DataSend {
	void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
		System.out.println("x = " + x + ", y = " + y);

	}

	void swap(int[] arr) {
		int tmp = arr[0];
		arr[0] = arr[1];
		arr[1] = tmp;

	}

	void swap(Data d) {
		int temp = d.x;
		d.x = d.y;
		d.y = temp;
		System.out.println("d.x = " + d.x + ", d.y = " + d.y);
	}

	void swap(String s1, String s2) {
		String temp = s1;
		s1 = s2;
		s2 = temp;
		System.out.println("s1 =" + s1 + ",s2 =" + s2);
	}
}

public class MainClass3 {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Java";
		System.out.println();
		int x = 10;
		int y = 20;
		System.out.println("x=" + x + ", y" + y);
		DataSend ds = new DataSend();
		ds.swap(x, y);
		System.out.println("x=" + x + ", y" + y);
System.out.println();
		Data d = new Data();
		System.out.println("d.x = " + d.x + ", d.y = " + d.y);
		ds.swap(d);
		System.out.println("d.x = " + d.x + ", d.y = " + d.y);

	}
	

}
