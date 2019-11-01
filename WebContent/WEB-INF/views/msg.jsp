<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%		//25.여기서도 url 에는 /views/* 형식으로 되어있으므로 URIController 를 다시 탐
String msg = (String)request.getAttribute("msg"); //아무 컨트롤러에게서 Attribute key 가 msg 인 것의 값을 String msg 변수에 저장
String url = (String)request.getAttribute("url"); //아무 컨트롤러에게서 Attribute key 가 url 인 것의 값을 String url 변수에 저장
%>		
<script>
	alert('<%=msg%>');	
	location.href='<%=url%>';	
</script>
</body>
</html>