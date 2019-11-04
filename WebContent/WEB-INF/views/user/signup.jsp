<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/user/signup" onsubmit="return checkForm()">
	<table>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="ut_name" id="ut_name"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="ut_id" id="ut_id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="ut_pwd" id="ut_pwd"></td>
		</tr>
		<tr>
			<th>비밀번호확인</th>
			<td><input type="password" name="utPwdCheck" id="utPwdCheck"></td>
		</tr>
		<tr>
			<th colspan="2"><button>회원가입</button></th>
		</tr>
	</table>
</form>
<script>
function checkForm()
{
	var utName = document.getElementById('utName');
	var utId = document.getElementById('utId');
	var utPwd = document.getElementById('utPwd');
	var utPwdCheck = document.getElementById('utPwdCheck');
	
	if(utName.value.trim().length < 2)
		{
			alert("이름은 두글자 이상입니다");
			utName.value = "";
			utName.focus();
			return false;
		}
	if(utId.value.trim().length < 5)
		{
			alert("아이디는 5글자 이상 작성해야 합니다");
			utId.value = "";
			utId.focus(); 
			return false;
		}
	
	if(utPwd.value.trim().length < 5)
	{
		alert("비밀번호는 5글자 이상 작성해야 합니다");
		utPwd.value = "";
		utPwd.focus(); 
		return false;
	}
	
	if(utPwd.value!=utPwdCheck.value)
	{
		alert("비밀번호를 잘못 입력하셨습니다.");
		utPwdCheck.value = "";
		utPwdCheck.focus(); 
		return false;
	}
	
	return true;
}

</script>
</body>
</html>