package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class BoardInsertModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		String msg = "게시판 데이터 추가";
		request.setAttribute("msg", msg);
		
		
		return "board/insert.jsp";
	}
	
}
