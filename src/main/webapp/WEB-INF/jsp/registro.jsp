<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro e lista de Autores</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		
	</head>
	<body>
		<h1 class="w-25 mx-auto">Projeto Bootcamp</h1>
		<div class="card w-75 mx-auto">
			<div class="card-header">
					<h2 class="card-title text-center">Cadastro de Autor</h2>			    
			</div>
			<div class="card-body">
				<form method="post">
					<div class="mb-3">
						<label for="nome" class="form-label">Nome</label>
						<input type="text" id="nome" name="nome" class="form-control">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label>
						<input type="email" id="email" name="email" class="form-control">
					</div>
					<div class="mb-3">
						<label for="nascimento" class="form-label">Data de Nascimento</label>
						<input type="date" id="nascimento" name="nascimento" class="form-control">
					</div>
					<div class="mb-3">
						<label for="curriculo" class="form-label">Mini currículo</label>
						<textarea id="curriculo" name="curriculo" class="form-control"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>
			</div>
		</div>
		<div class="card w-75 mx-auto mt-3">
			<div class="card-header">
				<h2 class="card-title text-center">Lista de Autores</h2>			    
		  	</div>
			<div class="card-body">
				<table class="table table-bordered table-striped">
					<thead>
						<tr class="table-light">
							<th>NOME</th>
							<th>EMAIL</th>
							<th>DATA DE NASCIMENTO</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${autores}" var="a" >
							<tr>
								<td>${a.nome}</td>
								<td>${a.email}</td>
								<td>${a.getNascimentoFormatado()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	</body>
</html>