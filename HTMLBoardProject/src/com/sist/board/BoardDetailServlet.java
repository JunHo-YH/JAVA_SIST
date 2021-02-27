package com.sist.board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/BoardDetailServlet")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ���� Ÿ�� ����(HTML)
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter(); // ��û�� ����� �������� ����
		
		// ������ �ޱ�   /BoardDetailServlet?no=1
		String no=request.getParameter("no");
		// DAO���� 
		BoardDAO dao=new BoardDAO();
		BoardVO vo=dao.boardDetailData(Integer.parseInt(no));
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("td,th{font-family:���� ���;font-size:9pt;height:35px}");
		out.println(".table_main{border-collapse:collapse;");
		out.println("border-top-width: 2px;"
				+ "border-bottom-width: 1px;"
				+ "border-top-style: solid;"
				+ "border-bottom-style: solid;"
				+ "border-top-color: #333;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main th{");
		out.println("background-color: #999;"
				+ "color: #fff;"
				+ "border-bottom-width: 1px;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main td{");
		out.println("border-bottom-width: 1px;"
				+ "border-bottom-color: #666;"
				+ "border-bottom-style: dotted;}");
		out.println("a{color:black;text-decoration:none}");
		out.println("a:hover{color:green;text-decoration:underline}");
		out.println(".dataTr:HOVER {"
				+ "background-color: #FC6;"
				+ "cursor: pointer;"
				+ "cursor: hand;"
				+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		
		out.println("<h1>���뺸��</h1>");
		out.println("<table class=table_main width=600>");
		out.println("<tr>");
		out.println("<th width=20%>��ȣ</th>");
		out.println("<td width=30% align=center>"+vo.getNo()+"</td>");
		out.println("<th width=20%>�ۼ���</th>");
		out.println("<td width=30% align=center>"+vo.getRegdate().toString()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th width=20%>�̸�</th>");
		out.println("<td width=30% align=center>"+vo.getName()+"</td>");
		out.println("<th width=20%>��ȸ��</th>");
		out.println("<td width=30% align=center>"+vo.getHit()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th width=20%>����</th>");
		out.println("<td colspan=3>"+vo.getSubject()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=4 align=left valign=top style=\"height:200px\"><pre>"+vo.getContent()+"</pre></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=4 align=right>");
		out.println("<a href=#>����</a>&nbsp;");
		out.println("<a href=#>����</a>&nbsp;");
		out.println("<a href=BoardListServlet>���</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}







