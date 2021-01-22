package com.sist.string;
// data-original="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/afkudopipqgww3lu.jpg?fit=around|585:585&amp;crop=585:585;*,*&amp;output-format=jpg&amp;output-quality=80"
import java.util.Scanner;

// 문자열 결합 concat(), +
public class MainClass3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 문자열 입력: ");
		String first = scan.next();
		System.out.print("두번째 문자열 입력: ");
		String second = scan.next();

		// 문자열 결합
		String name = first.concat(second);
		System.out.println(name);
		System.out.println(first + second);
	}

}
