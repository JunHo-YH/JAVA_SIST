package com.sist.movie_;

// ������ �оVO�� ���� ä���.
import java.io.*;
import java.util.*;

import com.sist.movie.MovieVO;

public class MovieManager {

	public static void main(String[] args) {
		try {
			MovieDAO dao = new MovieDAO();
			StringBuffer sb = new StringBuffer();
			FileReader fr = new FileReader("c:\\javaDev\\movietxt");
			int i = 0;
			while ((fr.read()) != -1) {
				sb.append(String.valueOf((char) i));
			}
			fr.close();
			String data = sb.toString();
			String[] movie = data.split("\n");
			for (String s : movie) {
				StringTokenizer st = new StringTokenizer(s, "|");
				
				// VO�� ���� => ����Ŭ�� ����
				MovieVO vo = new MovieVO();
				vo.setMno(Integer.valueOf(st.nextToken()));
				vo.setTitle(st.nextToken());
				
				// ����Ŭ ����
				dao.moiveInsert(vo); // ����Ŭ�� ������ �߰�
				
				Thread.sleep(100);
				
				// ����Ŭ �ݱ�
				dao.disConnection();
				
			}
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
