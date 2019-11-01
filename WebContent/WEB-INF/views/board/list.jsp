<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/header.jspf"%>
<%
if(user != null)
{
	%>
	<script>
	alert('환영합니다!');
	</script>
	<%
}
else
{
	%>
	<script>
	alert('로그인되어있지 않습니다');
	location.href='/views/index';
	</script>
	<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성날짜</th>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>
</body>
</html>