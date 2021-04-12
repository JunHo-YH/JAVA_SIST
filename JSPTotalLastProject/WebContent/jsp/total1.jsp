<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1.웹프로그램 실행을 위한 구성요소(38p)
	  1)웹 브라우저: 클라이언트 영역
	  2)웹 서버: 서버(요청을 받고 결과값 응답하는 역할)
	  			번역이 필요없는 파일 요청시 브라우저에서 실행이 가능
	  			HTML, XML, CSS, JavaScript
	  			=> Java, C#, Python는 반드시 컴파일을 시켜야 한다 => WAS필요
	  3)웹 어플리케이션 서버(WAS): 번역 => HTML, XML로 변환
	  				=> 톰캣, 레진(자바 번역기), IIS 
	  4)데이터베이스: 오라클 => 웹 사이트에 필요한 데이터를 저장하는 장소
	  					
	  					자바번역
	  웹브라우저 ===> 웹서버 ===> WAS ===> 오라클
	  		  <===      HTML변환  <===  
	  /main.jsp
	  /main.do
	  /main.html => 직접 처리
	  
	  1. URL => 웹에서는 반드시 마지막에 파일명을 전송
	     /main.do => 서블릿을 찾아라(DispatcherServlet)
	     
	     page 37
	     ===> 웹은 거의 대부분이 Map
	          map("localhost","211.238.142.196")
	     http://localhost(IP,Domain)/JSPTotalLastProject/jsp/total1.jsp
	  	=====  ===================   ====================================
	  	프로토콜    서버주소                          URI
	  								====================
	  								ContextPath
	  	======================================================================== URL
	  	
	  	다른 파일로 데이터 전송
	  	main.jsp?no=1
	  	두 개를 전송
	  	main.jsp?no=1&page=1 => &로 구분
	 =======================================================================================
	 
	 page 51,56
	 1. page지시자
	 	ContentType = ""
	 	 => JSP를 변환할 때 (브라우저: XML, HTML) => 브라우저에서는 XML, HTML외의 모든 것은 txt
	 	 	HTML => text/html;charset=UTF-8
	 	 	XML  => text/xml;charset=UTF-8
	 	errorPage="" : 오류가 났을 경우 파일 이동 (error파일 출력)
	 		404: 요청판 파일이 없는 경우
	 		500: 자바 번역에서 오류가 나는 경우
	 		415: 스프링에서 등장 => 데이터명이 틀릴 경우
	 			 main.do?no=1&page=1
	 			 public String main_list(int page, BoardVO vo)
	 		200: 정상수행
	 		200
	 	import=""
	 		=> import="패키지.*"
	 		=> import="패키지.*"
	 		=> import="패키지.*"
	 		=> import="패키지.*,패키지.*,패키지.*"
	 	buffer="16kb"
	 		=> JSP번역 => Java => 컴파일 => .class => 실행 => HTML만 출력한다.
	 		   출력하는 위치를 Buffer(메모리 공간) => 저장된 HTML을 브라우저가 읽어서 출력
	 		   기본 8kb (one page) => 증가가 가능하게 만들었다. => 최대 32kb
	 		   (framework: spring, struts, jfs, 마이플랫폼)
	 	
	 	page 65 ~ 72
	 	JSP => 자바+HTML
	 	자바 영역
	 		<% %>: 스크립트릿 => 일반 자바 코딩, 변수 선언, 제어문, 연산자, 기타 로직
	 		<%= %>: 표현식 => 브라우저에 출력
	 		<%! %>: 선언식 => 메서드를 만들 경우 => 자바를 이용해서 만든다 (import => 호출) => 거의 사라짐(보안문제가 있음)
	 	HTML 영역
	 		   
	 		   
	 	
	 
	  
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>