<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestion de la DB</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<h3>Tests JDBC</h3>
	
	<c:if test="${messages != null}">
		<c:forEach items="${messages}" var="message" varStatus="boucle">
			<p>${boucle.count}) ${message}</p>
		</c:forEach>
	</c:if>
	
	<p><a href="db/create">Créer une nouvelle voiture</a></p>
	
	<table>
		<thead>
			<th>Car ID</th>
			<th>Modèle</th>
			<th>Prix</th>
			<th>Moteur ID</th>
			<th>Cylindrée</th>
			<th>Type</th>
			<th>Puissance</th>
			<th>Détail</th>
			<th>Effacer</th>
			<th>Mettre à jour</th>
		</thead>
		<tbody>
		<c:forEach items="${voitures}" var="voiture">
			<tr>
				<td>${voiture.id}</td>
				<td>${voiture.model}</td>
				<td>${voiture.price}</td>
				<td>${voiture.moteur.id}</td>
				<td>${voiture.moteur.cylindree}</td>
				<td>${voiture.moteur.carburant}</td>
				<td>${voiture.moteur.puissance}</td>
				<td><a href="db/detail/${voiture.id}">Détail</a></td>	<%-- "/db/1" ramène à la racine du projet, "db/1" garde la position relative --%>
				<td><a href="db/delete/${voiture.id}">Effacer</a></td>
				<td><a href="db/update/${voiture.id}">Mettre à jour</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>