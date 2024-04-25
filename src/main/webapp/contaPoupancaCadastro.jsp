<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta Poupança</title>
</head>
<body>

	<nav id="menu">
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="contaPoupancaCadastro.jsp">Cadastro Poupança</a></li>
		</ul>
	</nav>

	<div align="center">
		<form action="ContaPoupança" method="post">
			<table>
				<tr>
					<td><input type="number" min="0" step="1" id="numConta"
						name="numConta" placeholder="Número da Conta" required="required"></td>
				</tr>
				<tr>
					<td><input type="text" id="nome" name="nome"
						placeholder="Nome" required="required"></td>
				</tr>
				<tr>
					<td><input type="number" id="saldo" name="saldo"
						placeholder="Saldo" required="required"></td>
				</tr>
				<tr>
					<td><input type="number" min="0" step="1" max="31"
						id="dataRend" name="dataRend" placeholder="Data de Rendimento"
						required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" id="enviar" name="enviar"
						value="Cadastrar"></td>
				</tr>
				<tr>
					<td><input type="submit" id="enviar" name="enviar"
						value="Consultar"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<br>
	<c:if test="${not empty saida}">
		<div align="center">
			<c:out value="${saida}"></c:out>
		</div>
	</c:if>
	<c:if test="${not empty cp} ">
		<div align="center">
			<table>
				<thead>
					<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${cp.numConta }</td>
						<td>${cp.nome }</td>
						<td>${cp.saldo }</td>
						<td>${cp.diaDeRendimento }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>

</body>
</html>