<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Syntaxe EL</title>
</head>
<body>
	<p>${message}</p>
	<h6>Ma voiture :</h6>
	<p>Modèle = ${voiture.modele}</p>
	<p>Cylindrée = ${voiture.cylindree}</p>
	<ul>
		${listeLI}
	</ul>
	
</body>
</html>