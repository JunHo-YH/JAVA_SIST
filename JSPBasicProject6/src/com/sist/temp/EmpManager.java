package com.sist.temp;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.temp.*;
public class EmpManager {
  public void empListData(HttpServletRequest request)
  {
	  EmpDAO dao=new EmpDAO();
	  List<EmpVO> list=dao.empListData();
	  request.setAttribute("list", list);
  }
}
