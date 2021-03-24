package com.sist.temp;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.temp.*;
public class EmpManager {
	public void empListData(HttpServletRequest request)
	{
		EmpDAO dao=new EmpDAO();
		List<EmpVO> list=dao.empListData();
		request.setAttribute("list", list); // 뒤에 있는 list를 보낼려고한다 (134p 135p)
	}

}
