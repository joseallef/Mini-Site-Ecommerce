<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Alterar Produto</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<div class="load"></div>
		<div class="tudo">
			<jsp:useBean id="produto" scope="session" class="beans.Produto" />
			<form action="ServletProduto?cmd=alterar" method="POST">	
		
				Codigo:<input type="text" name="txtCodigo" value="<%=produto.getCodigo()%>" /><br/>	
			
				Produto:<input type="text" name="txtProduto" value="<%= produto.getProduto()%>" /><br/> 
				
				Preço:<input type="text" name="txtPreco" value="<%=produto.getPreco()%>" /><br/> <br/>
			
			    Categoria:<input type="text" name="txtCategoria" value="<%=produto.getCategoria()%>" /><br/>
			    
		   		Foto: <input type="file" name="foto" value="<%=produto.getFoto()%>"><br>	
				
			   	Descrição:<textarea rows="7" name="txtDescricao" id="txtDescricao" cols="58"> <%=produto.getDescricao()%> </textarea>
			   	
				<input type="submit" class="botao" value="Confirma atualizão"/>
			</form>
		</div>
	</body>
</html>