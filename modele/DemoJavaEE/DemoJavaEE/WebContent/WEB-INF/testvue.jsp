<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <!-- isELIgnored="true" empêche d'utiliser les Expression Language -->

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Test fichier JSP</title>
</head>
<body>
	<p>Ceci est une page de test pour ma première vue</p>
	
	
	<p>
		<% 			// Balise ouvrante Java
			String attribut = (String) request.getAttribute("transmission");	//Obligation de caster car le format reçu est une requête et non une String
			out.println(attribut);
		%>			<!-- Balise fermante Java -->
		<%-- Commentaires JSP, invisibles dans le détail de la page HTML --%>
	</p>
	
	
	<p>
		Récupération du bean :<br> 
		<%
			Voiture v = (Voiture) request.getAttribute("voiture");
			out.println("Modèle de voiture : " + v.getModele() + "<br>");
			out.println("Cylindrée : " + v.getCylindree() + " CC");
		%>
	</p>
	
	
		<%-- Déclaration de variable directement dans le JSP (! sert d'inverseur) --%>
		<%! String chaine = "Bonjour les amis !"; %>
	<p>
		<% out.print(chaine); %>		
	</p>
	
	
	<p>
		<%-- Balise d'expression (affichage brut) --%>
		<%= 1200 %>
	</p>
	
	
		<%-- Directives --%>
		<%-- Inclusion statique --%>
		<%-- <%@ include file="affichenombrealea.jsp" %> --%>
		
		<%-- Inclusion dynamique --%>
		<%-- <jsp:include page="affichenombrealea.jsp"/> --%>
		
		<%-- Action standard useBean --%>
		<%--<jsp:useBean id="voit" class="be.technifutur.servlets.beans.Voiture" scope="request"/>
		<%-- Action standard getProperty --%>
		Modèle : <jsp:getProperty name="voit" property="modele"/>
		<%-- Action standard setProperty --%>
		<jsp:setProperty name="voit" property="modele" value="Ferrari F40"/>
		Modèle mis à jour : <jsp:getProperty name="voit" property="modele"/>
		
		<%-- Action standard forward (redirection) --%>
		<%-- <jsp:forward page="affichenombrealea.jsp"/> --%>
		
		
		<%-- Expression Language (écriture EL) --%>
		<h5>Expression Language démo</h5>
		1. ${!true || false} <br>
		2. ${10 % 4} <br>
		3. ${7 / 0} <br>
		4. ${'a' > 'b'} <br>
		5. ${'hop' ge 'hot'} <br>		<!-- ge = greater or equal = >= -->
		6. ${ 12 > 0 ? 'vrai' : 'faux' } <br>
		7. ${ empty 'toto' } <br>
		8. ${ empty '' } <br>
		9. ${ !empty '' } <br>
		
		
		<h5>Utilisation avec les beans</h5>
		Modèle : ${ voit.modele } <br>	<%-- Même si la propriété modele de la voiture est privée, il accèdera automatiquement à l'élément via le get --%>
		
		
		<h5>Collections</h5>
		
		<% 
			List<String> personnes = (List<String>) request.getAttribute("personnes");
			Map<String, Integer> cotations = (Map<String, Integer>) request.getAttribute("cotations");
		%>
		<p>
			- ${personnes.get(0)} <br>
			- ${personnes[1]} <br>
			- ${personnes['2']} <br>
			- ${personnes["1"]} <br>
			
			* ${cotations.Math} <br>
			* ${cotations.get("Programmation")} <br>
			* ${cotations["Programmation"]} <br>
		</p>
		
</body>
</html>