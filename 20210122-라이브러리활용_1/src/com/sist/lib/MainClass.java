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
//		Object obj = null;          ���������� �׻� �ʱ�ȭ�� ������Ѵ�.1
//		try {
//			obj = super.clone(); // super�� Object
//		} catch (Exception ex) {
//		}
//		return obj;
//
//	}

	public Box clone() {
		Object obj = null; // ���������� �ݵ�� �ʱⰪ�� ����
		/*
		 * Ŭ������ �ʱⰪ => null, new Ŭ����();
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
		// �̱��� => ������
		Box box1 = new Box();
		box1.setWidth(100);
		box1.setHeight(100);

		Box box2 = box1;
		box2.setWidth(300);
		box2.setHeight(300);
		System.out.println("box1 -> width:" + box1.getWidth());
		System.out.println("box1 -> height: " + box1.getHeight());

		System.out.println("============================================");
		Box box3 = (Box) box1.clone();// �������� Object�̹Ƿ� ����ȯ�� ������� �Ѵ�.
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
