<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Opção de Categoria</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
			<span>Qual opção deseja</span>
			<div class="login">
				<ul>
					<a href="categorias.jsp"><li>Incluir uma nova Categoria</li></a><br>
					<a href="ServletCategoria?cmd=listarTodos"><li>Alterar Categoria</li></a>
				</ul>
			</div>
		</div>
	</body>
</html>