package com.sist.main;

class Box<T> { // T는 임시 변수 => Object
	T item;

	public void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}
}

public class MainCalss {

	public static void main(String[] args) {
		Box box = new Box();
		Box<String> box1 = new Box<String>();
		String s = box1.getItem();
		
	
	
	}

}
