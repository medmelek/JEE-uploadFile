<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="Bonjour"/>
<c:choose>
<c:when test="${!empty sessionScope.name }"><c:out value="${sessionScope.name}"/></c:when>
<c:when test="${empty sessionScope.name }"><c:out value="vous etes pas connectez"/></c:when>
</c:choose>
</body>
</html>