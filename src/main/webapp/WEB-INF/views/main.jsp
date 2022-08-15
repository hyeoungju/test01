<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>메인 페이지</h3>
<%if(session.getAttribute("userId") == null) { %>
<button type="button" onclick='location.href="<c:url value='/login/login'/>"'>로그인</button>
<button type="button" onclick='location.href="<c:url value='/join/add_customer'/>"'>회원가입</button>
<%}else { %>
${userId }님, 환영합니다.
<button type="button" onclick='location.href="<c:url value='/login/logout'/>"'>로그아웃</button>
<%} %>
</body>
</html>