package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.DAO.CoordenadorDAO;
import MVC.Modelo.Coordenador;

public class AdicionarCoordenador implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Coordenador coordenador = new Coordenador();
		coordenador.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		coordenador.setNome(request.getParameter("nome"));
		coordenador.setCPF(request.getParameter("CPF"));
		coordenador.setEmail(request.getParameter("email"));
   		coordenador.setRua(request.getParameter("rua"));
        coordenador.setNumero(request.getParameter("numero"));
		coordenador.setBairro(request.getParameter("bairro"));
		coordenador.setCidade(request.getParameter("cidade"));
   		coordenador.setEstado(request.getParameter("estado"));
		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		coordenadorDAO.inserir(coordenador);
		List<Coordenador> coordenadores = CoordenadorDAO.get();
		request.setAttribute("coordenadores", coordenadores);
		return "/admin.jsp";
	}
	
	

}
