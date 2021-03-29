package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
//		System.out.println(cmd);
		cmd=cmd.substring(cmd.lastIndexOf("/")+1);
//		System.out.println(cmd);
		String jsp = "";
		if(cmd.equals("list.do")) {
			ListModel model = new ListModel();
			model.handlerRequest(request);
			jsp = "list.jsp";
		}
		else if(cmd.equals("update.do")) {
			UpdateModel model = new UpdateModel();
			model.handlerRequest(request);;
			jsp = "update.jsp";
		}
		else if(cmd.equals("delete.do")) {
			DeleteModel model = new DeleteModel();
			model.handlerRequest(request);
			jsp = "delete.jsp";
		}
		else if(cmd.equals("detail.do")) {
			DetailModel model = new DetailModel();
			model.handlerRequest(request);
			jsp = "detail.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("view/"+jsp);
		rd.forward(request, response); // 해당 JSP로 request를 전송
	}

}
