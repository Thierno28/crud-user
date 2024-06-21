<%@page import="beans.Utilisateur, java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%
	final String APP_ROOT = request.getContextPath();
	ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) request.getAttribute("users"); 
%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="ISO-8859-1">
	<title>Liste des utilisateurs</title>
	<link href="<%=APP_ROOT%>/ressources/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
	<script src="<%=APP_ROOT%>/ressources/bootstrap.bundle.min.js"></script>
	<script src="<%= APP_ROOT %>/js/script.js"></script>
	<style>
		.container-custom {
			background: linear-gradient(45deg, #5a9, #3a7);
			color: #fff;
		}
		.table-custom {
			background-color: #ffffff;
			border-radius: 10px;
			box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
		}
		.table th, .table td {
			vertical-align: middle;
		}
		.table .thead-dark th {
			background-color: #2575fc;
			color: #fff;
		}
		.btn-custom {
			background-color: #2575fc;
			color: #fff;
			transition: background-color 0.3s ease;
		}
		.btn-custom:hover {
			background-color: #333;
		}
	</style>
</head>
<body>
	<%@include file='/WEB-INF/menu.jsp' %>
	<div class="container mt-3 container-custom">
		<h1 id="titre-principal" class="text-center">Liste des utilisateurs</h1>
		<div class="my-5">
			<c:choose>
				<c:when test="${empty requestScope.users}">
					<p class="text-center">La liste des utilisateurs est pour le moment vide !</p>
				</c:when>
				<c:otherwise>
					<div class="table-responsive">
						<table class="table table-striped table-custom">
							<thead class="thead-dark">
								<tr>
									<th>ID</th>
									<th>Prénom</th>
									<th>Nom</th>
									<th>Login</th>
									<th>Password</th>
									<th colspan="2">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="user">
									<tr>
										<td>${user.id}</td>
										<td>${user.prenom}</td>
										<td>${user.nom}</td>
										<td>${user.username}</td>
										<td>${user.password}</td>
										<td><a class="btn btn-warning btn-sm" href="<c:url value='/update?id=${user.id}'/>">Modifier</a></td>
										<td><a class="btn btn-danger btn-sm" href="<c:url value='/delete?id=${user.id}'/>" onclick="return confirmSuppression()">Supprimer</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>
