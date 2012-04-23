package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import dao.DAOTask;

@WebServlet("/add.do")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOTask tdao = new DAOTask();
		Task task = new Task(request.getParameter("name"));
		tdao.begin();
		tdao.persist(task);
		tdao.commit();
		tdao.close();
	}
}
