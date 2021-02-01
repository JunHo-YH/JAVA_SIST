package com.sist.io;

// 파일 쓰기
// byte[]
// String
import java.io.*;

public class MainClass7 {

	public static void main(String[] args) {
		try {
			// 1. 파일 만들기
			File file = new File("c:\\download\\sawon.txt");
			
			// 2. 파일 확인
			if (!file.exists()) {
				file.createNewFile();
			}
			
			// 3. 파일 쓰기
			FileWriter fw = new FileWriter(file,true);
			fw.write("박문수|개발부|대리|서울\r\n"); // 개행이 안 되는 파일도 있기 때문에 \r\n을 습관화 하자.
			// 4. 닫기
			fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
