<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mv_selectOne.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>

	<table border="1">
		<tr>
			<td>movieNum</td><td>${vo2.movieNum}</td>
		</tr>
		<tr>
			<td>관람한 영화 제목</td><td>${vo2.movieTitle}</td>
		</tr>
		<tr>
			<td>영화 감독</td><td>${vo2.movieDirector}</td>
		</tr>
		<tr>
			<td>영화 작가</td><td>${vo2.movieWriter}</td>
		</tr>
		<tr>
			<td>영화관</td><td>${vo2.movietheatherPlace}</td>
		</tr>
		<tr>
			<td>영화관 이름(ex. 1관, 5관..)</td><td>${vo2.movieTheaterNum}</td>
		</tr>
		<tr>
			<td>관람객 수(ex. 성인 3명..)</td><td>${vo2.moviePeopleNum}</td>
		</tr>
		<tr>
			<td>영화관 좌석(ex. H8, G15..)</td><td>${vo2.movieSeatNum}</td>
		</tr>
		<tr>
			<td>영화 장르(ex. 액션, SF...)</td><td>${vo2.movieJanre}</td>
		</tr>
		
		<tr>
			<td></td><td><a href="mv_update.do?movieNum=${vo2.movieNum}">update</a></td>
		</tr>
	</table>
	
</body>
</html>