package com.sist.string;
// 문자의 위치를 찾아준다 => indexOf, lastIndexOf(경로, 확장자)

/*
 * String s "ABCDEFGABC";
 *           0123456789
 * s.indexOf('A') => 0
 * s.lastIndexOf('A') => 7
 * 
 * indexof('A') indexOf("a")
 */

public class MainClass4 {

	public static void main(String[] args) {
		String image = "https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/afkudopipqgww3lu.jpg?fit=around|585:585&amp;crop=585:585;*,*&amp;output-format=jpg&amp;output-quality=80";
		int index = image.indexOf("?"); // image.indexOf('?')
		int last = image.lastIndexOf('?');
		System.out.println("index:" + index);
		System.out.println("last:" + last);

		// substring
		String real_image = image.substring(0, image.indexOf("?"));
		System.out.println(real_image);
		/*
		 * String substring(int s)
		 * String substring(int s, ine e)
		 */

	}

}
