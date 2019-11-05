<%@page import="java.util.List"%>
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
<table style="margin:auto; text-align:center">
	<tr>
		<th>번호</th>
		<th width="500">제목</th>
		<th>작성자</th>
		<th>작성날짜</th>
		<th>작성시간</th>
		<th>수정날짜</th>
		<th>수정시간</th>
	</tr>
	<%
	if(request.getAttribute("list") == null)
	{
		out.println("<tr><td colspan=\"4\">게시물이 없습니다.</td></tr>");
	}
	else
	{
		List<Map<String,String>> btList = (List<Map<String,String>>)request.getAttribute("list");
		for(Map<String,String> board : btList)
		{
		%>
		<tr>
			<td><%=board.get("bt_num")%></td>
			<td><a href="/views/board/content?bt_num=<%=board.get("bt_num")%>"><%=board.get("bt_title")%></a></td>
			<td><%=board.get("ut_num")%></td>
			<td><%=board.get("credat")%></td>
			<td><%=board.get("cretim")%></td>
			<td><%=board.get("moddat")%></td>
			<td><%=board.get("modtim")%></td>
		</tr>
		<%
		}
	}
	%>
	<tr>
		<td colspan="7" align="right"><a href="/views/board/insert"><button>글쓰기</button></td>    
	</tr>
</table>
</body>
</html>