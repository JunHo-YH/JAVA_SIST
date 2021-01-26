package com.sist.main;

import java.util.*;
import java.io.*;
import java.net.*;

public class MainClass {

	public static void main(String[] args) {
		try {
			String path = "https://movie.daum.net/magazine/new";
			URL url = new URL(path); // ������Ʈ ������ �� ����ϴ� Ŭ����
			// ���� ���� ����
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) { // ������ ����ƴٸ�
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				while (true) {
					String msg = br.readLine();
					if (msg == null)
						break;
					System.out.println(msg);
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace(); // ����Ȯ��
		}
	}

}
