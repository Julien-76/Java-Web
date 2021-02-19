<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création de voiture</title>
</head>
<body>
	<form method="get" action="creerVoiture">
	    <div>
	        <label for="modele">Modèle :</label>
	        <input type="text" id="modele" name="modele">
	    </div>
	    <div>
	        <label for="cylindree">Cylindrée :</label>
	        <input type="number" id="cylindree" name="cylindree">
	    </div>
	    <div class="button">
	        <button type="submit">Créer la voiture</button>
	    </div>
	</form>
</body>
</html>