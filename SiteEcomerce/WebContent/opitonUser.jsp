<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<title>Opções Usuário</title>
	<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
	<link rel="stylesheet" type="text/css" href="css/stilo.css">
	<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<div class="load"></div>
	<div class="tudo">
		<span>Qual opção deseja</span>
		<div class="login">
			<ul>
				<a href="incluirUsuario.jsp"><li>Incluir um novo Usuario</li></a><br>
				<a href="ServletUsuario?cmd=listarTodos"><li>Alterar Usuario</li></a>
			</ul>
		</div>
	</div>
</body>
</html>