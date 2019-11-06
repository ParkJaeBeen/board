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
<table border="1">
	<tr>
		<th>작성자</th>
		<td>${board.ut_name}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${board.bt_title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td width="300" height="300">${board.bt_content}</td>
	</tr>
	<tr>
		<th>작성날짜</th>
		<td>${board.credat}</td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td>${board.cretim}</td>
	</tr>
	<tr>
		<th colspan="2">
		<button onclick="goPage('/board/list')">리스트 가기</button>
		<c:if test="${user.ut_num == board.ut_num}">
		<button onclick="goPage('/board/update?bt_num=${board.bt_num}')">수정하기</button></a>
		<button onclick="goPage('/board/delete?bt_num=${board.bt_num}')">삭제하기</button></a>
		</c:if>
		</th>
	</tr>
</table>
<script>
function goPage(url)
{
	location.href = url;
}

</script>
</body>
</html>