package com.sist.manager;
// �ٸ� ��Ű���� �ִ� Ŭ���� �б� => �ڹٿ��� �����ϴ� ���̺귯��, ����� ����
import java.io.FileReader;
/*
 * public String[] aaa()
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieManager {
	public MovieVO[] movieAllData() {
		MovieVO[] movie = new MovieVO[7]; // �����͸� 7�� ��Ƽ� main���� ����
		try {
			FileReader fr = new FileReader("c:\\javaDev\\movie.json"); // movie.json���Ͼȿ� 7���� ��ȭ������
			String data = "";
			int i = 0; // ���� ��ȣ => 'A' => 65
			while ((i = fr.read()) != -1) // -1 ���ϳ� read()=>�ѱ��ھ� �о�´�
			{
				data += String.valueOf((char) i); // ���ڿ� ����
				                    // ���� ��ȣ�� ���ڷ� ��ȯ => String�� ����
				                    // �����Ͱ� ���� ��쿡�� String => StringBuffer���
				/*
				 *  + => ���������, ���ڿ� ����
				 */
			}
			fr.close();// ���� �ݱ�
			 System.out.println(data); // ��ü�� ���Ͽ� �������� Ȯ��

			// �Ľ� (���Ͽ��� ���õ� ������ �б�)
			 /*
			  *  {} => JSONObject
			  *  [] => JSONArray
			  */
			JSONParser jp = new JSONParser();
			JSONObject root = (JSONObject) jp.parse(data);
			System.out.println(root.toJSONString());// ���ڿ� ��ȯ
			// {datas
			JSONArray arr = (JSONArray) root.get("datas");
			System.out.println(arr.toJSONString());
			// [
			// System.out.println(arr.size());
			for (i = 0; i < 50; i++) {
				movie[i] = new MovieVO();// ��ü �迭
				System.out.println("movie[" + i + "]:" + movie[i]);
				JSONObject obj = (JSONObject) arr.get(i);
				System.out.println(obj.toJSONString());
				// JSON => ������ (int => long)
//				int mno = (int) obj.get("mno");
//				movie[i].setMno(mno);	
				// Integer.parseInt => String�� int��ȯ
				movie[i].setTitle((String) obj.get("title")); // �����͸� �Ѱ��� �о�´�.
				movie[i].setActor((String) obj.get("actor"));
				movie[i].setPoster((String) obj.get("poster"));
				movie[i].setDirector((String) obj.get("director"));
				movie[i].setGrade((String) obj.get("grade"));
				movie[i].setStory((String) obj.get("story"));
				// ������ �ʱⰪ�� ����
			}
		} catch (Exception ex) {
			return movie;
		}
		return movie;
	}
}
