package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDB {
	public static Connection getConexao() {		
		try {			
			
			Class.forName("com.mysql.jdbc.Driver"); //fala com o banco
			
			//conecao
			String url = "jdbc:mysql://localhost/db_site";  
			
			String login = "root";
			
			String senha = "";
			//Estabelecendo e obtendo uma conexão com o Banco de dados
			//Esta linha poderá causar uma exceção em tempo de compilação 
			//chamada SQLException
			return DriverManager.getConnection(url,login,senha);

		} catch (Exception e) {
			//Caso uma das duas linhas especificada causem alguma exceção
			//este bloco irá tratar lançando uma exceção em tempo de execução.
			throw new RuntimeException(e.getMessage());
			
		}		
	}
}