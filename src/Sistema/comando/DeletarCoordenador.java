package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.CoordenadorDAO;
import MVC.Modelo.Coordenador;

public class DeletarCoordenador implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Coordenador coordenador = new Coordenador();
		coordenador.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		coordenadorDAO.remove(coordenador);
		List<Coordenador> coordenadores = coordenadorDAO.get();
		request.setAttribute("Coordenadores", coordenador);
		return "/admin.jsp";
	}
	
	

}
