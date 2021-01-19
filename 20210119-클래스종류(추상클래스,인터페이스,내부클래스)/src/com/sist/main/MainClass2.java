package com.sist.main;

abstract class Common {
	protected int x, y;

	public abstract void movie(int x, int y);

	public void stop() {}
}

class 전투병 extends Common{
//	private int x, y;

	public void movie(int x, int y) {
	}

//	public void stop() {
//	}

	public void use() {
	}
}

class 탱크 extends Common{
	//private int x, y;

	public void movie(int x, int y) {
	}

//	public void stop() {
//	}

//	void changeMode() {
//	}
}

class 수송선 extends Common{
	//private int x, y;

	public void movie(int x, int y) {}

//	public void stop() {
//	}

//	public void load() {
//	}

	public void unload() {
	}
}

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
