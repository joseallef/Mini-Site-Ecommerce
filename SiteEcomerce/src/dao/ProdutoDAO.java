package dao;

import beans.Produto;
import utils.ConexaoDB;

import java.util.ArrayList;
import java.sql.*;
;
public class ProdutoDAO {
	public void create(Produto produto) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "INSERT INTO produto VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getCodigo());
			ps.setString(2, produto.getProduto());
			ps.setString(3, produto.getPreco());
			ps.setString(4, produto.getCategoria());
			ps.setString(5, produto.getFoto());
			ps.setString(6, produto.getDescricao());
			
			ps.executeUpdate(); // Executa o comando SQL no Banco de dados
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Produto consultar(String codigo) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "SELECT * FROM produto WHERE codigo = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, codigo);
			
			//Executa o comando SQL no banco de dados
			//e obtém o resultado da consulta
			ResultSet rs = ps.executeQuery();
			
			//Declara uma variável que representa os dados do aluno.
			//Neste momento está nula, pois, esta será a resposta
			//caso não exista nenhum registro retornado.
			Produto produto = null;
			
			//Caso exista algum registro retornado do banco...
			if (rs.next()) {
				//Instancia um objeto para a variável aluno...
				produto = new Produto();
				//Define os dados dos atributos de aluno com os dados da busca.
				produto.setCodigo( rs.getInt("codigo") ); 
				produto.setProduto( rs.getString("produto") );
				produto.setPreco( rs.getString("preco") );
				produto.setCategoria( rs.getString("categoria") );
				produto.setFoto( rs.getString("foto") );
				produto.setDescricao( rs.getString("descricao") );
			}
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
			return produto; //Retorna o objeto aluno com (ou sem) os dados do banco.
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
		
	public void update(Produto produto) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "UPDATE produto SET produto=?, preco=?, categoria=?, foto=?, descricao=? WHERE codigo=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, produto.getProduto());
			ps.setString(2, produto.getPreco());
			ps.setString(3, produto.getCategoria());
			ps.setString(4, produto.getFoto());
			ps.setString(5, produto.getDescricao());
			ps.setInt(6, produto.getCodigo());

			ps.executeUpdate(); // Executa o comando SQL no Banco de dados

			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void delete(String codigo) {
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "DELETE FROM produto WHERE codigo = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, codigo);
			
			ps.executeUpdate(); // Executa o comando SQL no Banco de dados
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public ArrayList<Produto> listAll(String categoria) { //array list vetor dinamico
		System.out.println(categoria);
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "SELECT * FROM produto WHERE categoria = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, categoria);
			
			//Executa o comando SQL no banco de dados
			//e obtém o resultado da consulta
			ResultSet rs = ps.executeQuery();
			
			//Declara uma variável que representa uma lista do aluno.
			//Neste momento está vazia, pois, esta será a resposta
			//caso não exista nenhum registro retornado.
			
			ArrayList <Produto> produtos = new ArrayList<>(); //instanciando array lista
			
			//Caso exista algum registro retornado do banco...
			while (rs.next()) {
				//Instancia um objeto para a variável aluno...
				Produto produto = new Produto();
				//Define os dados dos atributos de aluno com os dados da busca.
				produto.setCodigo( rs.getInt("codigo") ); 
				produto.setProduto( rs.getString("produto") );
				produto.setPreco( rs.getString("preco") );
				produto.setCategoria( rs.getString("categoria"));
				produto.setFoto( rs.getString("foto") );
				produto.setDescricao( rs.getString("descricao"));
				
				
				
				produtos.add(produto);
			}
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
			return produtos; //Retorna o objeto aluno com (ou sem) os dados do banco.
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public ArrayList<Produto> listTodas() { //array list vetor dinamico
		try {
			//1º Passo - Abrir e obter conexão
			Connection con = ConexaoDB.getConexao();
			
			//2º Passo - Criar, executar instrução SQL e obter os resultados
			String sql = "SELECT * FROM produto";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			//Executa o comando SQL no banco de dados
			//e obtém o resultado da consulta
			ResultSet rs = ps.executeQuery();
			
			//Declara uma variável que representa uma lista do aluno.
			//Neste momento está vazia, pois, esta será a resposta
			//caso não exista nenhum registro retornado.
			
			ArrayList <Produto> produtos = new ArrayList<>(); //instanciando array lista
			
			//Caso exista algum registro retornado do banco...
			while (rs.next()) {
				//Instancia um objeto para a variável aluno...
				Produto produto = new Produto();
				//Define os dados dos atributos de aluno com os dados da busca.
				produto.setCodigo( rs.getInt("codigo") ); 
				produto.setProduto( rs.getString("produto") );
				produto.setPreco( rs.getString("preco") );
				produto.setCategoria( rs.getString("categoria"));
				produto.setFoto( rs.getString("foto") );
				produto.setDescricao( rs.getString("descricao"));
				
				
				
				produtos.add(produto);
			}
			
			//3º Passo - Encerrar o processo de execução de instruções e a conexão.
			ps.close();
			con.close();
			
			return produtos; //Retorna o objeto aluno com (ou sem) os dados do banco.
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}