package com.sist.main;
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("moiveAllData", "SELECT * FROM movie");
		map.put("movieDetailData", "SELECT * FROM movie WHERE mno = 1");
		map.put("movieDelete", "DELETE FROM movie WHERE mno = 1");
		
		System.out.println(map.get("moiveAllData"));
		System.out.println(map.get("movieDelete"));
	
	
	}

}
