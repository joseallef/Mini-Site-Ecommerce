<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="shurtcut icon" type="image/png" href="img/logo/icone.png">
		<link rel="stylesheet" type="text/css" href="css/stilo.css">
	</head>
	<body>
		<jsp:useBean id="categoria" scope="session" class="beans.Categoria" />	
		<form action="ServletCategoria?cmd=alterar" method="post">	
		
			Nome:<input type="text" name="txtNome" value="<%=categoria.getNome()%>" /><br/>	
		
			Codigo:<input type="text" name="txtCodigo" value="<%= categoria.getCodigo()%>" /><br/> 
			
			Linha:<input type="text" name="txtLinha" value="<%=categoria.getLinha()%>"/><br/> <br/>
		
		    Faixa Etaria:<input type="text" name="txtFaixa" value="<%=categoria.getFaixa()%>" /><br/> <br/>
			
		<input type="submit" class="botao" value="Confirma atualizão"/>
		</form>
	</body>
</html>