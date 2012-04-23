package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import dao.DAOTask;

/**
 * Servlet implementation class DeleteUpdateServlet
 */
@WebServlet("/updatedelete.do")
public class UpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateDeleteServlet() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOTask tdao = new DAOTask();
		String[] taskschecked = request.getParameterValues("Tasks");
		int i=0;
		List<Task> tasks = tdao.findAll();
		for(Task task : tasks) {
			task.setDone(true);
		}
		tdao.begin();
		
		if (request.getAttribute("updatedelete").equals("Mark selected as done")) {					
		}
		if (request.getAttribute("updatedelete").equals("Delete selected")) {
			tdao.deleteByName(request.getParameter("tasks[]"));
		}
		tdao.commit();
		tdao.close();
		response.sendRedirect("index.jsp");
	}
}
