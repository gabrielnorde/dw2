package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.BolsistaDAO;
import MVC.Modelo.Bolsista;

public class AtualizarBolsista implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Bolsista bolsista = new Bolsista();
		bolsista.setId(Integer.parseInt(request.getParameter("codigo")));
		bolsista.setNome(request.getParameter("nome"));
		bolsista.setCPF(Double.parseDouble(request.getParameter("CPF")));
   		bolsista.setCurso(Double.parseDouble(request.getParameter("curso")));
		BolsistaDAO bolsistaDAO = new BolsistaDAO();
		bolsistaDAO.update(bolsista);
		List<Bolsista> bolsistas = bolsistaDAO.get();
		request.setAttribute("bolsistas", bolsista);
		return "/admin.jsp";
	}
	
	

}
