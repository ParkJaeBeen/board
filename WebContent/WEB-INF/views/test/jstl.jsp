<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<%
int[] intArray = new int[5];
for(int i=0;i<intArray.length;i++)
{
	intArray[i] = i+1;
}
Map<String,Integer> map = new HashMap<>();
map.put("i",intArray[2]);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="str" value="abd"/>
<c:if test="${str eq 'abc'}">
str == abc
</c:if>
<c:if test="${str ne 'abc'}">
str != abc
</c:if>
<c:choose>
	<c:when test="${str == 'abc'}">
	true
	</c:when>
<%--<c:when test="${str != 'abc'}">
	false
	</c:when> --%>
	<c:otherwise>
	otherwise<br>
	</c:otherwise>
</c:choose>
<%=map.get("i")%>
<c:forEach var="i" begin="1" end="10">
	${i}<br>
</c:forEach>
<c:forEach var="i" begin="1" end="10" step="2">
	${i}<br>
</c:forEach>
<c:forEach var="i" items="${intArray}" begin="2" end="4">
[${i}]
</c:forEach>
</body>
</html>