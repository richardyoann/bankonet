<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><spring:message code="page.index.title" /></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<span style="float: right"> <a href="?lang=fr">fr</a> | <a
	href="?lang=en">en</a>
</span>
<body>
	<h1 class="text-center">
		<spring:message code="page.index.hello" />
	</h1>
	<div class="container">
		<form:form method="POST" action="/spring/${formAction}" modelAttribute="client">	
		<div class="row">
				<div class="form-group col-xs-12 offset-left">
					<form:label path="id"><spring:message code="page.index.form.id" /></form:label>					
					<form:input path="id" disabled="true" cssClass="input-block-level form-control" />
					
				</div>
				
				<div class="form-group col-xs-6 offset-left">
					<form:label path="nom"><spring:message code="page.index.form.nom" /></form:label>					
					<form:input path="nom" cssClass="input-block-level form-control" />
					<%-- Show errors for firstname field --%>
        			<form:errors path="nom"  />
				</div>
				<div class="form-group col-xs-6 offset-right">
					<form:label path="prenom"><spring:message code="page.index.form.prenom" /></form:label>					
					<form:input path="prenom" cssClass="input-block-level form-control" />
					<%-- Show errors for firstname field --%>
        			<form:errors path="prenom"  />
				</div>
				<div class="form-group col-xs-6 offset-right">
					<form:label path="login"><spring:message code="page.index.form.login" /></form:label>					
					<form:input path="login" cssClass="input-block-level form-control" />
					<%-- Show errors for firstname field --%>
        			<form:errors path="login"  />
				</div>

				<div class="form-group col-xs-6 offset-left">
					<form:label path="mdp"><spring:message code="page.index.form.mdp" /></form:label>					
					<form:input path="mdp" type="password" cssClass="input-block-level form-control" />
					<%-- Show errors for firstname field --%>
        			<form:errors path="mdp"  />
				</div>

				<div class="form-group col-xs-6 offset-right">
					<input class="btn btn-default" type="submit" value="Envoyer" />
				</div>

				<div class="form-group col-xs-6 offset-left">
					<input class="btn btn-default" type="reset" value="Annuler" />
				</div>
			</div>
		</form:form>
		<p class="text-center success">${message}</p>
	</div>
	
	

	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Login</th>
				<th>Mot de passe</th>
				<th>Supprimer</th>
				<th>Editer</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listeClient" items="${listeClients}">
				<tr>
					<td>${listeClient.id}</td>
					<td>${listeClient.nom}</td>
					<td>${listeClient.prenom}</td>
					<td>${listeClient.login}</td>
					<td>${listeClient.mdp}</td>
					<td><a href="../../spring/supprimer/${listeClient.id}">Supprimer</a></td>
					<td><a href="../../spring/editer/${listeClient.id}">Editer</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>
