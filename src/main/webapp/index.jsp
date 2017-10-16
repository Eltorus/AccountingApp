<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
			<c:redirect url="profile" />
		</c:when>
		<c:otherwise>
			<c:redirect url="signin" />
		</c:otherwise>
	</c:choose>
</body>
</html>