<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Date time = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String sessionId = session.getId();
Long creTim = session.getCreationTime();
time.setTime(creTim);
String cre = sdf.format(time);
Long modTim = session.getLastAccessedTime();
time.setTime(modTim);
String mod = sdf.format(time);
%>
ID : <%=sessionId%><br>
CREATE : <%=cre%><br>
MODIFY : <%=mod%>
</body>
</html>