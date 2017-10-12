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
					<div class="col-sm-3 col-lg-3 col-md-5">
						<div class="thumbnail">
							<div class="product-pict text-center">
								<img alt="User Pic" data-toggle="modal" data-target="#img-upload-modal" src="${sessionScope.user.imgPath}">
							</div>
						</div>
					</div>
					<br>
					<div class="col-sm-6">
						<h2>
							<c:out value="${sessionScope.user.name} ${sessionScope.user.surname}" />
						</h2>
						<a href="#" data-toggle="modal" data-target="#delete-user-modal">${delprofile}</a>
					</div>
					<div class="clearfix"></div>
					<hr style="margin: 5px 0 5px 0;">
					<div class="col-md-3 col-xs-6 tital">${name}:</div>
					<div class="col-md-3 col-xs-6">${sessionScope.user.name}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">${surname}:</div>
					<div class="col-md-3">${sessionScope.user.surname}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">${email}:</div>
					<div class="col-md-3">${sessionScope.user.email}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">${phonenumber}:</div>
					<div class="col-md-3">${sessionScope.user.phonenumber}</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">${discount}:</div>
					<div class="col-md-3">${sessionScope.user.discountCoefficient * 100}%</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">${ban_status}:</div>
					<div class="col-md-3">
						<c:choose>
							<c:when test="${sessionScope.user.banned == true}">
								${banned}
							</c:when>
							<c:otherwise>
								${n_banned}
							</c:otherwise>
						</c:choose>
					</div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
					<div class="col-md-3 col-xs-6 tital">${balance}:</div>
					<div class="col-md-3"><c:out value="${sessionScope.user.balance} ${rubles}"/></div>
					<div class="clearfix"></div>
					<div class="bot-border"></div>
				</div>
			</div>
			<div class="control-group">
				<button type="button" class="btn btn-default" data-toggle="modal" data-target="#user-balance">${rebalance}</button>
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
		<div class="modal fade bs-modal-sm" id="user-balance" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
						<form action="Controller" method="post">
							<input type="hidden" name="command" value="top_balance" /> <input type="number" id="inputCredit" min="0" max="1000"
								title="Enter number from 0 to 1000" class="form-control input-sm chat-input" name="credit" autofocus>
							<div class="modal-footer">
								<button type="submit" id="updateUser" class="btn btn-default btn-md">${submit}</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">${close}</button>
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