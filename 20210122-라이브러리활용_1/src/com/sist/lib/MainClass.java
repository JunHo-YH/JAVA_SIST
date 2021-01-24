package com.sist.lib;

class Box implements Cloneable {
	private int width;
	private int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

//	@Override
//	protected Object clone() {
//		Object obj = null;          지역변수는 항상 초기화를 해줘야한다.1
//		try {
//			obj = super.clone(); // super는 Object
//		} catch (Exception ex) {
//		}
//		return obj;
//
//	}

	public Box clone() {
		Object obj = null; // 지역변수는 반드시 초기값을 설정
		/*
		 * 클래스는 초기값 => null, new 클래스();
		 */
		try {
			obj = super.clone();
		} catch (Exception ex) {

		}
		return (Box) obj;
	}

}

public class MainClass {

	public static void main(String[] args) {
		// 싱글톤 => 스프링
		Box box1 = new Box();
		box1.setWidth(100);
		box1.setHeight(100);

		Box box2 = box1;
		box2.setWidth(300);
		box2.setHeight(300);
		System.out.println("box1 -> width:" + box1.getWidth());
		System.out.println("box1 -> height: " + box1.getHeight());

		System.out.println("============================================");
		Box box3 = (Box) box1.clone();// 리턴형이 Object이므로 형변환을 시켜줘야 한다.
		System.out.println("box3 -> width:" + box1.getWidth());
		System.out.println("box3 -> height: " + box1.getHeight());

		box3.setWidth(500);
		box3.setHeight(500);
		System.out.println("============================================");
		System.out.println("box1 -> width:" + box1.getWidth());
		System.out.println("box1 -> height: " + box1.getHeight());

		System.out.println("box1 -> width:" + box1);
		System.out.println("box2 -> height: " + box2);
		System.out.println("box3 -> height: " + box3);

	}

}
