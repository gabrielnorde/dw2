package MVC.Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Sistema.comando.Comando;

/**
 * Servlet implementation class ControleServlet
 */
@WebServlet("/controle")
public class ControleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request,
							HttpServletResponse response)
									throws ServletException, IOException {
		String parametro = request.getParameter("comando");
		String nomeClasse = "Sistema.comando" + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			Comando comando = (Comando) classe.newInstance();
			String visao = comando.execute(request, response);
			getServletContext().getRequestDispatcher(visao).forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}






