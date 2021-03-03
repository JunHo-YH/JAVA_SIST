package com.sist.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/BoardInsertServlet")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet => ȭ�� ���
		// 1. HTML�� �������� ���� (��=> INSERT, UPDATE, DELETE, SELECT)
		response.setContentType("text/html;charset=EUC-KR");
		// 2. �ش� Ŭ���̾�Ʈ�� ����'
		PrintWriter out = response.getWriter();
		// doGet, doPost => Thread
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
				out.println("IP:"+request.getRemoteAddr());
				out.println("<h1>�۾���</h1>");
				// �Էµ� ��� �����͸� doPost�� ���� = <form>
				out.println("<form method=post action=BoardInsertServlet autocomplete=off>");
				// �Է�â�� �̿��ؼ��۾��Ⱑ �����ϰ� ������ش�.
				
				// �̸� �Է�
				out.println("<table class=table_main width=600>");
				out.println("<tr>");
				out.println("<th width=20% align=right>�̸�</th>");
				out.println("<td width=80%>");
				out.println("<input type=text name=name size=15>");
				out.println("</td>");
				out.println("</tr>");
				
				// ���� �Է�
				out.println("<tr>");
				out.println("<th width=20% align=right>����</th>");
				out.println("<td width=80%>");
				out.println("<input type=text name=subject size=50>");
				out.println("</td>");
				out.println("</tr>");
				
				// ���� �Է�
				out.println("<tr>");
				out.println("<th width=20% align=right>����</th>");
				out.println("<td width=80%>");
				out.println("<textarea rows=10 cols=55 name=content></textarea>");
				out.println("</td>");
				out.println("</tr>");
				
				// ��й�ȣ �Է�
				out.println("<tr>");
				out.println("<th width=20% align=right>��й�ȣ</th>");
				out.println("<td width=80%>");
				out.println("<input type=password name=pwd size=15>");
				out.println("</td>");
				out.println("</tr>");
				
				
				out.println("<tr>");
				out.println("<td colspan=2 align=center>");
				out.println("<input type=submit value=�۾���>");
				out.println("<input type=button value=��� onclick=\"javascript:history.back()\">");
				out.println("</td>");
				out.println("</tr>");
				
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doPost => ����� �Է°��� �޾Ƽ� DAO ����
		// ����ڰ� ���� ������ �ޱ�
		try {
			request.setCharacterEncoding("EUC-KR"); // ���ڵ�
		} catch(Exception ex) {
			
		}
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		System.out.println("�̸�:" + name);
		System.out.println("����:" + subject);
		System.out.println("����" + content); 
		System.out.println("��й�ȣ" + pwd);
		
		// DAO�� ����
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		dao.boardInsert(vo);
		
		// ������� �̵�
		response.sendRedirect("BoardListServlet"); //INSERT�� �Ǹ� ȭ�� �̵��ϵ��� ����
	}

}
