package com.sist.io;

// File 정보
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

/*
 * 자바파일 구조
 * ==========
 * 
 * 
 */
// 파일에 대한 정보 확인
public class MainClass2 {

	public static void main(String[] args) {
		File file = new File("c:\\javaDev\\daum_movie.txt");
		System.out.println("======= daum_movie.txt 상세 정보 =======");
		// Bytes => KB => MB
		System.out.println("***1. 파일 크기:" + file.length() + "Bytes");
		System.out.println("2. 숨김파일여부:" + file.isHidden());
		System.out.println("3. 읽기전용:" + file.canRead());
		System.out.println("4. 쓰기전용:" + file.canWrite());

		System.out.println("***5. 파일명:" + file.getName());
		System.out.println("6. 경로명:" + file.getParent());
		System.out.println("***7. 파일명+경로명:" + file.getPath());
		System.out.println("8. 파일여부" + file.isFile());
		System.out.println(
				"9. 수정일: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
		File create_file = new File("c:\\javaDev\\naver_movie.txt");
		try {
			System.out.println("***10. 새로운 파일 생성: " + create_file.createNewFile());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("***11. 파일 삭제" + create_file.delete());
	}

}
