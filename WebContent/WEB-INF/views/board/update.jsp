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
<form method="post" action="/board/updateok">
<table border="1">
	<tr>
		<th>작성자</th>
		<td>${board.ut_name}</td>
	</tr>
	<tr>
		<th>번호</th>
		<td><input type="number" name="bt_num" value="${board.bt_num}"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="bt_title" id="bt_title" value="${board.bt_title}"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td width="300" height="300"><textarea style="width:100%;height:100%" name="bt_content" id="bt_content">${board.bt_content}</textarea></td>
	</tr> 
	<tr>
		<th>작성날짜</th>
		<td>${board.credat}</td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td>${board.cretim}</td>
	</tr>
		<th><button>수정완료</button></th> 
	</tr>
</table>
</form>
</body>
</html>