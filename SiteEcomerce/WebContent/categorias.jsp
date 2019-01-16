<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Categorias</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
			<span>Incluindo Categoria</span>
			<form action="ServletCategoria" method="post">
				<input type="text" name="txtNome" class="imput"  title="Nome Da Categoria">
				<input type="text" name="txtCodigo" id="txtCodigo" class="imput" title="Codigo 9999">
				<input type="text" name="txtLinha" class="imput" title="Linha">
				<input type="text" name="txtFaixa" class="imput" title="Faixa Etária"><br>
						
				<input type="hidden" name="cmd" value="incluir">
				<input type="submit" class="botao" name="Gravar"/>
				
			</form>
		</div>
	</body>
</html>