<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>
    <%@ page import="beans.Produto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Detralhe Produto</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<jsp:useBean id="produto" scope="session"	class="beans.Produto" />
			<div class="load"></div>
			<div class="tudo">
				<div class="div2">			
					<img src="img/<%=produto.getFoto()%>"/><br>			
					Codigo: <b><%=produto.getCodigo()%></b><br>
			
					Produto: <%=produto.getProduto()%><br>
			
					Preço: R$ <%=produto.getPreco()%><br>
					Categoria: <%=produto.getCategoria()%><br>
					Descrição: <%=produto.getDescricao()%><br>
					<a href="ServletProduto?cmd=listarTodos">Voltar</a>
				</div>
			</div>
	</body>
</html>