<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c_selectAll.jsp</title>
</head>
<body>
	<h1>관람 영화 목록</h1>
	<jsp:include page="../menu.jsp"></jsp:include>


<c:if test='${sessionScope.login == "successed"}'>
	<form action="c_searchList.do">
		<select name="searchKey">
			<option value="contentTitle">영화 제목</option>
			<option value="contentPoint">관람 포인트(ex. 영상미, 스토리...)</option>
			<option value="contentReview">후기 내용 작성</option>
			<option value="contentPeopleName">같이 관람한 사람들 이름</option>
			<option value="contentRating">영화 평점(10점 만점)</option>
			<option value="contentRecommend">다른 사람에게 이 영화를 추천하시겠습니까?(예/아니오)</option>
			<option value="contentSnack">구매한 스낵 메뉴</option>
		</select> <input type="text" name="searchWord" value="ma"> <input
			type="submit" value="search">
	</form>

	<table border="1">
			<tr>
				<th>contentNum</th>
				<th>contentTitle</th>
				<th>contentPoint</th>
				<th>contentReview</th>
				<th>contentPeopleName</th>
				<th>contentRating</th>
				<th>contentRecommend</th>
				<th>contentSnack</th>
			</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="c_selectOne.do?contentNum=${vo.contentNum}">${vo.contentNum}</a></td>
				<td>${vo.contentTitle}</td>
				<td>${vo.contentPoint}</td>
				<td>${vo.contentReview}</td>
				<td>${vo.contentPeopleName}</td>
				<td>${vo.contentRating}</td>
				<td>${vo.contentRecommend}</td>
				<td>${vo.contentSnack}</td>
				<td><a href="c_deleteOK.do?contentNum=${vo.contentNum}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>
