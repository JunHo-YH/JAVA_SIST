package com.sist.string;
// data-original="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/afkudopipqgww3lu.jpg?fit=around|585:585&amp;crop=585:585;*,*&amp;output-format=jpg&amp;output-quality=80"
import java.util.Scanner;

// ���ڿ� ���� concat(), +
public class MainClass3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° ���ڿ� �Է�: ");
		String first = scan.next();
		System.out.print("�ι�° ���ڿ� �Է�: ");
		String second = scan.next();

		// ���ڿ� ����
		String name = first.concat(second);
		System.out.println(name);
		System.out.println(first + second);
	}

}
