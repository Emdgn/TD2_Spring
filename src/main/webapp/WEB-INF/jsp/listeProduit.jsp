<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produits</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="/WEB-INF/menu.jsp" %>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">Nom</th>
				<th scope="col">Référence</th>
				<th scope="col">Prix</th>
				<th scope="col">Poids</th>
				<th scope="col">Supprimer</th>
				
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="produit" items="${ listeProduit }">
			<tr>
				<th scope="row">${ produit.id }</th>
				<td>${ produit.nom }</td>
				<td>${ produit.reference }</td>
				<td>${ produit.prix }</td>
				<td>${ produit.poids }</td>
				<td scope="col"><a href="supprimerProduit/${ produit.id }"><button type="button" class="btn-close" disabled aria-label="Close"></button></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>