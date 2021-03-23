package com.sist.dao;

import org.jsoup.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FoodManager {
	public void foodCategoryData() {
		try {
			int k =1;
			// 연결 => 소스 읽기
			Document doc = Jsoup.connect("https://www.mangoplate.com/").get();
			System.out.println(doc);
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		FoodManager fm = new FoodManager();
		fm.foodCategoryData();
	}
	
}
