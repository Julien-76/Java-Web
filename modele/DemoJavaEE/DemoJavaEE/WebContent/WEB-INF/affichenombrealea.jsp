<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nombre aléatoire</title>
</head>
<body>
	<p>Voici le nombre aléatoire choisi :</p>
	<p>
		<%
			int alea = (int) request.getAttribute("nombre");
			out.println(alea);
		%>
	</p>
</body>
</html>