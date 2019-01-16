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

import beans.Produto;
import dao.ProdutoDAO;


@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		Produto produto = new Produto();
		
		RequestDispatcher rd = null;
		if(cmd != null) {
			try {
				produto.setCodigo(Integer.parseInt(request.getParameter("txtCodigo")));
				produto.setProduto(request.getParameter("txtProduto"));
				produto.setPreco(request.getParameter("txtPreco"));
				produto.setCategoria(request.getParameter("txtCategoria"));
				produto.setFoto(request.getParameter("foto"));
				produto.setDescricao(request.getParameter("txtDescricao"));	
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			if(cmd.equalsIgnoreCase("incluir")) { 			
				ProdutoDAO dao = new ProdutoDAO();
				dao.create(produto);				
				rd=request.getRequestDispatcher("ServletProduto?cmd=listarTodos");
				rd.forward(request,response);
			}
			else if(cmd.equalsIgnoreCase("listarCatProduto")) {
				
				ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
				ProdutoDAO dao = new ProdutoDAO();				
				listaProduto = dao.listTodas();
				rd = request.getRequestDispatcher("/produtos.jsp");
				request.setAttribute("listaProduto", listaProduto);
				rd.forward(request,response);
				
			}
			
			else if(cmd.equalsIgnoreCase("listarTodos")) {				
				ArrayList<Produto> listaProduto = new ArrayList<Produto>();				
				ProdutoDAO dao = new ProdutoDAO();				
				listaProduto = dao.listTodas();
				rd = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("listaProduto", listaProduto);
				rd.forward(request,response);
				
			}
			else if(cmd.equalsIgnoreCase("listarTodosProdutos")) {				
				ArrayList<Produto> listaProduto= new ArrayList<Produto>();			
				ProdutoDAO dao = new ProdutoDAO();				
				listaProduto = dao.listTodas();
				rd = request.getRequestDispatcher("/mostrarListaProduto.jsp");
				request.setAttribute("listaProduto", listaProduto);
				rd.forward(request,response);
				
			}
			else if(cmd.equalsIgnoreCase("todosTratores")) {				
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();							
					listaProduto = dao.listAll("Tratores");				
					rd = request.getRequestDispatcher("/tratores.jsp");
					request.setAttribute("listaProduto", listaProduto);
					rd.forward(request,response);						
				}
			else if(cmd.equalsIgnoreCase("todasMotos")) {					
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();								
					listaProduto = dao.listAll("Motos");
					rd = request.getRequestDispatcher("/motos.jsp");
					request.setAttribute("listaProduto", listaProduto);				
					rd.forward(request,response);						
				}
			else if(cmd.equalsIgnoreCase("todasBonecas")) {				
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();								
					listaProduto = dao.listAll("Bonecas");
					rd = request.getRequestDispatcher("/bonecas.jsp");
					request.setAttribute("listaProduto", listaProduto);				
					rd.forward(request,response);						
			}
			else if(cmd.equalsIgnoreCase("todosHelicopteros")) {				
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();								
					listaProduto = dao.listAll("Helicopteros");
					rd = request.getRequestDispatcher("/helicopteros.jsp");
					request.setAttribute("listaProduto", listaProduto);				
					rd.forward(request,response);						
				}
			else if(cmd.equalsIgnoreCase("todosJogos")) {				
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();							
					listaProduto = dao.listAll("Jogos");
					rd = request.getRequestDispatcher("/jogos.jsp");
					request.setAttribute("listaProduto", listaProduto);				
					rd.forward(request,response);						
				}			
			else if(cmd.equalsIgnoreCase("todosCaminhoes")) {				
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();			
					listaProduto = dao.listAll("Caminhoes");
					rd = request.getRequestDispatcher("/caminhoes.jsp");
					request.setAttribute("listaProduto", listaProduto);				
					rd.forward(request,response);						
				}
			else if(cmd.equalsIgnoreCase("todasCozinhas")) {				
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();			
					listaProduto = dao.listAll("Cozinhas");
					rd = request.getRequestDispatcher("/cozinhas.jsp");
					request.setAttribute("listaProduto", listaProduto);				
					rd.forward(request,response);						
				}
			else if(cmd.equalsIgnoreCase("todasPraia")) {				
					ArrayList<Produto> listaProduto= new ArrayList<Produto>();				
					ProdutoDAO dao = new ProdutoDAO();								
					listaProduto = dao.listAll("Praia");
					rd = request.getRequestDispatcher("/praia.jsp");
					request.setAttribute("listaProduto", listaProduto);				
					rd.forward(request,response);						
				}
			
			else if(cmd.equalsIgnoreCase("consultaAlterar")) { 
	
				String codigo = request.getParameter("txtCodigo");				
				ProdutoDAO dao = new ProdutoDAO();
				produto = dao.consultar(codigo);
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);				
				rd = request.getRequestDispatcher("/alteraProduto.jsp");
				rd.forward(request,response);				
				
			}
			
			else if(cmd.equalsIgnoreCase("alterar")) { 

				ProdutoDAO dao = new ProdutoDAO();
				dao.update(produto);				
				HttpSession session = request.getSession(true);
				session.setAttribute("listaProduto", produto);
				
				rd=request.getRequestDispatcher("ServletProduto?cmd=listarTodosProdutos");
				rd.forward(request,response);
			}
			//Executado quando clicado em um produto Exibe detalhe
			else if(cmd.equalsIgnoreCase("consultaProduto")) { 
				ProdutoDAO dao = new ProdutoDAO();
				produto = dao.consultar(request.getParameter("codProduto"));
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);
				rd = request.getRequestDispatcher("/detalheProduto.jsp");
				//executa o direcionamento
				rd.forward(request,response);				
			}
			
			else if(cmd.equalsIgnoreCase("excluir")) {
				String codigo = request.getParameter("txtCodigo");
				ProdutoDAO dao = new ProdutoDAO();
				dao.delete(codigo);
				rd=request.getRequestDispatcher("ServletProduto?cmd=listarTodos");
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