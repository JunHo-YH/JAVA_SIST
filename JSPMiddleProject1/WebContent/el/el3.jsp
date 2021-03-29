<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	연산자 out.println(1+1)
	산술연산자 9 - * / (div), %(mod)
		${10 + - * / % 10}, ${10 div 10}, ${10 mod 10}
		
		${10 / 3} => 3.3333     5/2 => 2.5 => 실수(Double)로 연산된다.
		${"10"+"10"} => 1010(X) => 20
			${"10" += "10"} => 1010 => 문자열 결합
			${10+null} => null(0) => 10
	비교연산자
		== (eq), != (ne), <(lt), >(gt), <=(le), >=(ge)
		${"aaa" == "aaa"}
		${"aaa" eq "aaa"}
		${10 != 20} => ${10 ne 20} => true / false
	논리연산자
	&& => and
	|| => or		=> true/ false
	
	empty 연산자
		=> 값이 없는 경우 ${empty 값}
	삼항연산자
		=> 조건 ? 값 : 값
	문자열결합
		=> +=
	
	
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