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
<h3>메뉴 등록하기</h3>
<form:form method="post" modelAttribute="menuCommand">
메뉴이름 : <form:input type="text" path="menuName" />
메뉴가격 : <form:input type="text" path="menuPrice" />
메뉴종류 : <form:input type="text" path="menuType" />
<button type="submit" onclick="location.href='<c:url value="menuItem/add_menu"/>'" >메뉴등록</button>
</form:form>
</body>
</html>