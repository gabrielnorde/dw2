package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.ConsultorDAO;
import MVC.Modelo.Consultor;

public class DeletarConsultor implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Consultor consultor = new Consultor();
		consultor.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		ConsultorDAO consultorDAO = new ConsultorDAO();
		consultorDAO.remove(consultor);
		List<Consultor> consultores = consultorDAO.get();
		request.setAttribute("Consultores", consultor);
		return "/admin.jsp";
	}
	
	

}
