package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.UsuarioDAO;
import MVC.Modelo.Usuario;

public class DeletarUsuario implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Usuario usuario = new Usuario();
		usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.remove(usuario);
		List<Usuario> coordenadores = coordenadorDAO.get();
		request.setAttribute("Coordenadores", coordenador);
		return "/admin.jsp";
	}
	
	

}
