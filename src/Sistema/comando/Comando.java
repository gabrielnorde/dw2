package dw.loja.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comando {
	
	public String execute(HttpServletRequest request,
							HttpServletResponse response) throws Exception;

}
