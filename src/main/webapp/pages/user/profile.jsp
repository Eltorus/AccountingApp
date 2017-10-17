<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/mainstyle.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Profile</title>
</head>
<body>
	<%@ include file="/WEB-INF/elements/header.jspf"%>
	<c:if test="${empty sessionScope.user}">
		<c:redirect url="/" />
	</c:if>
	<div class="container">
		<div class="panel-body">
			<div class="col-sm-3 col-lg-3 col-md-5">
				<div class="thumbnail">
					<div class="product-pict text-center">
						<img alt="User Pic" src="img/users/default_avatar.jpg">
					</div>
				</div>
			</div>
			<br>
			<div class="col-sm-6">
				<h2><c:out value="${sessionScope.user.fullName}" /></h2>
			</div>
			<div class="box box-info">
				<button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#delete-user-modal">Delete profile</button>
				<div class="box-body">
					<br>
					<div class="col-sm-6">
						<a href="#" data-toggle="modal" data-target="#update-user-modal">Update profile</a>
					</div>
					<div class="clearfix"></div>
					<hr style="margin: 5px 0 5px 0;">
					<div class="col-md-3 col-xs-6 tital">Full Name:</div>
					<div class="col-md-3">${sessionScope.user.fullName}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">Position:</div>
					<div class="col-md-3">${sessionScope.user.position}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">Experience:</div>
					<div class="col-md-3">
						<fmt:formatDate value="${sessionScope.user.experience}" pattern="DD" />
					</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">Home address:</div>
					<div class="col-md-3">${sessionScope.user.homeAddress}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">Birth Date:</div>
					<div class="col-md-3">
						<fmt:formatDate value="${sessionScope.user.birth}" pattern="dd.MM.yyyy" />
					</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="delete-user-modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<h4>Are you sure you want to delete the profile?</h4>
						<form action="Controller" method="post">
							<input type="hidden" name="cmd" value="deleteUser" /> 
							<input type="hidden" name="userEmail" value="${sessionScope.user.email}" />
							<div class="modal-footer">
								<button type="submit" class="btn btn-danger">Delete</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="update-user-modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<h4>Update user</h4>
						<form action="Controller" method="post">
							<input type="hidden" name="cmd" value="updateUser" /> 
							<input type="hidden" name="userEmail" value="${sessionScope.user.email}" />
							<div class="control-group">
								<label class="control-label">Enter new home address:</label>
								<div class="controls">
									<input id="userPosition" id="homeAddress" name="homeAddress" class="form-control" max="45" pattern=".*" type="text" class="input-large"
										placeholder="" required>
								</div>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-default">Submit</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>