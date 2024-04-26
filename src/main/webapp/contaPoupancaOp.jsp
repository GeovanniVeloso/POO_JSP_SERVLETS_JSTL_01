<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta Poupança Operações</title>
</head>
<body>

	<nav id="menu">
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="contaPoupancaCadastro.jsp">Cadastro Poupança</a></li>
			<li><a href="contaEspecialCadastro.jsp">Cadastro Especial</a></li>
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
					<td><input type="number" id="saldoOp" name="saldoOp"
						placeholder="Valor da Operação" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" id="enviar" name="enviar"
						value="Depositar"></td>
				</tr>
				<tr>
					<td><input type="submit" id="enviar" name="enviar"
						value="retirar"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>