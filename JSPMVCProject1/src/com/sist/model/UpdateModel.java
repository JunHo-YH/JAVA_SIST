package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class UpdateModel implements Model {
	public void handlerRequest(HttpServletRequest request) {
		String msg = "사원 수정입니다.";
		request.setAttribute("msg", msg);
	
	}
}
