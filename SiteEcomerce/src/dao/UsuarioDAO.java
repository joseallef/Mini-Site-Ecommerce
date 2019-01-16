package dao;

import beans.Usuario;
import utils.ConexaoDB;

import java.util.ArrayList;
import java.sql.*;
;
public class UsuarioDAO {
	public void create(Usuario usuario) {
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "INSERT INTO usuario VALUES(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Usuario consultarCadastro(String  user, String senha) {
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "SELECT * FROM usuario WHERE nome = ? and senha =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setNome( rs.getString("nome") );
				usuario.setSenha( rs.getString("senha") );
			}
			
			ps.close();
			con.close();
			
			return usuario;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public Usuario consultar(String email) {
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "SELECT * FROM usuario WHERE email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			Usuario usuario = null;
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setNome( rs.getString("nome") ); 
				usuario.setEmail( rs.getString("email") );
				usuario.setSenha( rs.getString("senha") );
			}
			ps.close();
			con.close();
			
			return usuario;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
		
	public void update(Usuario usuario) {
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "UPDATE usuario SET nome=?, senha=? WHERE email=?";
			PreparedStatement ps = con.prepareStatement(sql);			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getEmail());
			ps.executeUpdate();			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void delete(String email) {
		try {
			
			Connection con = ConexaoDB.getConexao();
			String sql = "DELETE FROM usuario WHERE email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);			
			ps.executeUpdate(); 
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public ArrayList<Usuario> listAll() { 
		try {

			Connection con = ConexaoDB.getConexao();
			String sql = "SELECT * FROM usuario";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList <Usuario> usuarios = new ArrayList<>();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome( rs.getString("nome") ); 
				usuario.setEmail( rs.getString("email") );
				usuario.setSenha( rs.getString("senha") );				
				usuarios.add(usuario);
			}
			ps.close();
			con.close();
			
			return usuarios;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}