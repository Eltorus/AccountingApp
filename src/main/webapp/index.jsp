<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/shop.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Authorization</title>
</head>
<body>
	<c:if test="${not empty sessionScope.user}">
		<c:redirect url="/" />
	</c:if>
	<%@ include file="/WEB-INF/elements/header.jspf"%>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
			<h2>Sign in to continue</h2> 
				<div class="form-login">
					<form class="form-signin" action="Controller" method="post">
						<input type="hidden" name="command" value="sign_in" />
						<h2 class="form-signin-heading">${message}</h2>
						<input type="email" id="inputEmail" class="form-control input-sm chat-input" placeholder="Email" name="email" required autofocus> <br />
						<input type="password" id="inputPassword" class="form-control input-sm chat-input" placeholder="Ppassword" name="password" required> <br />
						<div class="wrapper">
							<span class="group-btn"> 
							<input type="submit" class="btn btn-primary btn-md" value="Sign In">
							</span>
						</div>
					</form>
					<a href="signup">Sign Up</a>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>