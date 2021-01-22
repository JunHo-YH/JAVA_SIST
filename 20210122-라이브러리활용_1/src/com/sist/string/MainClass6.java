package com.sist.string;
// split => ºÐ¸®
public class MainClass6 {

	public static void main(String[] args) {
		String color = "red,blue,green,black,yello,magenta";
		String[] colors = color.split(",");
		for (String s : colors) {
			System.out.println(s);
		}
	
	}

}
