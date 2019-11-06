package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.ConsultorDAO;
import MVC.Modelo.Consultor;

public class AdicionarConsultor implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Consultor consultor = new Consultor();
		consultor.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		consultor.setNome(request.getParameter("nome"));
		consultor.setCPF(request.getParameter("CPF"))
		consultor.setEmail(Double.parseDouble(request.getParameter("email")));
   		consultor.setRua(Double.parseDouble(request.getParameter("rua")));
        consultor.setNumero(Integer.parseInt(request.getParameter("numero")));
		consultor.setBairro(request.getParameter("bairro"));
		consultor.setCidade(Double.parseDouble(request.getParameter("cidade")));
   		consultor.setEstado(Double.parseDouble(request.getParameter("estado")));
		ConsultorDAO consultorDAO = new ConsultorDAO();
		consultorDAO.inserir(consultor);
		List<Consultor> consultor = ConsultorDAO.get();
		request.setAttribute("consultores", consultor);
		return "/admin.jsp";
	}
	
	

}
