package com.sist.main;

import java.util.*;
import java.io.*;
import java.net.*;

public class MainClass {

	public static void main(String[] args) {
		try {
			String path = "https://movie.daum.net/magazine/new";
			URL url = new URL(path); // 웹사이트 연결할 때 사용하는 클래스
			// 다음 서버 연결
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) { // 다음에 연결됐다면
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				while (true) {
					String msg = br.readLine();
					if (msg == null)
						break;
					System.out.println(msg);
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류확인
		}
	}

}
