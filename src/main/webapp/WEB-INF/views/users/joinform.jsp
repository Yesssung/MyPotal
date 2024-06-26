<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입폼</title>
	<script src="<c:url value="/javascript/user.js" />"></script>
	<link type="text/css" rel="stylesheet" href='<c:url value="/css/users.css" />'/>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
	<h1>회원 가입</h1>
	
	<form
		id="join-form"
		name="registerForm" 
		action="<c:url value="/users/join" />"
		method="POST"
		>
		
		<label for="name">이름</label>
		<input name="name" type="text" placeholder="이름을 입력하십시오"><br>
	
		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
	
		<label for="email">이메일</label>
		<input type="text" name="email" placeholder="이메일을 입력하십시오." />
		<input type="button" id="check-email" data-target="<c:url value="/users/checkEmail" />" value="email 중복 체크" />
		<input type="hidden" name="emailCheck" value="n"/>
		<br>
	
		<label for="gender">성별</label>
		<input type="radio" name="gender" value="M" checked>남성</radio>
		<input type="radio" name="gender" value="F">여성</radio><br>
		
		<lable for="agree">약관동의</lable>
		<input type="checkbox" id="agree" name="agree" value="n" />
		
		<input type="submit" value="전송"> 
	
	</form>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>	
</body>
</html>