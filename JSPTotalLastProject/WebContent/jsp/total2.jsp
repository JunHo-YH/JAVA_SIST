<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	model2 (MVC)
	표현식: EL
			${}
			${값} => 자바의 일반 변수가 아니다.
			====
			 request.getAttribute(): 우선순위
			 session.getAttribute(): 2번째 순위
			 applicaton.getAttribute(): 3번째 순위
			 
			 형식)
			 	request.setAttribute("a1", "aaa1") ==> 키가 같으면 request가 session보다 우선순위다.
			 	session.setAttribute("a2", "aaa2")
			 	${a1} => aaa1
			 	${requestScope.a} => <% request.getAttribute("a")%>
				${sessionScope.a2} => aaa2
				${a2} ==> 키가 다르면 sessionScope를 생략하고 적을 수 있다. (구분이 가능하기 때문)
				
			연산자
				산술연산자 (산술만 처리)
				${"1"+"2"} => 3
				${"1"+null} => 1 (null은 0으로 취급)
				${"1" + "a"} => 오류
				${"1" += "a"} => 1a
				${"1" += "2"} => 12
				
				${3/2} => 1.5 (실수로 계산)
			
			객체호출
				${vo.title} => ${vo.getTitle()}
				
	292page JSTL
		core: 제어문, UTL, 변수설정
			<c:if>: 조건문
			<c:forEach>: 반복문
			<c:choose>: 다중 조건문
			<c:redirect>: sendRedirect()
			<c:set>: request.setAttribute()
		fmt: 변환(숫자, 날짜): 날짜변환
				<fmt:foramtDate value="" pattern="yyyy-MM-dd">
				SimpleDateFormat()
				<fmt:formatNumber value="" pattern="000,000">
		fn: String메서드				
			${fn:substring(값, 0, 10)}
			
	14장(데이터베이스),18장(MVC) 정독하기
			
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