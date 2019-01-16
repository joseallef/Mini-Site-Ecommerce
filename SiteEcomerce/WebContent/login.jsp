<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class=tudo>		
			<form action="ServletUsuario" method="post">
				Usúario:<br>
				<input type="text" name="usuario" id="usu" ><br>
				Senha:<br>
				<input type="password" name="senha" id="senha"><br>
				
				<input type="hidden" name="cmd" value="consultaUsuario">
				<input type="submit" class="botao" value="Acessar">
			</form>
		</div>
	</body>
</html>