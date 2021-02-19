<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Création d'une voiture</title>
</head>
<body>
	<h5>Création d'une nouvelle voiture</h5>
	<form method="post" action="/DemoJavaEE/db/create">
	    <div>
	        <label for="modele">Modèle :</label>
	        <input type="text" id="modele" name="modele" placeholder="Nom du modèle">
	    </div>
	    <div>
	        <label for="price">Prix :</label>
	        <input type="number" id="price" name="price" placeholder="Prix">
	    </div>
	    <div>
	    	<label for="moteur">Moteur :</label>
		    <select id=moteur name="moteur">
		    	<c:forEach items="${moteurs}" var="moteur">
		    		<option value="${moteur.id}">${moteur.carburant} - ${moteur.cylindree} CC - ${moteur.puissance} CV</option>
		    	</c:forEach>
		    </select>
	    </div>
	    <input type="submit" value="Créer">
	</form>
	
</body>
</html>