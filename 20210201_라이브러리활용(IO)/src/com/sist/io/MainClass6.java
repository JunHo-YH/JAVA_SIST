package com.sist.io;

// 한글로 된 파일 읽기
import java.io.*;

public class MainClass6 {

	public static void main(String[] args) {
		try {
			File file = new File("c:\\javaDev\\daum_news.txt");
			// 읽기
			// FileInputStream fis = new FileInputStream(file); => return byte
			FileReader fis = new FileReader(file); // 한글 파일은 FileReader로 2byte씩 읽어야한다.
													// return char
			/*
			 * 파일 = 일반 파일 => FileInputStream: zip, ppt, doc ... = 한글이 포함된 파일 => FileReader
			 */
			int i = 0; // ASC
			char[] buffer = new char[1024];
			
			while ((i = fis.read()) != -1) { // -1(EOF)
				System.out.print((char) i);
			}
			fis.close();
//			char[] buffer = {'A', 'B', 'C'};
			System.out.println(buffer);
			/*
			 * 1. 한 글자 읽기 ==> read() 2. 여러 글자 읽기 ==> read(byte[] buffer, int off, int len)
			 */

		} catch (Exception ex) {

		}
	}

}
