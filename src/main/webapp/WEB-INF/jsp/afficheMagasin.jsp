<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher magasin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


</head>
<body>
	<%@ include file="/WEB-INF/menu.jsp" %>

<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">Nom</th>
				<th scope="col">Adresse</th>
				<th scope="col">Code postal</th>
				<th scope="col">Ville</th>
			</tr>
		</thead>
		<tbody>
		
			<tr>
				<th scope="row">${ magasin.id }</th>
				<td>${ magasin.nom }</td>
				<td>${ magasin.adresse }</td>
				<td>${ magasin.cp }</td>
				<td>${ magasin.ville }</td>
			</tr>
		
		</tbody>
	</table>

</body>
</html>