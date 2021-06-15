<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>m_update.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	
	<form action="m_updateOK.do" method="post">
		<table border="1">
			<tr>
				<td>memberNumber</td>
				<td>${param.memberNum}<input type="hidden" name="memberNum" value="${param.memberNum}"></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="memberId" placeholder="ID를 입력해주세요." value="yuna"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw" placeholder="비밀번호를 입력해주세요." value="pw1234"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="memberName" placeholder="이름을 입력해주세요." value="김연아"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="memberTel" placeholder="전화번호를 입력해주세요." value="010000011111"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="memberBday" placeholder="생일을 입력해주세요." value="19900905"></td>
			</tr>
			<tr>
				<td>가입한 멤버쉽 클럽</td>
				<td><input type="text" name="membership" placeholder="가입한 멤버쉽 클럽을 입력해주세요." value="ArtHouseClub"></td>
			</tr>
			<tr>
				<td>보유한 포인트</td>
				<td><input type="number" name="memberPoint" placeholder="보유한 포인트를 입력해주세요." value="5000"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="memberNickname" placeholder="닉네임을 입력해주세요." value="유나킴"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="text" name="memberGender" placeholder="성별을 입력해주세요." value="female"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>

</body>
</html>