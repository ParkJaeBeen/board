<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th></th>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<c:forEach var="list" items="${list}">
	<tr>
		<td>${list.num}</td>
		<td>${list.name}</td>
		<td>${list.age}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>