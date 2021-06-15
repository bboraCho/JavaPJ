<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>m_insert.jsp</title>
</head>
<body>
	<h1>Sign Up(회원가입)</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	
	<form action="m_insertOK.do" method="post" encType="multipart/form-data">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="memberId" placeholder="ID를 입력하세요." value="admin"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw" placeholder="비밀번호를 입력하세요." value="pw1234"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="memberName" placeholder="이름을 입력하세요." value="김연아"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="memberTel" placeholder="전화번호를 입력하세요" value="01012341234"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="memberBday" placeholder="생년월일을 입력하세요" value="19970808"></td>
			</tr>
			<tr>
				<td>가입한 멤버쉽 클럽(kidsFamilyClub / ArtHouseClub / 1318Club)</td>
				<td><input type="text" name="membership" placeholder="가입하신 멤버쉽 클럽을 입력하세요" value="ArtHouseClub"></td>
			</tr>
			<tr>
				<td>보유한 포인트</td>
				<td><input type="number" name="memberPoint" value="100"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="memberNickname" placeholder="닉네임을 입력하세요" value="kims"></td>
			</tr>
			<tr>
				<td>성별(female / male)</td>
				<td><input type="text" name="memberGender" placeholder="성별을 입력하세요" value="female"></td>
			</tr>
			<tr>
				<td>프로필사진</td>
				<td><input	type="file" name="filename"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>
		
	</form>
	
</body>
</html>