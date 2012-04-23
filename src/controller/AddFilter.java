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

import model.Task;

import dao.DAOTask;

@WebFilter(urlPatterns = {"add.do"})
public class AddFilter implements Filter {
	private FilterConfig fc;
	
    public AddFilter() {
    }

	public void destroy() {
		fc = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		DAOTask tdao = new DAOTask();
		List<Task> tasks = tdao.findAll();
		// Check if task is blank
		if (request.getParameter("name").equals(null)) {
			request.setAttribute("error_message", "The name cant be blank.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		// Check if task have same name with another
		for (Task task : tasks) {
			if (request.getParameter("name").equals(task.getName())) {
				request.setAttribute("error_message", "The name is already taken.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fc) throws ServletException {
		this.fc = fc;
	}

}
