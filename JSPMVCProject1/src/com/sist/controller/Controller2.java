package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;
/*
 * interface A {
 * 	public void dsplay();
 * }
 * class B implements A {
 * 	public void dsplay() {
 * 		
 * 	}
 * }
 */
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map clsMap = new HashMap();
	private String[] strCls= {
		"com.sist.model.DeleteModel",
		"com.sist.model.UpdateModel",
		"com.sist.model.DetailModel",
		"com.sist.model.ListModel"
			
	};
	private String[] strCmd = {"delete", "update", "detail", "list"};
    @Override
	public void init(ServletConfig config) throws ServletException {
    	/*
    	clsMap.put("list", new ListModel());
    	// Model model = new ListModel();
    	clsMap.put("update", new UpdateModel());
    	clsMap.put("delete", new DeleteModel());
    	clsMap.put("detail", new DetailModel());
    	*/
    	try {
    		int i = 0;
    		for(String cls:strCls) {
    			Class clsName = Class.forName(cls);
    			Object obj = clsName.newInstance();
    			clsMap.put(strCmd[i], obj);
    			i++;
    		}
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }

	public Controller2() {
    }
	// http://localhost/JSPMVCProject1/list.do
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		// JSPMVCProject1/list.do
		cmd = cmd.substring(cmd.lastIndexOf("/")+1,cmd.lastIndexOf("."));
//		System.out.println(cmd);
		Model model = (Model)clsMap.get(cmd);
		model.handlerRequest(request);
		RequestDispatcher rd = request.getRequestDispatcher("view/"+cmd+".jsp");
		rd.forward(request, response);
		
		
	}

}
