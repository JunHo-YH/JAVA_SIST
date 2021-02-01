package com.sist.io;

import java.io.*; // 파일포함 => 입출력과 관련된 모든 클래스의 집합(메모리입출력,파일입출력,네트워크입출력)
// URL => IO를 이용해서 입출력 => 전체 파일의 내용을 모아서 처리 => BufferedReader ~
// File
/*
 * 1. File 객체 생성
 *    File file = new File("c:\\폴더명\\파일명");
 *    
 *    File dir = new File("c:\\폴더명")
 *    File file = new File(dir,"파일명")
 */

public class MainClass {

	public static void main(String[] args) {
		// 폴더(directory) 읽기
		// 1. 폴더 만들기
		File dir = new File("c:\\download");
		if (!dir.exists()) { // 폴더 존재여부 확인
			// 존재하지 않을 경우 폴더 만들기
			dir.mkdir();
		}

		// 폴더안에 들어가 있는 파일의 종류
		File[] files = dir.listFiles();// 탐색기를 만드는 경우
		for (File f : files) {

			if (f.isFile()) { // 파일일 경우
				System.out.println(f.getName());
			}
			if (f.isDirectory()) { // 폴더일 경우
				System.out.println(f.getName() + "DIR");
			}
		}
		// 폴더 삭제
		dir.delete(); // 폴더 안에 파일이나 폴더가 있는 경우에는 삭제할 수 없다.
		for (File f : files) {
			if (f.isFile()) {
				f.delete();
			}
			if (f.isDirectory()) {
				File dir2 = new File("c:\\download\\" + f.getName());
				File[] files2 = dir2.listFiles();
				for (File ff : files2) {
					ff.delete();
				}
				dir2.delete();
			}
		}
		dir.delete();

	}

}
