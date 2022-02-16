<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1> Rottem Mango - Movie Review </h1>
	
	<jsp:include page="menu.jsp"></jsp:include>
	
	<h1>${sessionScope.login}</h1>
	<c:if test='${sessionScope.login != "successed"}'>
	<form action="m_loginOK.do" method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="memberId" value="marky"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="memberPw" value="pw1234"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>	
	</form>
	</c:if>
	<c:if test='${sessionScope.login == "successed"}'>
		<h1>${sessionScope.userID}님 어서오세요</h1>
		<a href="m_logout.do">logout</a>
	</c:if>
	
	
</body>
</html>
