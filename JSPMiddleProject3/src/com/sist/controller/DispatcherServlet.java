package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
// 생성자: 메모리 할당 => init(): web.xml의 데이터 => service(): 사용자 요청 처리 => destroy(): 메모리 해제

/*
 * class A {
 * 
 * }
 * class B {
 * 
 * }
 * class C {
 * 
 * }
 * class Container {
 * 
	 * 	public Container() {
	 * 		Map map = new HashMap();
	 * 		public Container() {
	 * 			map.put("a", new A());
	 * 			map.put("b", new B());
	 * 			map.put("c", new C());
	 * 		}
	 * }
	 * public Object getBean(String key) {
	 * 	return map.get(key)
	 * }
	 * 
	 * A a = (A) getBean("a");
 * 
 * }
 * 
 */
class A {
	public void display() {
		System.out.println("Hello world");
	}
}
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 클래스를 저장하는 위치
	private Map clsMap = new HashMap();
    
    public DispatcherServlet() {

    
    }
    
   

	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("contextConfigLocation");
//		System.out.println(path);
		try {
			// XML을 읽어온다.
			//Factory 패턴 => 한번만 생성 => 싱글턴
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder db = dbf.newDocumentBuilder(); // 파싱기 => 데이터 가져오는 것. => xml에서 데이터를 가지고 오겠다.
			Document doc = db.parse(new File(path));//파싱 끝 // Document: 문서를 저장하는 공간
			
			// table 읽기(applicationContext.xml파일)
			Element beans = doc.getDocumentElement();
			System.out.println("root:" + beans.getTagName());
			NodeList list = beans.getElementsByTagName("bean"); // bean태그 모으기
			for(int i = 0; i< list.getLength(); i++) {
				Element bean = (Element)list.item(i); // 태그 읽어오기
				String id = bean.getAttribute("id");
				String cls = bean.getAttribute("class");
				System.out.println("확인=======ID:" + id + ",class:" + cls);
				
				Class clsName = Class.forName(cls); // 클래스 (이름)정보 읽기 => 클래스 전체를 제어
				Object obj = clsName.getDeclaredConstructor().newInstance(); // 클래스 이름으로 메모리 할당, 메서드 호출 가능, 변수 값 설정 가능, 생성자 제어 가능
																			// 리플렉션
				
				System.out.println("ID:"+id+",메모리:" + obj);
				clsMap.put(id, obj);
			}
			
			Class clsName = Class.forName("com.sist.controller.A");
			Object obj = clsName.getDeclaredConstructor().newInstance(); // new A()
			Method[] method = clsName.getDeclaredMethods();
			method[0].invoke(obj, null);
			
		}catch(Exception ex) {
			
		}
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		cmd = cmd.substring(cmd.lastIndexOf("/")+1, cmd.lastIndexOf("."));
		Model model = (Model)clsMap.get(cmd); // 클래스(모델) 찾기
		
		// 메서드 호출
		String jsp = model.execute(request);
		
		// 지정된 JSP에 request 전송
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
