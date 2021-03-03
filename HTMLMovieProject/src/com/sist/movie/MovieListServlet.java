package com.sist.movie;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MovieDAO;
import com.sist.dao.MovieVO;

@WebServlet("/MovieListServlet")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out=response.getWriter();
	    // session을 가지고 온다 => 각 클라이언트당 한개만 생성 => request를 이용해서 생성 
	    //HttpSession session=request.getSession();// 세션을 가지고 온다 
	    String page=request.getParameter("page");
	    // 디폴트 설정 => page=1
	    if(page==null)
	    	page="1";
	    int curpage=Integer.parseInt(page); // 현재 보고 있는 페이지
	    // 총페이지 
	    MovieDAO dao=new MovieDAO();
	    int totalpage=dao.movieTotalPage();
	    // 해당 페이지에 해당되는 데이터 읽기
	    ArrayList<MovieVO> list=dao.movieListData(curpage);
	    
	    out.println("<html>");
	    out.println("<head>");
	    // CSS 사용 => 외부 CSS
	 	out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
	 	out.println("<style type=text/css>");
	 	// container(960px) , container-fluid(Full 화면)
	 	out.println(".row { width:960px;margin:0px auto;}");//<center>태그는 사용금지
	 	// <center> => margin:0px auto;
	 	out.println("h3{text-align:center}");
	 	out.println("</style>");
	    out.println("</head>");
	    out.println("<body>");
		/*
		 * out.println("<center>"); out.println("<h3>영화 목록</h3>");
		 * out.println("<h4>ID:"+session.getAttribute("id")+"</h4>");
		 * out.println("<h4>이름:"+session.getAttribute("name")+"</h4>");
		 * out.println("</center>");
		 */
	    out.println("<div style=\"height:50px\"></div>");
	    out.println("<div class=container>");
	    out.println("<div class=row>");
	    /*
	     *   <div class="col-md-4">
			    <div class="thumbnail">
			      <a href="/w3images/lights.jpg">
			        <img src="/w3images/lights.jpg" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p>Lorem ipsum...</p>
			        </div>
			      </a>
			    </div>
			  </div>
	     */
	    for(MovieVO vo:list)
	    {
	    	out.println("<div class=\"col-md-3\">");// 12가 되면 => 자동으로 밑으로 내려간다
	    	out.println("<div class=\"thumbnail\">");
	    	out.println("<a href=\"#\">");
	    	out.println("<img src=\""+vo.getPoster()+"\" class=img-rounded style=\"width:220;height:300px\">");
	    	out.println("<div class=\"caption\">");
	    	out.println("<p>"+vo.getTitle()+"</p>");
	    	out.println("</div>");
	    	out.println("</a>");
	    	out.println("</div>");
	    	out.println("</div>");
	    }
	    out.println("</div>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");
	}

}








