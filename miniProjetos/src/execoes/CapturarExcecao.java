package execoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/CapturarExcecao")
public class CapturarExcecao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CapturarExcecao() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			System.out.println(request.getParameter("valorParam"));
			
			response.setStatus(200);//Ok
			response.getWriter().write("Processado com Sucesso!");
		}catch(Exception e){
			response.setStatus(500);//Erro interno do servidor
			response.getWriter().write("Erro ao processar: " + e.getMessage());
		}
	}

}
