<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>
	<%@ page import="beans.Produto"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cozinhas</title>
	<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" type="text/css" href="css/stilo.css">
	<script type="text/javascript" src="js/jquery.js"></script>
</head>
	<body>
	<div class="load"></div>
	<div class="tudo">	
		<%
			List<Produto> lista = new ArrayList<Produto>();
			lista = (ArrayList) request.getAttribute("listaProduto");
			for (Produto p : lista) {
		%>
		<div class="div1">
		
			<img src="img/<%=p.getFoto()%>"/><br>			
	
			<b><%=p.getCodigo()%></b><br>
	
			<%=p.getProduto()%><br>
	
			R$ <%=p.getPreco()%><br>
			<form action="ServletProduto?cmd=consultaProduto" method="POST">
			<input type="hidden" name="codProduto" value="<%=p.getCodigo()%>">
			<input type="submit" class="bot" value="+Detralhes"/>
			</form>
		</div>
		<%
			}
		%>
	</div>
	</body>
</body>