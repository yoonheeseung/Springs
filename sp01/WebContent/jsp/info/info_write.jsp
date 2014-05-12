<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 1단계 연습</title>
<script src="./js/jquery.js"></script>
<script src="./js/info.js"></script>
</head>
<body>
	<form method="post" action="info_write_ok.do" onsubmit="return check()">
		<table align="center" border="1">
			<tr>
				<th colspan="2">스프링 연습</th>
			</tr>
			<tr>
				<th>이름</th>
				<td><input name="name" id="name" size="14" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" id="addr" size="36" /></td>
			</tr>
			<tr>
				<th colspan="2">
				<input type="submit" value="저장" /> 
				<input type="reset" value="취소" />
				</th>
			</tr>
		</table>
	</form>
</body>
</html>