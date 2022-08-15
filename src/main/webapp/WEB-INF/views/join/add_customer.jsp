<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입</h3>
<form:form method="post" modelAttribute="customerCommand">
아이디 : <form:input type="text" path="userId" />
비밀번호 : <form:input type="password" path="passwd" />
이름 : <form:input type="text" path="name" />
<button type="submit" onclick="location.href='<c:url value="join/add_customer"/>'" >회원가입</button>
</form:form>
</body>
</html>