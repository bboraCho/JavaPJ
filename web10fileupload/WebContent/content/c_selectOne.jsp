<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c_selectOne.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>

	<table border="1">
		<tr>
			<td>contentNum</td><td>${vo2.contentNum}</td>
		</tr>
		<tr>
			<td>영화 제목</td><td>${vo2.contentTitle}</td>
		</tr>
		
		<tr>
			<td>관람 포인트(ex. 영상미, 스토리...)</td><td>${vo2.contentPoint}</td>
		</tr>
		<tr>
			<td>후기 내용 작성</td><td>${vo2.contentReview}</td>
		</tr>
		<tr>
			<td>같이 관람한 사람들 이름</td><td>${vo2.contentPeopleName}</td>
		</tr>
		<tr>
			<td>영화 평점(10점 만점)</td><td>${vo2.contentRating}</td>
		</tr>
		<tr>
			<td>다른 사람에게 이 영화를 추천하시겠습니까?(예/아니오)</td><td>${vo2.contentRecommend}</td>
		</tr>
		<tr>
			<td>구매한 스낵 메뉴</td><td>${vo2.contentSnack}</td>
		</tr>
		
		<tr>
			<td></td><td><a href="c_update.do?contentNum=${vo2.contentNum}">update</a></td>
		</tr>
	</table>
	
</body>
</html>