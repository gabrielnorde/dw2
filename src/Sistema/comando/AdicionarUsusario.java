package Sistema.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.dao.UsuarioDAO;
import MVC.Modelo.Usuario;

public class AdicionarUsuario implements Comando {

	@Override
	public String execute(HttpServletRequest request,
							HttpServletResponse response)
											throws Exception {
		Usuario usuario = new Usuario();
		usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		usuario.setNome(request.getParameter("nivel"));
		usuario.setusername(Double.parseDouble(request.getParameter("username")));
   		usuario.setSenha(Double.parseDouble(request.getParameter("senha")));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserir(usuario);
		List<Usuario> usuarios = usuarioDAO.get();
		request.setAttribute("usuarios", usuario);
		return "/admin.jsp";
	}
	
	

}
