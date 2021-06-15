<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>m_selectOne.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>

	<table border="1">
		<tr>
			<td>memberNumber</td><td>${vo2.memberNum}</td>
		</tr>
		<tr>
			<td>ID</td><td>${vo2.memberId}</td>
		</tr>
		<tr>
			<td>비밀번호</td><td>${vo2.memberPw}</td>
		</tr>
		<tr>
			<td>이름</td><td>${vo2.memberName}</td>
		</tr>
		<tr>
			<td>전화번호</td><td>${vo2.memberTel}</td>
		</tr>
		<tr>
			<td>생년월일</td><td>${vo2.memberBday}</td>
		</tr>
		<tr>
			<td>가입한 멤버쉽 클럽</td><td>${vo2.membership}</td>
		</tr>
		<tr>
			<td>보유한 포인트</td><td>${vo2.memberPoint}</td>
		</tr>
		<tr>
			<td>닉네임</td><td>${vo2.memberNickname}</td>
		</tr>
		<tr>
			<td>성별</td><td>${vo2.memberGender}</td>
		</tr>
		
		<tr>
			<td></td><td><a href="m_update.do?memberNum=${vo2.memberNum}">update</a></td>
		</tr>
	</table>
	
</body>
</html>