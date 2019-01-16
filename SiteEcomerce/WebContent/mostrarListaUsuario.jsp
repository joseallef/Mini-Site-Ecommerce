<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<title>Lista Usuario</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
	<div class="load"></div>
	<div class="tudo">
		<table>
			<tr>
				<th>Nome</th>
			
				<th>E-mail</th>
			
				<th>Senha</th>
				
				<th>Opção</th>
				
			</tr>	
			<%
				ArrayList <Usuario> lista = new ArrayList <Usuario>();
			
				lista = (ArrayList) request.getAttribute("lista");
				
				for(Usuario a: lista){
			%>
			<tr>	
				<td><%=a.getNome() %></td>
				
				<td><%=a.getEmail() %></td>
				
				<td><%=a.getSenha() %></td>
				
				<td><a href="ServletUsuario?cmd=consultaAlterar&txtEmail=<%=a.getEmail() %>">Alterar</a> ||
				<a href="ServletUsuario?cmd=excluir&txtEmail=<%=a.getEmail() %>">Excluir</a> </td>
				
			<% } %>					
			</tr>	
		</table>
		</div>	
	</body>
</html>