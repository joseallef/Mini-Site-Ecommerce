<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inclui produtos</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
			<span>Inclui produtos</span>
			<form action="ServletProduto" method="post">
				<input type="text" name="txtCodigo" id="txtCodigo" class="imput" title="Codigo Do produto"/>	
				<input type="text" name="txtProduto" class="imput" title="Produto">
				<input type="text" name="txtPreco" class="imput" title="Preço R$"><br>				
				<input type="text" name="txtCategoria" class="imput" title="Categoria"><br>	
				Foto:		
				<input type="file" name="foto" class="imput tam ar" title="Foto" value="ff"><br>				
				Descrição<br>
				<textarea rows="5" cols="60" name="txtDescricao" placeholder="Breve Descrição do Produto!"></textarea><br>
						
				<input type="hidden" name="cmd" value="incluir">
				<input type="submit" class="botao"  value="Cadastrar"/>	
			</form>
		</div>
	</body>
</html>