<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Petit marché</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<table>
    <thead>
        <tr>
            <th colspan="4">Produits proposés</th>
        </tr>
        <tr>
        	<th>Nom</th>
            <th>Prix</th>
            <th>Articles en stock</th>
            <th>Type du produit</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="produit" items="${produits}">
        	<c:if test="${produit.quantite > 0}" var="result" scope="page">
		        <tr>
		            <td>${produit.nom}</td>
		            <td>${produit.prix}</td>
		            <td>${produit.quantite}</td>
		            <td>${produit.type}</td>
		        </tr>
		   </c:if>
        </c:forEach>
    </tbody>
</table>
	
</body>
</html>