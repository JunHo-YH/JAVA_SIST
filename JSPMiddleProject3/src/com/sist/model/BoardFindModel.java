package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class BoardFindModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String msg = "데이터 찾기";
		request.setAttribute("msg", msg);
		
		
		return "board/find.jsp";
	}

}
