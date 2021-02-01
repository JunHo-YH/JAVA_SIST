package com.sist.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * BufferedInputStream, BufferedOutputStream
 * ObjectInputStream, ObjectOutputStream
 * ===========================================
 * BufferedReader, BufferedWriter
 */
public class MainClass8 {

	public static void main(String[] args) {
		try {
			File file = new File("c:\\javaDev\\News.zip");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			// 보조 스트림 => 임시 저장공간(메모리)에 저장한 후 사용

			FileOutputStream fos = new FileOutputStream("c:\\download\\News.zip");
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			byte[] buffer = new byte[1024];
			int i = 0;
			while ((i = bis.read(buffer, 0, 1024)) != -1) {
				bos.write(buffer, 0, i);
			}

			bis.close();
			bos.close();
			// 실제 웹에서 다운로드할 경우에 처리 내용과 동일
			System.out.println("파일 다운로드 완료!!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
