<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Profile</title>
</head>
<body>
	<%@ include file="/WEB-INF/elements/header.jspf"%>
	<c:if test="${empty sessionScope.user}">
		<c:redirect url="signin" />
	</c:if>
	<div class="container">
		<div class="panel-body">
			<div class="box box-info">
				<div class="box-body">
					<br>
					<div class="col-sm-6">
						<h2>
							<c:out value="${sessionScope.user.fullName}" />
						</h2>
						<a href="#" data-toggle="modal" data-target="#delete-user-modal">Delete profile</a>
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
					<div class="col-md-3">${sessionScope.user.registrationDate}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">Home address:</div>
					<div class="col-md-3">${sessionScope.user.homeAdress}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">Birth Date:</div>
					<div class="col-md-3">${sessionScope.user.fullName}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
				</div>
			</div>
		</div>
		<div class="modal fade bs-modal-sm" id="img-upload-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form class="form-signin" action="Controller" method="post" enctype="multipart/form-data">
						<div class="modal-body">
							<div id="myTabContent" class="tab-content">
								<h4>${upload_img}</h4>
								<div class="tab-pane fade active in">
									<input type="hidden" name="command" value="upload_avatar" /> <label class="btn btn-default" for="my-file-selector"> <input
										id="my-file-selector" type="file" accept="image/*" name="user_avatar" size="60" style="display: none;"
										onchange="$('#upload-file-info').html($(this).val());"> ${choose}
									</label>
								</div>
								<span class='label label-info' id="upload-file-info"></span>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary btn-md">${upload}</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">${cancel}</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade" id="delete-user-modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<h4>${r_u_sure}${del_prof}?</h4>
						<form action="Controller" method="post">
							<input type="hidden" name="command" value="delete_user" />
							<div class="modal-footer">
								<button type="submit" class="btn btn-danger">${delete}</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">${cancel}</button>
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