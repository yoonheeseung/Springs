<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<script src="./js/jquery.js"></script>
<script>
	function del_check() {
		if ($.trim($("#del_pwd").val()) == "") {
			alert("탈퇴 비번을 입력하세요!");
			$("#del_pwd").val("").focus();
			return false;
		}
		if ($.trim($("#del_cont").val()) == "") {
			alert("탈퇴 사유를 입력하세요!");
			$("#del_cont").val("").focus();
			return flase;
		}
	}
</script>
</head>
<body>
	<form method="post" action="mem_del_ok.do"
		onsubmit="return del_check();">
		<table align="center" border="1">
			<tr>
				<th colspan="2">회원탈퇴</th>
			</tr>
			<tr>
				<th>회원아이디</th>
				<td>${id}</td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td>${name}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="del_pwd" id="del_pwd"
					size="14" /></td>
			</tr>
			<tr>
				<th>탈퇴사유</th>
				<td><textarea name="del_cont" id="del_cont" rows="8" cols="32"></textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="탈퇴" /> <input
					type="reset" value="취소" onclick="$('#del_pwd').focus();" /></th>
			</tr>
		</table>
	</form>
</body>
</html>




