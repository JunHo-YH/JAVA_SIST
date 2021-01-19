package com.sist.solve;

class Power {
	private int kick;
	private int punch;

	public int getKick() {
		return kick;
	}

	public void setKick(int kick) {
		this.kick = kick;
	}

	public int getPunch() {
		return punch;
	}

	public void setPunch(int punch) {
		this.punch = punch;
	}

}

public class _1 {

	public static void main(String[] args) {
		Power robot = new Power();
		robot.setKick(10);
		robot.setPunch(20);
	}

}
