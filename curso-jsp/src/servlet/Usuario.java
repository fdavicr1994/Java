package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Bean;
import dao.DaoUsuario;


@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DaoUsuario daoUsuario = new DaoUsuario();

    public Usuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");
			
			if(acao.equalsIgnoreCase("delete")){
				daoUsuario.delete(user);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}
			else if(acao.equalsIgnoreCase("editar")){
				Bean bean = daoUsuario.consultar(user);
				
				//daoUsuario.atualizar(user);;
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", bean);
				view.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Bean usuario = new Bean();
		
		usuario.setId(!id.isEmpty()? Long.parseLong(id) : 0);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		if(id == null || id.isEmpty()){
			daoUsuario.Salvar(usuario);
		}
		else{
			daoUsuario.atualizar(usuario);
		}
		
		try{
			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listar());
			view.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
