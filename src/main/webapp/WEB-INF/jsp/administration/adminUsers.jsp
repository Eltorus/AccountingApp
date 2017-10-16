<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="css/mainstyle.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/adminstyle.css">
<title>Administration</title>
</head>
<body>
	<c:if test="${sessionScope.user.admin != true}">
		<c:redirect url="/" />
	</c:if>
	<%@ include file="/WEB-INF/elements/header.jspf"%>
	<div class="container-fluid">
		<div class="table-responsive">
			<table class="table table-sm table-hover" id="users-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Birth Date</th>
						<th>Position</th>
						<th>Experience</th>
						<th>Home Address</th>
						<th>Admin</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.userList}" var="user" varStatus="i">
						<tr>
							<td>${user.id}</td>
							<td><c:out value="${user.fullName}" /></td>
							<td>${user.email}</td>
							<td>${user.birth}</td>
							<td>${user.position}</td>
							<td>${user.experience}</td>
							<td>${user.homeAddress}</td>
							<td>${user.admin}"></td>
							<td>
								<form action="Controller" method="post">
									<input type="hidden" name="command" value="update_ban_status" /> <input type="hidden" name="user_id" value="${user.id}" /> <input
										type="hidden" name="user_banned" value="${user.banned}" />
									<c:choose>
										<c:when test="${user.banned == true}">
											<button type="submit" id="updateUser" class="btn btn-danger btn-md">${banned}</button>
										</c:when>
										<c:otherwise>
											<button type="submit" id="updateUser" class="btn btn-primary btn-md">${n_banned}</button>
										</c:otherwise>
									</c:choose>
								</form>
							</td>
							<td>
								<button type="button" id="discount-modal" class="btn btn-default btn-md" data-toggle="modal" data-target="#user-discount">${set_discount}</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="modal fade bs-modal-sm" id="user-discount" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
						<form action="Controller" method="post">
							<input type="hidden" name="command" value="update_user_discount" /> <input type="hidden" id="user_id" name="user_id" value="" />
							<div class="control-group">
								<label class="control-label">${discount} :</label> <select class="form-control" name="user_discount">
									<option value="1">0%</option>
									<option value="2">5%</option>
									<option value="3">10%</option>
								</select>
							</div>
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
	<script src="js/modalUser.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</body>
</html>