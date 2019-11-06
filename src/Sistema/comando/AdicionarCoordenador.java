package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.CoordenadorDAO;
import MVC.Modelo.Coordenador;

public class AdicionarCoordenador implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Coordenador coordenador = new Coordenador();
		coordenador.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		coordenador.setNome(request.getParameter("nome"));
		consultor.setCPF(request.getParameter("CPF"))
		coordenador.setEmail(Double.parseDouble(request.getParameter("email")));
   		coordenador.setRua(Double.parseDouble(request.getParameter("rua")));
        coordenador.setNumero(Integer.parseInt(request.getParameter("numero")));
		coordenador.setBairro(request.getParameter("bairro"));
		coordenador.setCidade(Double.parseDouble(request.getParameter("cidade")));
   		coordenador.setEstado(Double.parseDouble(request.getParameter("estado")));
		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		coordenadorDAO.inserir(coordenador);
		List<Coordenador> coordenador = CoordenadorDAO.get();
		request.setAttribute("coordenadores", coordenador);
		return "/admin.jsp";
	}
	
	

}
