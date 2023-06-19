<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher produit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


</head>
<body>
	<%@ include file="/WEB-INF/menu.jsp" %>

<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">Nom</th>
				<th scope="col">Référence</th>
				<th scope="col">Prix</th>
				<th scope="col">Poids</th>
			</tr>
		</thead>
		<tbody>
		
			<tr>
				<th scope="row">${ produit.id }</th>
				<td>${ produit.nom }</td>
				<td>${ produit.reference }</td>
				<td>${ produit.prix }</td>
				<td>${ produit.poids }</td>
			</tr>
		
		</tbody>
	</table>

</body>
</html>