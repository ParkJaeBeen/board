<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user/user">
	번호 : <input type="text" name="ut_num"><br>
	ID : <input type="text" name="ut_id"><br>
	이름 : <input type="text" name="ut_name"><br>
	<button>검색</button>
</form>
<table>
	<tr>
		<th>번호</th>
		<th>ID</th>
		<th>이름</th>
	</tr>
<c:forEach var="user" items="${list}">
	<tr>
		<td>${user.ut_num}</td>
		<td>${user.ut_id}</td>
		<td>${user.ut_name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>