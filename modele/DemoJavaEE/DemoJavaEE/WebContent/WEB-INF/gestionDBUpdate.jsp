<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Mise à jour d'une voiture</title>
</head>
<body>
	<h5>Mise à jour d'une voiture</h5>
	<form method="post" action="/DemoJavaEE/db/update/${voiture.id}">
	
		<%-- <input name="voitureID" value="${voiture.id}" hidden> Permet d'obtenir l'ID de la voiture sans la passer par l'URL --%>
	    <div>
	        <label for="modele">Modèle :</label>
	        <input type="text" id="modele" name="modele" value="${voiture.model}">
	    </div>
	    <div>
	        <label for="price">Prix :</label>
	        <input type="number" id="price" name="price" value="${voiture.price}">
	    </div>
	    <div>
	    	<label for="moteur">Moteur :</label>
		    <select id=moteur name="moteur">
		    	<c:forEach items="${moteurs}" var="moteur">
		    		<option value="${moteur.id}">${moteur.carburant} - ${moteur.cylindree} CC - ${moteur.puissance} CV</option>
		    	</c:forEach>
		    </select>
	    </div>
	    <input type="submit" value="Mettre à jour">
	</form>		
		
</body>
</html>