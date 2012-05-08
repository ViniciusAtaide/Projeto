package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import dao.DAOUsuario;

@WebServlet("/loga.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUsuario tdao = new DAOUsuario();
		Usuario usuario = null;
		 
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");  
		
		usuario = tdao.findByLoginAndSenha(login, senha);
		if (usuario != null) {
			session.setAttribute("mod",usuario.getId());		
			session.setAttribute("usuario", usuario);
		} else {
			request.setAttribute("mensagemerro","Usuario Nao Encontrado!");
		}
		response.sendRedirect("index.jsp");
	}

}
