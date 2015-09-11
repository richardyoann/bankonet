<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html>
<head>
<title><spring:message code="page.index.title" /></title>
</head>
<span style="float: right"> <a href="?lang=fr">fr</a> | <a
	href="?lang=en">en</a>
</span>
<body>
	<h1>
		<spring:message code="page.index.hello" />
	</h1>
	<table>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Login</th>
				<th>Mot de passe</th>
				<th>Supprimmer</th>
				<th>Editer</th> 
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listeClient" items="listeClients">
				<tr>
					<td>${listeClient.nom}</td>
					<td>${listeClient.prenom}</td>
					<td>${listeClient.login}</td>
					<td>${listeClient.mdp}</td>
					<td><a href="supprimer?"${listeClient.id}></a>Supprimer</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>


	<P>
		<spring:message code="page.home.timeOnServer" />
		${serverTime}.
	</P>
</body>
</html>
