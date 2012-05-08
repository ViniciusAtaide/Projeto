package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import model.Usuario;

import dao.DAOUsuario;

@WebFilter(urlPatterns = {"/loga.do"})
public class LoginFilter implements Filter {
	private FilterConfig fc = null;
	
	public void destroy() {
		fc = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		DAOUsuario tdao = new DAOUsuario();
		List<Usuario> usuarios = tdao.findAll();
		
		if (request.getParameter("login").equals("")) {			
			request.setAttribute("mensagemerro","Login não pode ser branco");
			request.getRequestDispatcher("index.jsp");
			return;
		}
		
		for (Usuario usuario : usuarios) {
			if (request.getParameter("login").equals(usuario.getLogin())) {
				request.setAttribute("mensagemerro", "Nome já utilizado.");
				request.getRequestDispatcher("index.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fc) throws ServletException {
		this.fc = fc;
	}

	public FilterConfig getFc() {
		return fc;
	}
}
