<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="css/mainstyle.css?2">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/adminstyle.css">
<title>Administration</title>
</head>
<body>
	<c:if test="${!sessionScope.user.admin}">
		<c:redirect url="profile" />
	</c:if>
	<%@ include file="/WEB-INF/elements/header.jspf"%>
	<div class="container-fluid">
		<div class="table-responsive">
			<table class="table table-sm table-hover" id="users-table">
				<thead>
					<tr>
						<th onclick="sortTable(0)" class="user-table-th">ID</th>
						<th onclick="sortTable(1)" class="user-table-th">Full Name</th>
						<th onclick="sortTable(2)" class="user-table-th">Email</th>
						<th onclick="sortTable(3)" class="user-table-th">Birth Date</th>
						<th onclick="sortTable(4)" class="user-table-th">Position</th>
						<th onclick="sortTable(5)" class="user-table-th">Experience</th>
						<th onclick="sortTable(6)" class="user-table-th">Home Address</th>
						<th onclick="sortTable(7)" class="user-table-th">Admin</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.userList}" var="user" varStatus="i">
						<tr>
							<td>${user.id}</td>
							<td><c:out value="${user.fullName}" /></td>
							<td>${user.email}</td>
							<td><fmt:formatDate value="${user.birth}" pattern="dd.MM.YYYY" /></td>
							<td>${user.position}</td>
							<td><fmt:formatDate value="${user.experience}" pattern="DD" /></td>
							<td>${user.homeAddress}</td>
							<td>${user.admin}</td>
							<td><c:if test="${sessionScope.user.id != user.id}">
									<button type="button" id="userUpdate-modal" class="btn btn-default btn-sm" data-toggle="modal" data-target="#userUpdate">Edit</button>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="modal fade bs-modal-sm" id="userUpdate" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
					<form action="Controller" method="post">
							<input type="hidden" name="cmd" value="deleteUser" /> 
							<input type="hidden" id="userEmail" name="userEmail" value="" />
							<div class="modal-footer">
								<button type="submit" class="btn btn-danger" id="deleteUser">Delete user</button>
							</div>
						</form>
						<form action="Controller" method="post">
							<input type="hidden" name="cmd" value="updateUser" /> 
							<input type="hidden" id="userEmail" name="userEmail" value="" />
							<div class="control-group">
								<div class="control-group">
									<label class="control-label">Position:</label>
									<div class="controls">
										<input id="userPosition" id="userPosition" name="userPosition" title="Letters and numbers only, max 25 symbols" class="form-control"
											max="25" pattern="\w+" type="text" class="input-large" placeholder="" required>
									</div>
								</div>
								<label class="control-label">Is Admin:</label> <select class="form-control" name="userIsAdmin" id="userIsAdmin">
									<option value="1">Yes</option>
									<option value="2">No</option>
								</select>
							</div>
							<div class="modal-footer">
								<button type="submit" id="updateUser" class="btn btn-default btn-md">Submit</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.1.1.min.js?1500"></script>
	<script src="js/modalUser.js?1500"></script>
	<script src="js/sortingScript.js?1500"></script>
	<script src="js/bootstrap.min.js?1500"></script>
	<script src="js/scripts.js?1500"></script>
</body>
</body>
</html>