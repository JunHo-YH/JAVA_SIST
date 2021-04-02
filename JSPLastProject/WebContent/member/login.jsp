<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
	width:300px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div style="height: 20px"></div>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<th width=30% class="text-right danger">ID</th>
					<td width=70%>
						<input type=text name =id size=15 class="input-sm">
					</td>
				</tr>
				<tr>
					<th width=30% class="text-right danger">Password</th>
					<td width=70%>
						<input type=password name =pwd size=15 class="input-sm">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="button" value="로그인" class="btn btn-sm btn-success">
						<input type="button" value="취소" class="btn btn-sm btn-info">
						
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>