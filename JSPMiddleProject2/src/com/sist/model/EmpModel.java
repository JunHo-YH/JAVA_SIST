package com.sist.model;
// 사용자 요청을 받아서 처리 => 처리결과값을 JSP로 전송(request)
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
public class EmpModel {
	public void empListData(HttpServletRequest request) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.empListData();
		request.setAttribute("list", list);
	}
}
