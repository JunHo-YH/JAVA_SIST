package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class ListModel implements Model {
	public void handlerRequest(HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("심청이");
		list.add("박문수");
		list.add("이순신");
		list.add("강감찬");
		
		//클라이언트로 전송 => JSP
		request.setAttribute("list", list); // 데이터 추가
	}
}
