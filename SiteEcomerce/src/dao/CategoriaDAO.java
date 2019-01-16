package dao;

import beans.Categoria;
import utils.ConexaoDB;

import java.util.ArrayList;
import java.sql.*;
;
public class CategoriaDAO {
	public void create(Categoria categoria) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "INSERT INTO categoria VALUES(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, categoria.getNome());
			ps.setInt(2, categoria.getCodigo());
			ps.setString(3, categoria.getLinha());
			ps.setString(4, categoria.getFaixa());
			ps.executeUpdate(); // Executa o comando SQL no Banco de dados
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Categoria consultar(String codigo) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "SELECT * FROM categoria WHERE codigo = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, codigo);
			
			//Executa o comando SQL no banco de dados
			//e obtém o resultado da consulta
			ResultSet rs = ps.executeQuery();
			
			//Declara uma variável que representa os dados do aluno.
			//Neste momento está nula, pois, esta será a resposta
			//caso não exista nenhum registro retornado.
			Categoria categoria = null;
			
			//Caso exista algum registro retornado do banco...
			if (rs.next()) {
				//Instancia um objeto para a variável aluno...
				categoria = new Categoria();
				//Define os dados dos atributos de aluno com os dados da busca.
				categoria.setNome( rs.getString("nome") ); 
				categoria.setCodigo( rs.getInt("codigo") );
				categoria.setLinha( rs.getString("linha") );
				categoria.setFaixa( rs.getString("faixa") );
			}
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
			return categoria; //Retorna o objeto aluno com (ou sem) os dados do banco.
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
		
	public void update(Categoria categoria) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "UPDATE categoria SET nome=?, linha=?, faixa=? WHERE codigo=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, categoria.getNome());
			ps.setString(2, categoria.getLinha());
			ps.setString(3, categoria.getFaixa());
			ps.setInt(4, categoria.getCodigo());

			ps.executeUpdate(); // Executa o comando SQL no Banco de dados
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void delete(int codigo) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "DELETE FROM categoria WHERE codigo = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
			ps.executeUpdate(); // Executa o comando SQL no Banco de dados
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public ArrayList<Categoria> listAll() { //array list vetor dinamico
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "SELECT * FROM categoria";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			//Executa o comando SQL no banco de dados
			//e obtém o resultado da consulta
			ResultSet rs = ps.executeQuery();
			
			//Declara uma variável que representa uma lista do aluno.
			//Neste momento está vazia, pois, esta será a resposta
			//caso não exista nenhum registro retornado.
			
			ArrayList <Categoria> categorias = new ArrayList<>(); //instanciando array lista
			
			//Caso exista algum registro retornado do banco...
			while (rs.next()) {
				//Instancia um objeto para a variável aluno...
				Categoria categoria = new Categoria();
				//Define os dados dos atributos de aluno com os dados da busca.
				categoria.setNome( rs.getString("nome") ); 
				categoria.setCodigo( rs.getInt("codigo") );
				categoria.setLinha( rs.getString("linha") );
				categoria.setFaixa( rs.getString("faixa") );
				
				
				
				categorias.add(categoria);
			}
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
			return categorias; //Retorna o objeto aluno com (ou sem) os dados do banco.
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}