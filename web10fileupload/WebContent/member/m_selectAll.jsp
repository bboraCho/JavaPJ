<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>m_selectAll.jsp</title>
</head>
<body>
	<h1>Member List(회원목록)</h1>
	<jsp:include page="../menu.jsp"></jsp:include>


	<c:if test='${sessionScope.login == "successed"}'>
	<form action="m_searchList.do">
		<select name="searchKey">
			<option value="memberId">ID</option>
			<option value="memberPw">비밀번호</option>
			<option value="memberName">이름</option>
			<option value="memberTel">전화번호</option>
			<option value="memberBday">생년월일</option>
			<option value="membership">가입한 멤버쉽 클럽</option>
			<option value="memberPoint">보유한 멤버쉽 포인트 점수</option>
			<option value="memberNickname">닉네임</option>
			<option value="memberGender">성별</option>
		</select> <input type="text" name="searchWord" value="ta"> <input
			type="submit" value="search">
	</form>

	<table border="1">
			<tr>
				<th>memberNum</th>
				<th>memberId</th>
				<th>memberPw</th>
				<th>memberName</th>
				<th>memberTel</th>
				<th>memberBday</th>
				<th>membership</th>
				<th>memberPoint</th>
				<th>memberNickname</th>
				<th>memberGender</th>
				<th>filename</th>
				<th></th>
			</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="m_selectOne.do?memberNum=${vo.memberNum}">${vo.memberNum}</a></td>
				<td>${vo.memberId}</td>
				<td>${vo.memberPw}</td>
				<td>${vo.memberName}</td>
				<td>${vo.memberTel}</td>
				<td>${vo.memberBday}</td>
				<td>${vo.membership}</td>
				<td>${vo.memberPoint}</td>
				<td>${vo.memberNickname}</td>
				<td>${vo.memberGender}</td>
				<td><img width="50" alt="프로필사진" src="upload/${vo.filename}"></td>
				<td><a href="m_deleteOK.do?memberNum=${vo.memberNum}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>