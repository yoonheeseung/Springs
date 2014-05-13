<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="./js/jquery.js"></script>
<script src="./js/login.js"></script>
</head>
<body>
	<form method="post" action="mem_join_ok.do"
		onsubmit="return join_check();">
		<table align="center" border="1">
			<tr>
				<th colspan="2">회원가입폼</th>
			</tr>
			<tr>
				<th>회원아이디</th>
				<td><input name="mem_id" id="mem_id" size="14" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="mem_pwd" name="mem_pwd"
					size="14" /></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" id="mem_pwd2" name="mem_pwd2"
					size="14" /></td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td><input name="mem_name" id="mem_name" size="12" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="mem_addr" id="mem_addr" size="36" /></td>
			</tr>
			<tr>
				<th>폰번호</th>
				<td><select name="mem_phone01">
						<c:forEach var="ph" items="${p}">
							<option value="${ph}">${ph}</option>
						</c:forEach>
				</select>-<input name="mem_phone02" id="mem_phone02" size="4" maxlength="4" />-<input
					name="mem_phone03" id="mem_phone03" size="4" maxlength="4" /> <%--입력박스에 maxlength로 지정하면 최대 4자까지만 입력 가능하다. --%>
				</td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="회원가입" /> <input
					type="reset" value="가입취소" onclick="$('#mem_id').focus();" /></th>
			</tr>
		</table>
	</form>
</body>
</html>