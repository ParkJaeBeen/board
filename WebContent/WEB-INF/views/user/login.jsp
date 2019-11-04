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
<form method="post" action="/user/login">	<!-- 2.index.jsp 에 있는 버튼을 통해 /WEB-INF/views/user/login.jsp 경로인 이 jsp 파일로 이동 -->
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name="ut_id" id="ut_id"></td>	<!-- 3.input 타입을 정해놓고 값을 받아옴-->
		</tr>
		<tr>
			<th>Pwd</th>
			<td><input type="password" name="ut_pwd" id="ut_pwd"></td>
		</tr>
		<tr>
			<th colspan="2"><button>로그인</button></th>	<!-- 4.로그인을 클릭,엔터 시 web.xml 의 /user/* 형식에 따라 UserController로 가게 됨 -->
		</tr>
	</table>
</form>
</body>
</html>