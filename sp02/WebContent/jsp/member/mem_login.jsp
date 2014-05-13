<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<script src="./js/jquery.js"></script>
<script src="./js/login.js"></script>
</head>
<body>
	<form method="post" action="mem_login_ok.do"
		onsubmit="return login_check()">
		<table align="center" border="1">
			<tr>
				<th colspan="3">로그인폼</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="login_id" id="login_id" size="14" />
				</td>
				<th rowspan="2"><input type="submit" value="로그인" /></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="login_pwd" id="login_pwd"
					size="14" /></td>
			</tr>
			<tr>
				<th colspan="3"><input type="button" value="회원가입"
					onclick="location='mem_join.do'" /></th>
			</tr>
		</table>
	</form>
</body>
</html>