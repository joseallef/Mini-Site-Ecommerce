<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Incluir Categoria</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		</head>
	<body>
	
	<h1>Incluindo Aluno</h1>
	<span>Qual opção deseja</span>
	
	<form method="get" action="ServletCateogria" >
		<input type="hidden" value="incluir" name="cmd"/> <!-- passa a variavel cmd no valor incluir escondida -->
		Nome:<input type="text" name="txtNome"/><br/> <br/>
		Codigo:<input type="text" name="txtCodigo"/><br/> <br/>
		Linha:<input type="text" name="txtLinha"/><br/> <br/>
		Faixa Etária:<input type="text" name="txtFaixa"/><br/> <br/>
		<input type="submit" class="botao" name="Gravar"/>
	
	</form>
	
	</body>
</html>