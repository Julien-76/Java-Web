<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	Appel de la librairie JSTL, nécessaire si non défini de manière générale dans les fichiers web.xml + taglibs.jsp --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Démo JSTL</title>
</head>
<body>
		
	<h5>Variables</h5>
	<h6>Afficher une variable donnée</h6>
	${'<p>Bonjour</p>'}
	<c:out value="<p>Bonjour</p>"/>
	<c:out value="${'<p>Bonjour</p>'}"/>
	
	
	<h6>Créer une variable</h6>
	<c:set var="maVariable" value="Hello tout le monde" scope="page"/>		<%-- Cette variable sera un String --%>
	Affichage simple : ${maVariable} <br>
	Affichage complet : <c:out value="${maVariable}"/> <br>
	<c:set var="maVariable" value="12"/>
	${maVariable} <br>
	<c:set var="v2" value="${v2}" scope="request"/>
	${v2} <br>
	<c:set target="${v2}" property="modele" value="Ferrari F40"/>
	${v2} <br>
	
	
	<h6>Supprimer une variable</h6>
	<c:remove var="maVariable" scope="page"/>
	${maVariable} <br>
	
	
	<h5>Conditions</h5>
	
	<h6>If simple</h6>
	<c:if test="${12 > 8}" var="result" scope="page">
		<p>Je m'affiche si la condition est vraie</p>
	</c:if>
	
	<h6>Switch ou if multiple</h6>
	<c:choose>
		<c:when test="${choose == 'A'}"> J'affiche 'A' </c:when>		<%-- Cas 1 (choose est égal à A) --%>
		<c:when test="${choose == 'B'}"> J'affiche 'B' </c:when>		<%-- Cas 2 (choose est égal à B) --%>
		<c:otherwise> J'affiche autre chose </c:otherwise>				<%-- Autres cas --%>
	</c:choose>
	
	
	<h5>Une gestion de boucles</h5>
	<h6>ForEach</h6>
	<c:forEach var="voiture" items="${voitures}">		<%-- la balise commence par (nom du préfixe): puis l'instruction --%>
		<p><c:out value="${voiture}"/></p>
	</c:forEach>
	
	<c:forEach var="voiture" items="${voitures}" varStatus="status">		<%-- la balise commence par (nom du préfixe): puis l'instruction --%>
		<p>${status.count} <c:out value="${voiture}"/></p>
	</c:forEach>
	
	<h6>For i (boucle itérative)</h6>
	<ul>
		<c:forEach var="i" begin="0" end="5" step="1">
			<li><c:out value="${i}"/></li>
		</c:forEach>
	</ul>
	
	<p>
		<c:forTokens var="sousChaine" items="${chaine}" delims=";,">
			${sousChaine} <br>
		</c:forTokens>
	</p>
	
	<p>
		<c:forTokens var="sousChaine" items="${chaine}" delims=" ">
			${sousChaine} <br>
		</c:forTokens>
	</p>
	
	<h5>Une gestion des URL</h5>
	<a href="<c:url value="/index.jsp"/>">Go to index</a>			<%-- renvoie l'URL absolue --%>
	<a href=" <c:url value="/index.jsp"> <c:param name="lang" value="fr"/> </c:url>	">Go to index with params</a>
	
	
</body>
</html>