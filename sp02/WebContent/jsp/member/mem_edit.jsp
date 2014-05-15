<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
<!-- <script src="./js/jquery.js"></script>
<script src="./js/login2.js"></script> -->
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/login2.js"></script>
</head>
<body>
	<form method="post" action="mem_edit_ok.do"
		onsubmit="return edit_check();">
		<table align="center" border="1">
			<tr>
				<th colspan="2">정보 수정</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${id}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mem_pwd" id="mem_pwd"
					size="14" /></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="mem_pwd2" id="mem_pwd2"
					size="14" /></td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td><input name="mem_name" id="mem_name" size="14"
					value="${dm.mem_name}" /></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input name="mem_addr" id="mem_addr" size="50"
					value="${dm.mem_addr}" /></td>
			</tr>
			<tr>
			<th>번호</th>
			<td>
			<%-- <c:forEach var="p" items="${ph}">
			   ${p}
			  </c:forEach>
			  </td>
			   --%>
			<tr>
				<th>폰번호</th>
				<td><select name="mem_phone01">
						<%-- <c:forEach var="p" items="${p}">
						<c:if test="${p==ph}" >
						   <option value="${ph}" selected="${ph}">${p}</option>
						</c:if>
						<option value="${p}">${p}</option>
						</c:forEach> --%>
						
				<%-- <c:forEach var="p" items="${p}">
				<option value="${p}" <c:if test="${dm.mem_phone01==p}">
				                           ${'selected'}
				                     </c:if>
				 >${p}</option>
				</c:forEach> --%>
				
				<c:forEach var="p" items="${p}">
				<option value="${p}" 
				<c:if test="${ph==p}">
				            ${'selected'}
				</c:if>
				 >${p}</option>
				</c:forEach>
						
						
						
			 <!--  과제물
			   1. MemEditAction.java에 폰번호 문자열 배열객체 phone을 만드세요.
			      이 phone을 ph키 값에 저장하시고, mem_edit.jsp에서 JSTL로 이 키값을 참조하여 
			     c:forEach반복문으로 폰번호 목록을 출력하시면 됩니다.
			   2.디비에 저장된 예를 들어) 019를 가져와 c:if 문을 사용하여 반복문내에서 해당 폰번호가 선택이 되어져야 합니다.(selected속성사용)
			   3.login.js파일에서 edit_check() 함수를 정의해서 아이디를 입력하세요 경고부분을 빼시고 js 경고문을 처리하시길 바랍니다.
			     물론 비번이 다릅니다 도 처리하시면 됩니다.
			      숙제검사는 5월15일에 합니다. -->
			
				</select>-<input name="mem_phone02" id="mem_phone02" size="14" maxlength="4"
					value="${dm.mem_phone02}" />- <input name="mem_phone03"
					id="mem_phone03" size="14" maxlength="4" value="${dm.mem_phone03}" />
				</td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="수정" /> <input
					type="reset" value="취소" onclick="$('#mem_pwd').focus();" />
		</table>
	</form>
</body>
</html>