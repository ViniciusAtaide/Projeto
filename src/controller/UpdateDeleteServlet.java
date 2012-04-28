package controller;


import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		StringWriter str = new StringWriter();				
		tdao.begin();
		for (int i =0; i < taskschecked.length; i++) {
			str.write(taskschecked[i]+", ");
		}		
		if (request.getAttribute("updatedelete").equals("Mark selected as done")) {
			tdao.updateAll("UPDATE Task SET done = true WHERE id eq "+str.toString());
		}
		if (request.getAttribute("updatedelete").equals("Delete selected")) {
			tdao.deleteByName(request.getParameter("tasks[]"));
		}
		tdao.commit();
		tdao.close();
		response.sendRedirect("index.jsp");
	}
}
