package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import dao.DAOUsuario;

@WebServlet("/cadastra.do")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUsuario udao = new DAOUsuario();
		List<Usuario> usuarios = udao.findAll();

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)) {
				request.setAttribute("mensagemerro", "Login já cadastrado.");
				response.sendRedirect("index.jsp");
				return;
			}
		}
		Usuario usu = new Usuario(login,senha);
		udao.begin();
		udao.persist(usu);
		udao.commit();
		udao.close();
		response.sendRedirect("index.jsp");
	}
}
