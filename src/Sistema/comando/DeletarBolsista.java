package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.BolsistaDAO;
import MVC.Modelo.Bolsista;

public class DeletarBolsista implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Bolsista bolsista = new Bolsista();
		bolsista.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		BolsistaDAO bolsistaDAO = new BolsistaDAO();
		bolsistaDAO.remove(bolsista);
		List<Bolsista> bolsistas = bolsistaDAO.get();
		request.setAttribute("bolsistas", bolsista);
		return "/admin.jsp";
	}
	
	

}
