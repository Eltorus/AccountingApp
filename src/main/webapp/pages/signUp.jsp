<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/shop.css">
<title>Sign Up</title>
</head>
<body>
	<%@ include file="/WEB-INF/elements/header.jspf"%>
	<c:if test="${not empty sessionScope.user}">
		<c:redirect url="profile" />
	</c:if>
	<div class="container">
		<fieldset>
			<div class="container">
				<form class="form-horizontal" action="Controller" method="post">
					<input type="hidden" name="command" value="signUp" />
					<fieldset>
						<div class="control-group">
							<label class="control-label">Full Name</label>
							<div class="controls">
								<input id="name" name="userName" title="Letters and numbers only, max 45 symbols" class="form-control" pattern=".{45}" type="text"
									class="input-large" placeholder="Full Name" required>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Birth Date</label>
							<div class="controls">
								<input required id="datepicker" placeholder="Birth Date" name="delivery_date" title="dd.MM.YYYY" pattern="^[0-9]{2}\.[0-9]{2}\.[0-9]{4}$"
									type="text" class="form-control input-medium" required>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="Position">Position</label>
							<div class="controls">
								<input id="password" class="form-control" name="userPswrd" title="Must be at least 5 symbols" max="25" pattern="\w*" placeholder="Position"
									class="input-large" required>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="Home Address">Home Address</label>
							<div class="controls">
								<input id="password" class="form-control" name="homeAddress" max="45" pattern=".*" placeholder="Home Address"
									class="input-large" required>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="Email">Email</label>
							<div class="controls">
								<input id="Email" name="userEmail" max="45" class="form-control" type="email" title="Example: aa@aa.aa"
									pattern="^(.[^@\s]+)@(.[^@\s]+)\.([a-z]+)$" placeholder="Email" class="input-large" required>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="password">Password</label>
							<div class="controls">
								<input id="password" class="form-control" name="userPswrd" title="Must be at least 5 symbols" pattern=".{5,}" type="password"
									placeholder="********" class="input-large" required>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="reenterpassword">Confirm Password</label>
							<div class="controls">
								<input id="confirm_password" class="form-control" name="userPswrdConfirm" pattern=".{5,}" title="Must be at least 5 symbols" type="password"
									placeholder="********" class="input-large" required>
							</div>
						</div>
						<br>
						<div class="control-group">
							<span id="message"></span>
						</div>
						<div class="control-group">
							<label class="control-label" for="confirmsignup"></label>
							<div class="controls">
								<button id="signup_button" name="confirmsignup" type="submit" class="btn btn-success" disabled>Sign Up</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</fieldset>
	</div>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/jquery.maskedinput.min.js"></script>
	<script src="js/reg_script.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>