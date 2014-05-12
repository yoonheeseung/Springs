<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 목록연습</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th colspan="3">스프링 목록</th>
		</tr>
		<tr>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
		</tr>
		<c:if test="${!empty list}">
			<c:forEach var="ib" items="${list}">
				<tr>
					<th>${ib.name}</th>
					<th>${ib.addr}</th>
					<th>${ib.regdate}</th>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty list}">
			<tr>
				<th colspan="3">목록이 없습니다!</th>
			</tr>
		</c:if>
	</table>
</body>
</html>