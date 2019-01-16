<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alterar Usuário</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
			<span>Altera Usuário</span>	
			<jsp:useBean id="usuario" scope="session" class="beans.Usuario" />
			<form action="ServletUsuario" method="post">
				Email
				<input type="text" name="txtEmail" value="<%=usuario.getEmail()%>" readonly="readonly" class="em">
				Nome
				<input type="text" name="txtNome" value="<%=usuario.getNome()%>">
				Senha
				<input type="text" name="txtSenha" value="<%=usuario.getSenha()%>">
				
				<input type="hidden" name="cmd" value="alterar">
				<input type="submit" class="botao" value="Alterar"/>
			</form>
		</div>
	</body>
</html>