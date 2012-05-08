package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/painel.jsp")
public class PainelDeControleFilter implements Filter {
	private FilterConfig fc = null;
	
	public void destroy() {
		fc = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {					
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fc) throws ServletException {
		this.fc = fc;
	}

	public FilterConfig getFc() {
		return fc;
	}
}
