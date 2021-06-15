<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mv_selectAll.jsp</title>
</head>
<body>
	<h1>관람 영화 목록</h1>
	<jsp:include page="../menu.jsp"></jsp:include>


<c:if test='${sessionScope.login == "successed"}'>
	<form action="mv_searchList.do">
		<select name="searchKey">
			<option value="movieTitle">관람한 영화 제목</option>
			<option value="movieDirector">영화 감독</option>
			<option value="movieWriter">영화 작가</option>
			<option value="movietheatherPlace">영화관</option>
			<option value="movieTheaterNum">영화관 이름(ex. 1관, 5관..)</option>
			<option value="moviePeopleNum">관람객 수(ex. 성인 3명..)</option>
			<option value="movieSeatNum">영화관 좌석(ex. H8, G15..)</option>
			<option value="movieJanre">영화 장르(ex. 액션, SF...)</option>
		</select> <input type="text" name="searchWord" value="ma"> <input
			type="submit" value="search">
	</form>

	<table border="1">
			<tr>
				<th>movieNum</th>
				<th>movieTitle</th>
				<th>movieDirector</th>
				<th>movieWriter</th>
				<th>movietheatherPlace</th>
				<th>movieTheaterNum</th>
				<th>moviePeopleNum</th>
				<th>movieSeatNum</th>
				<th>movieJanre</th>
				<th>movieFileName</th>
				<th></th>
			</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="mv_selectOne.do?movieNum=${vo.movieNum}">${vo.movieNum}</a></td>
				<td>${vo.movieTitle}</td>
				<td>${vo.movieDirector}</td>
				<td>${vo.movieWriter}</td>
				<td>${vo.movietheatherPlace}</td>
				<td>${vo.movieTheaterNum}</td>
				<td>${vo.moviePeopleNum}</td>
				<td>${vo.movieSeatNum}</td>
				<td>${vo.movieJanre}</td>
				<td><img width="50" alt="영화사진" src="upload/${vo.movieFileName}"></td>
				<td><a href="mv_deleteOK.do?movieNum=${vo.movieNum}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>