<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center; align:center">
welcome!<br>
<%
if(user == null)
{
	%>
	<a href="/views/user/login"><button>로그인 화면으로 가기</button></a>
	<a href="/views/user/signup"><button>회원가입 하기</button></a>
	<a href="/views/board/list"><button>게시판 가기</button></a>
	<%
}
else
{
	%>
	
	<a href="/views/board/list"><button>게시판 가기</button></a> 
	<%
}
%>
<!-- 1.이 버튼을 클릭시 /views/*형식을 통해 web.xml이 URIController 를 통해 URI 를 변경(/WEB-INF/views/user/login.jsp - 이런식으로) WEB-INF로의 접근을 하기 위해 -->
</body>
</html>