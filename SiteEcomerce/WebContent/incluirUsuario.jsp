<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<title>Incluir Usuario</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
			<span>Incluindo Usuario</span>	
			<form method="get" action="ServletUsuario" >
				<input type="hidden" value="incluir" name="cmd"/>
				Nome:<input type="text" name="txtNome" ><br/>	
			
				Email:<input type="text" name="txtEmail" /><br/> 
				
				Senha:<input type="text" name="txtSenha" /><br/> <br/>
				
				<input type="hidden" name="cmd" value="incluir">
				<input type="submit" class="botao" name="Gravar"/>	
			</form>
		</div>
	</body>
</html>