package com.sist.temp;

import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FoodManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Document doc=Jsoup.connect("https://www.mangoplate.com/restaurants/9qHLgnJtje").get();
        	//Element addr=doc.selectFirst("table.info td");
        	//System.out.println(addr.text());
        	Element json=doc.selectFirst("script#reviewCountInfo");
        	System.out.println(json.data());
        	String s=json.data();
        	JSONParser jp=new JSONParser();
        	JSONArray arr=(JSONArray)jp.parse(s);
        	for(int i=0;i<arr.size();i++)
        	{
        		JSONObject obj=(JSONObject)arr.get(i);
        		System.out.println(obj.get("count"));
        	}
        	Elements menu=doc.select("table.info td.menu_td");
        	String m="";
        	for(int i=0;i<menu.size();i++)
        	{
        		m+=menu.get(i).text();
        	}
        	StringTokenizer st=new StringTokenizer(m,"원");
        	while(st.hasMoreTokens())
        	{
        		System.out.println(st.nextToken());
        	}
        	System.out.println(m);
        }catch(Exception ex) {}
	}

}








