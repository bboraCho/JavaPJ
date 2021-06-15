<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c_update.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	
	<form action="c_updateOK.do" method="post">
		<table border="1">
			<tr>
				<td>contentNum</td>
				<td>${param.contentNum}<input type="hidden" name="contentNum" value="${param.contentNum}"></td>
			</tr>
			<tr>
				<td>영화 제목</td>
				<td><input type="text" name="contentTitle" placeholder="후기를 작성할 영화 제목을 입력하세요." value="버즈오브프레이"></td>
			</tr>
			
			
			
			<tr>
				<td>관람 포인트(ex. 영상미, 스토리...)</td>
				<td><input type="text" name="contentPoint" placeholder="후기를 작성할 영화의 관람 포인트를 입력하세요." value="영상미,스토리,BGM"></td>
			</tr>
			<tr>
				<td>후기 내용 작성</td>
				<td><input type="text" name="contentReview" placeholder="영화 후기를 작성해주세요." value="오랜만에 너무 재밌는 액션 영화였다."></td>
			</tr>
			<tr>
				<td>같이 관람한 사람들 이름</td>
				<td><input type="text" name="contentPeopleName" placeholder="같이 관람한 사람들 이름을 작성해주세요." value="이채린,박채영"></td>
			</tr>
			<tr>
				<td>영화 평점(10점 만점)</td>
				<td><input type="number" name="contentRating" placeholder="영화 평점을 입력하세요." value="10"></td>
			</tr>
			<tr>
				<td>다른 사람에게 이 영화를 추천하시겠습니까?(예/아니오)</td>
				<td><input type="text" name="contentRecommend" placeholder="예/아니오" value="예"></td>
			</tr>
			<tr>
				<td>구매한 스낵 메뉴</td>
				<td><input type="text" name="contentSnack" placeholder="영화를 관람하며 먹은 스낵 메뉴를 입력하세요." value="스프라이트"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>

</body>
</html>