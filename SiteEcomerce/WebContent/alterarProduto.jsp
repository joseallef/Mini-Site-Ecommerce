<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Produto" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Incluir</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
			<table>
				<tr>
					<th>Código</th>
				
					<th>Produto</th>
				
					<th>Preço</th>
			
					<th>Categoriath>
					
					<th>Descrição</th>
				</tr>
				<%
					ArrayList <Produto> lista = new ArrayList <Produto>();		
					lista = (ArrayList) request.getAttribute("lista");		
					for(Produto p: lista){
				%>
				<tr>
					<td><%=p.getCodigo()%></td>
			
					<td><%=p.getProduto()%></td>
			
					<td><%=p.getPreco()%></td>
		
					<td><%=p.getCategoria()%></td>
					
					<td><%=p.getDescricao()%></td>
					
					<td><a href="ServletCategoria?cmd=consultaAlterar&txtCodigo=<%=p.getCodigo() %>">Alterar</a> || 
						<a href="ServletCategoria?cmd=excluir&txtCodigo=<%=p.getCodigo() %>">Excluir</a></td>
				</tr>
				
			<% } %>	 
			</table>
		</div>
	</body>
</html>