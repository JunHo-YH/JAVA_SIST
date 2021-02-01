package com.sist.io;
import java.io.*;
// 파일 입출력
public class MainClass3 {
// FileInputStream, FileOutputStream
	public static void main(String[] args) {
		try {
			// 1. 파일만들기
			File file = new File("c:\\javaDev\\student.txt");
			if (file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			// 파일에 쓰기
//			new FileOutputStream("c:\\javaDev\\student.txt", true); => w, a
//			new FileOutputStream("c:\\javaDev\\student.txt",); => w
			
//			fos.write("홍길동".getBytes()); // write(byte[] buffer) => 문자열을 바이트 배열로 변경 => getBytes()
//			fos.write("심청이".getBytes());
			fos.write('A');
			fos.write('B');
			fos.write('C');
			
			fos.close();
			
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
