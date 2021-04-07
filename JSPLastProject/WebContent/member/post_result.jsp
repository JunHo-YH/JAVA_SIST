<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
function ok(zip,addr)
{
	parent.join_frm.post.value=zip;
	parent.join_frm.addr1.value=addr;
	parent.Shadowbox.close();
}
</script>
</head>
<body>
   <table class="table">
    <tr>
      <th class="text-center">우편번호</th>
      <th class="text-center">주소</th>
    </tr>
    <c:forEach var="vo" items="${list }">
      <tr>
        <td class="text-center">${vo.zipcode }</td>
        <td><a href="javascript:ok('${vo.zipcode }','${vo.address }')">${vo.address }</a></td>
      </tr>
    </c:forEach>
   </table>
</body>
</html>







