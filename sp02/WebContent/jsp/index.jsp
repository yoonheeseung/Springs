<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<form method="post" action="logout.do">
		<table align="center" border="1">
			<tr>
				<th>
				    <input type="button" value="정보수정" onclick="location='mem_edit.do'" /> 
					<input type="button" value="회원탈퇴" onclick="location='mem_del.do'" />
					<input type="submit" value="로그아웃" />
			   </th>
			</tr>
			<tr>
				<th>${name}님 로그인을 환영합니다!</th>
			</tr>
		</table>
	</form>
</body>
</html>