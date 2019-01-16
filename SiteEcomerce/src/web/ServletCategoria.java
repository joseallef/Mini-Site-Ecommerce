package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Categoria;
import dao.CategoriaDAO;


@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//receve a instrução de comando (incluir,alterar...)
		response.setContentType("text/html;charset=UTF-8");
		
		String cmd = request.getParameter("cmd"); //recebe do html a variavel escondida
		
		RequestDispatcher rd = null;
		
		//receber os dados da inclusão
			if(cmd.equalsIgnoreCase("incluir")) { 
				
				String nome = request.getParameter("txtNome");
				
				String codigo = request.getParameter("txtCodigo");
				
				String linha = request.getParameter("txtLinha");

				String faixa = request.getParameter("txtFaixa");
				
				//criar o objeto para mandar para o banco pq ele não trabalha com dados soltos
				
				Categoria categoria = new Categoria();
				//populando o objeto
				categoria.setNome(nome);
				categoria.setCodigo(Integer.parseInt(codigo));
				categoria.setLinha(linha);
				categoria.setFaixa(faixa);
				
				//mandar para o banco
				
				CategoriaDAO dao = new CategoriaDAO();
				
				//chamo o metodo que grava
				dao.create(categoria);
				
				rd=request.getRequestDispatcher("ServletCategoria?cmd=listarTodos");
				rd.forward(request,response);
			}
			
			else if(cmd.equalsIgnoreCase("listarTodos")) {
				
				ArrayList<Categoria> listaCategoria= new ArrayList<Categoria>();
				
				CategoriaDAO dao = new CategoriaDAO();
				
				listaCategoria = dao.listAll();
				
				//redireciona para uma nova pagina chama uma pagina 
				rd = request.getRequestDispatcher("/mostrarListaCategoria.jsp");
				
				//coloca a lista em uma sessão
				request.setAttribute("lista", listaCategoria);
				
				//executa o direcionamento
				
				rd.forward(request,response);
				
			}
			
			else if(cmd.equalsIgnoreCase("consultaAlterar")) { 
				
				//recebendo RGM
				String codigo = request.getParameter("txtCodigo");
				
				
				Categoria categoria = new Categoria();
				
				
				//abrindo bd
				CategoriaDAO dao = new CategoriaDAO();
				
				//popular aluno				
				
				categoria = dao.consultar(codigo);
				
				//criando sessão
				HttpSession session = request.getSession(true);
				
				//nome da sessão "aluno" abro espaço na memoria para colocar temporariamente algo na memoria
				session.setAttribute("categoria", categoria);
				
				rd = request.getRequestDispatcher("/alteraCategoria.jsp");
				
				//executa o direcionamento
				
				rd.forward(request,response);				
				
			}
			
			else if(cmd.equalsIgnoreCase("alterar")) { 
			
				String nome = request.getParameter("txtNome");
				
				String codigo = request.getParameter("txtCodigo");
				
				String linha = request.getParameter("txtLinha");

				String faixa = request.getParameter("txtFaixa");
				
				//criar o objeto para mandar para o banco pq ele não trabalha com dados soltos
				
			Categoria categoria = new Categoria();
				//populando o objeto
				categoria.setNome(nome);
				categoria.setLinha(linha);
				categoria.setFaixa(faixa);
				categoria.setCodigo(Integer.parseInt(codigo));
				
				//mandar para o banco
				
				CategoriaDAO dao = new CategoriaDAO();
				
				//chamo o metodo que grava
				dao.update(categoria);
				
				rd=request.getRequestDispatcher("ServletCategoria?cmd=listarTodos");
						
				rd.forward(request,response);
			}
			
			else if(cmd.equalsIgnoreCase("consultaExcluir")) { 
				String codigo = request.getParameter("txtCodigo"); //pega dados
				//receber um aluno da consulta
				Categoria categoria = new Categoria();
				//chama o objeto dao
				CategoriaDAO dao = new CategoriaDAO();
				//consultar
				categoria = dao.consultar(codigo);
				HttpSession session = request.getSession(true);
				//nome da sessão "aluno" abro espaço na memoria para colocar temporariamente algo na memoria
				session.setAttribute("categoria", categoria);
				rd = request.getRequestDispatcher("/formExcluirCategoria.jsp");
				//executa o direcionamento
				rd.forward(request,response);				
			}
			else if(cmd.equalsIgnoreCase("consultaCategoria")) { 
				String codigo = request.getParameter("txtCodigo"); //pega dados
				//receber um aluno da consulta
				Categoria categoria = new Categoria();
				//chama o objeto dao
				CategoriaDAO dao = new CategoriaDAO();
				//consultar
				categoria = dao.consultar(codigo);
				HttpSession session = request.getSession(true);
				//nome da sessão "aluno" abro espaço na memoria para colocar temporariamente algo na memoria
				session.setAttribute("categoria", categoria);
				rd = request.getRequestDispatcher("/formConsultarCategoria.jsp");
				//executa o direcionamento
				rd.forward(request,response);				
			}
			
			else if(cmd.equalsIgnoreCase("excluir")) {
				String codigo = request.getParameter("txtCodigo");
				System.out.println("Ser� "+codigo+" aqui o codigo");
				//mandar para o banco
				CategoriaDAO dao = new CategoriaDAO();
				//chamo o metodo que grava
				dao.delete(Integer.parseInt(codigo));
				//chamar o listar todos
				rd=request.getRequestDispatcher("ServletCategoria?cmd=listarTodos");
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