package com.sist.io;

// 파일 복사 (업로드) => FileInputStream, FileOutputStream
// 파일 읽기/ 파일 쓰기 => FileReader, FileWriter (2byte => 한글)
import java.io.*;

public class MainClass5 {

	public static void main(String[] args) {
		try {
			// 1. 파일을 복사할 폴더를 만든다
			File dir = new File("c:\\download");
			if (!dir.exists()) { // 폴더가 없는 경우, 폴더를 만든다.
				dir.mkdir();
			}
			// 2. 파일 읽기 => 복사
			File file = new File("c:\\javaDev\\back.jpg");
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(dir + "\\" + file.getName());

			int i = 0;
			byte[] buffer = new byte[1024];
			while ((i = fis.read(buffer, 0, 1024)) != -1) {
				System.out.println(i);
				fos.write(buffer, 0, i); // send()
			}
			fis.close();
			fos.close();
			System.out.println("복사 완료");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
