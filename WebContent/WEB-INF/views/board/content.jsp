<%@page import="java.util.List"%>
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
<%
Map<String,String> bMap = (Map<String,String>)request.getAttribute("list");
%>
<form method="post">
<table>
	<tr>
		<th width="800">제목</th>
		<td><input type="text" name="bt_title" id="bt_title"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=user.get("ut_name")%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="bt_content" id="bt_content"></textarea></td>
	</tr>
	<tr>
		<th><button>수정완료</button></th>
	</tr>
</table>
</form>
</body>
</html>