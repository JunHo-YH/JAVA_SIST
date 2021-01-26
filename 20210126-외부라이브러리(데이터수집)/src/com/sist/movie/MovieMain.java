package com.sist.movie;

import java.io.*;
import java.util.*;
/*
 * 객체지향 프로그램
 * = 데이터 보호: 데이터는 감추고(은닉화:private) 메서드(public) 메서드를 이용해서 데이터에 접근 => 캡슐화
 * = 재사용
 *   1) 상속 (변경하거나 추가해서 사용) => extends => is-a
 *   단점: 상위 클래스를 메모리 할당=> 할당된메모리를 하위 클래스에 전송(속도가 늦다)
 *   재정의(오버라이딩): 오버라이딩 대상 메서드의 내용을 다 알고 있어야한다.
 *   상속은 예외(static:공유가 가능, 생성자, private: 사용할 수 없다)
 *   상속이 안되는 클래스: 종단클래스(final class)
 *   					java.lang.* (String,System,Math,
 *   2) 포함 (변경하지 않고 사용한다) => has-a
 * = 수정, 추가 용이하게 만든다.
 * 	 수정: 오버라이딩
 *   추가: 오버로딩
 *   =============================================================
 *   				 오버라이딩				오버로딩
 *   =============================================================
 *    상속여부       		O						X(같은 클래스내에 존재)
 *    메서드명				O						O
 *    매개변수				동일						다르다(데이터형, 개수)
 *    리턴형				동일						관계없다.
 *    접근지정어			동일, 크다					관계없다.
 *    ===========================================================
 *    접근지정어 크기
 *    ===========
 *    private < default < protected < public   
 *    
 *    class className{
 *    	일반변수: 한 개만 저장할 수 있는 공간
 *    	배열: 여러 개 저장 => 같은 데이터형
 *    	클래스: 여러 개 저장 => 다른 데이터형
 *    	메서드
 *    }
 */

class NewsVO {
	// 멤버변수 => 자동 초기화
	private int no; // 0
	private String title; // 모든 클래스는 null값으로 초기화 된다.
	private String content;
	private String poster;
	private String author;
	private String link;
	private MovieSystem ms;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}

class MovieSystem {
	int a;
	// 영화 관련 데이터 관리(영화 한 개에 대한 모든 정보를 가지고 있는 것이 관리하기 편하다)
	// 모든 user가 데이터를 공유 (데이터를 한 개만 사용한다) => 자바(static), 파일, 오라클
	private static NewsVO[] news = new NewsVO[300];
	// 클래스 영역 => 선언(제어문, 파일읽기 => 불가능)
	// ArrayList<NewsVO> news = new ArrayList<NewsVO>();
	// 파일 읽기, 오라클 읽기
	/*
	 * 멤버변수 => 초기화 = 생성자: 인스턴스 변수 = 초기화 블럭: static => 자동으로 처리
	 */
	static {
		try {
			FileReader fr = new FileReader("c:\\javaDev\\daum_news.txt");
			StringBuffer sb = new StringBuffer();
			int i = 0;
			while ((i = fr.read()) != -1) {
				sb.append(String.valueOf((char) i));
			}
			fr.close();
			System.out.println(sb);//sb.toString()
			// 배열에 저장
			String[] data = sb.toString().split("\n");
			for (String s : data) {
				System.out.println(s);
				StringTokenizer st = new StringTokenizer(s,"^");
				news[i].setNo(Integer.parseInt(s));
			}
		} catch (Exception ex) {

		}
	}

}

public class MovieMain {
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		NewsVO[] news = ms.new
	}

}
