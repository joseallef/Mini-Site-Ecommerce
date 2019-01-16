<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Categoria" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<title>Lista Categoria</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
		<table>
			<tr>
				<th>Nome</th>
			
				<th>Código</th>
			
				<th>Linha</th>
		
				<th>Faixa Etaria</th>
				
				<th>Opções</th>
			</tr>
			<%
				ArrayList <Categoria> lista = new ArrayList <Categoria>();		
				lista = (ArrayList) request.getAttribute("lista");		
				for(Categoria a: lista){
			%>
				<tr>
					<td><%=a.getNome() %></td>
			
					<td><%=a.getCodigo() %></td>
			
					<td><%=a.getLinha() %></td>
		
					<td><%=a.getFaixa() %></td>
					<td><a href="ServletCategoria?cmd=consultaAlterar&txtCodigo=<%=a.getCodigo() %>">Alterar</a> || 
						<a href="ServletCategoria?cmd=excluir&txtCodigo=<%=a.getCodigo() %>">Excluir</a></td>
				</tr>
				
			<% } %>	 
		</table>
		</div>
	</body>
</html>