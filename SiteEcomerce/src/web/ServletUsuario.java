package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import dao.UsuarioDAO;


@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//receve a instrução de comando (incluir,alterar...)
		
		String cmd = request.getParameter("cmd"); //recebe do html a variavel escondida
		
		RequestDispatcher rd = null;
		
		//receber os dados da inclusão
			if(cmd.equalsIgnoreCase("incluir")) { 
				
				String nome = request.getParameter("txtNome");
				
				String email = request.getParameter("txtEmail");

				String senha = request.getParameter("txtSenha");				
			
				//criar o objeto para mandar para o banco pq ele não trabalha com dados soltos
				
				Usuario usuario = new Usuario();
				//populando o objeto
				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setSenha(senha);
				System.out.println(usuario.toString());
				
				//mandar para o banco
				
			     UsuarioDAO dao = new UsuarioDAO();
				
				//chamo o metodo que grava
				dao.create(usuario);
				
				rd=request.getRequestDispatcher("ServletUsuario?cmd=listarTodos");
				rd.forward(request,response);
			}
			
			else if(cmd.equalsIgnoreCase("listarTodos")) {
				
				ArrayList<Usuario> listaUsuario= new ArrayList<Usuario>();
				
				UsuarioDAO dao = new UsuarioDAO();
				
				listaUsuario = dao.listAll();
				
				//redireciona para uma nova pagina chama uma pagina 
				rd = request.getRequestDispatcher("/mostrarListaUsuario.jsp");
				
				//coloca a lista em uma sessão
				request.setAttribute("lista", listaUsuario);
				
				//executa o direcionamento
				
				rd.forward(request,response);
				
			}
			
			else if(cmd.equalsIgnoreCase("consultaAlterar")) { 
				
				//recebendo RGM
				String email = request.getParameter("txtEmail");			
				
				Usuario usuario = new Usuario();			
				
				//abrindo bd
				UsuarioDAO dao = new UsuarioDAO();
				
				//popular aluno				
				
				usuario = dao.consultar(email);
				
				//criando sessão
				HttpSession session = request.getSession(true);
				
				//nome da sessão "aluno" abro espaço na memoria para colocar temporariamente algo na memoria
				session.setAttribute("usuario", usuario);
				
				rd = request.getRequestDispatcher("/usuarios.jsp");
				
				//executa o direcionamento
				
				rd.forward(request,response);				
			}
			
			else if(cmd.equalsIgnoreCase("alterar")) { 
			
			  String nome = request.getParameter("txtNome");
				
				String email = request.getParameter("txtEmail");

				String senha = request.getParameter("txtSenha");  
			

				//criar o objeto para mandar para o banco pq ele não trabalha com dados soltos
				
				Usuario usuario = new Usuario();
				//populando o objeto
				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setSenha(senha);
				//mandar para o banco
				
				UsuarioDAO dao = new UsuarioDAO();
				
				//chamo o metodo que grava
				dao.update(usuario);
				
				rd=request.getRequestDispatcher("ServletUsuario?cmd=listarTodos");
				rd.forward(request,response);
			}
			
			else if(cmd.equalsIgnoreCase("consultaExcluir")) { 
				String email = request.getParameter("txtEmail"); //pega dados
				//receber um aluno da consulta
				Usuario usuario = new Usuario();
				//chama o objeto dao
				UsuarioDAO dao = new UsuarioDAO();
				//consultar
				usuario = dao.consultar(email);
				HttpSession session = request.getSession(true);
				//nome da sessão "aluno" abro espaço na memoria para colocar temporariamente algo na memoria
				session.setAttribute("usuario", usuario);
				rd = request.getRequestDispatcher("/formExcluirUsuario.jsp");
				//executa o direcionamento
				rd.forward(request,response);				
			}
						
			else if(cmd.equalsIgnoreCase("consultaUsuario")) {
								
				String nome  = request.getParameter("usuario");
				String senha  = request.getParameter("senha");
				
				Usuario usuario = new Usuario();
				
				if(!nome.isEmpty() && !senha.isEmpty()) {
				
				UsuarioDAO dao = new UsuarioDAO();
				usuario = dao.consultarCadastro(nome, senha);
					
					try {
				
						if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
							
							rd = request.getRequestDispatcher("/administrativo.jsp");
							rd.forward(request,response);
						
						}
					}catch(Exception e) {
						rd = request.getRequestDispatcher("/login.jsp");
						rd.forward(request,response);
					}
				
				}else {
					rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request,response);
				}				
			}		
			
			else if(cmd.equalsIgnoreCase("excluir")) {
				String email = request.getParameter("txtEmail");
				//mandar para o banco
				UsuarioDAO dao = new UsuarioDAO();
				//chamo o metodo que grava
				dao.delete(email);
				//chamar o listar todos
				rd=request.getRequestDispatcher("ServletUsuario?cmd=listarTodos");
				rd.forward(request,response);
			}
			
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entro aqui manda para o primeiro metodo
		processRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entro aqui manda para o primeiro metodo
		processRequest(request,response);
	}

}