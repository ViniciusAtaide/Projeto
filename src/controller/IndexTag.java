package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.Task;

import dao.DAOTask;

public class IndexTag extends SimpleTagSupport {
	protected void doTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Task> tasks = new ArrayList<Task>();
		DAOTask tdao = new DAOTask();
		
		tasks = tdao.findAll();
		getJspContext().setAttribute("tasks", tasks);
	}
}
