package com.sist.model;

import javax.servlet.http.HttpServletRequest;
/*			     요청					해당 Model로 request 전송
 * 	클라이언트 ===========>  Controller ============================> Model
 *			<========== 					<=============
 * 				JSP						결과값을 request에 담는다.
 * 			request에 설정한 결과값을 받아서 JSTL, EL을 이용해서 출력
 */
public class DetailModel implements Model {
	public void handlerRequest(HttpServletRequest request) {
		String msg = "이름:홍길동,부서:개발부,급여:3000,근무지:서울";
		request.setAttribute("msg", msg);
	
	}

}
