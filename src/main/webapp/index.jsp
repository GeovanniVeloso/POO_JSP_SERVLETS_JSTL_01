<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<body>
	<nav id="menu">
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="contaPoupancaCadastro.jsp">Cadastro Poupança</a></li>
		</ul>
	</nav>
	<div align="center">
		<table border="1">
			<thead>
				<tr>
					<th><b>#ID</b></th>
					<th><b>Nome</b></th>
					<th><b>Data de Nascimento</b></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>TESTE1</td>
					<td>11/11/1111</td>
				</tr>
				<tr>
					<td>2</td>
					<td>TESTE2</td>
					<td>22/22/2222</td>
				</tr>
				<tr>
					<td>3</td>
					<td>TESTE3</td>
					<td>33/33/3333</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<div align="center">
		<form action="ContaPoupança" method="post">
			<table>
				<tr>
					<td><input type="number" min="0" step="1" id="id" name="id"
						placeholder="#ID" required="required"></td>
				</tr>
				<tr>
					<td><input type="text" id="nome" name="nome"
						placeholder="Nome" required="required"></td>
				</tr>
				<tr>
					<td><input type="date" id="dataNasc" name="dataNasc"
						placeholder="Data de Nascimento" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" id="enviar" name="enviar"
						value="Enviar"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<br>
	<c:if test="${not empty saida} ">
		<div align="center">
			<c:out value="${saida }"></c:out>
		</div>
	</c:if>
	<c:if test="${not empty pessoas} ">
		<div align="center">
			<table>
				<thead>
					<tr>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${pessoas }">
						<tr>
							<td>${p.id }</td>
							<td>${p.nome }</td>
							<td>${p.dataNasc }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</body>

</html>