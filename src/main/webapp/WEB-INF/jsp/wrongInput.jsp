<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style><%@include file="/css/bootstrap.min.css" %></style>
	<title>Wrong Input</title>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<h1>Error</h1>
			<br /> <a href="<c:url value="/"/>">Wrong Input</a>
		</div>
	</div>
</body>
</html>