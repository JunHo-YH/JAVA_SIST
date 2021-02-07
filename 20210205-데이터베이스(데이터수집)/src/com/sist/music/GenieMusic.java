package com.sist.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *     Oracle ���� (����Ŭ : �����ͺ��̽� (�����͸� �����ϴ� ��� => ������ ����)
 *     1. �������� 
 *        ������ 
 *         NUMBER(10) , NUMBER(7,2)
 *         ==========   ===========
 *           int           double
 *        ������
 *         CHAR , VARCHAR2 , CLOB => String 
 *        ��¥�� 
 *         DATE => Date
 *     ===> int , double , String , Date
 *     2. �����͸� ��Ƽ� ���� 
 *        ArrayList => ���׸��� (�������� ����)
 *     3. Connection , Statement , ResultSet
 *     4. ����ó�� 
 *    ========================================
 */
// �� ũ�Ѹ� 
public class GenieMusic {
    public void getGenieMusic()
    {
    	try
    	{
    		int k=1;
            for(int i=1;i<=2;i++)
            {
            	//Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20210205&hh=17&rtm=Y&pg="+i).get();
            	Document doc=Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20210204&genrecode=M0100&pg="+i).get();
            	// title , singer , album , poster , state , idcrement, rank
            	Elements title=doc.select("tr.list a.title");// <a class="title">
            	Elements singer=doc.select("tr.list a.artist");
            	Elements album=doc.select("tr.list a.albumtitle");
            	Elements poster=doc.select("tr.list a.cover img");
            	Elements etc=doc.select("tr.list span.rank");
            	for(int j=0;j<title.size();j++)
            	{
            		System.out.println("����:"+k++);
            		System.out.println("����:"+title.get(j).text());
            		System.out.println("����:"+singer.get(j).text());
            		System.out.println("�ٹ�:"+album.get(j).text());
            		System.out.println("������:"+poster.get(j).attr("src"));
            		String str=etc.get(j).text();
            		// ����
            		// 2�ϰ�
            		// 1���
            		String state=str.replaceAll("[^��-�R]", "");// �ѱ��� �����ϰ� �������� ����  
            		String id="";
            		if(state.equals("����"))
            		{
            			id="0";
            		}
            		else
            		{
            			id=str.replaceAll("[^0-9]", ""); //1
            		}
            		
            		System.out.println("����:"+state);
            		System.out.println("����:"+id);
            		//System.out.println("����:"+etc.get(j).text());
            		System.out.println("=============================================");
            	}
            }
    	}catch(Exception ex){ex.printStackTrace();}
    }
	public static void main(String[] args) {
        GenieMusic gm=new GenieMusic();
        gm.getGenieMusic();
	}

}







