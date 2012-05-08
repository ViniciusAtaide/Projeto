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

import model.Album;
import model.Autor;
import model.Estilo;
import model.Musica;
import model.Usuario;
import dao.DAOAlbum;
import dao.DAOAutor;
import dao.DAOEstilo;
import dao.DAOMusica;
import dao.DAOUsuario;

@WebFilter("/index.jsp")
public class IndexFilter implements Filter {
	private FilterConfig fc = null;
	
    public IndexFilter() {
    }

	public void destroy() {
		fc = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		DAOUsuario udao = new DAOUsuario();
		DAOMusica mdao = new DAOMusica();
		DAOAlbum adao = new DAOAlbum();
		DAOEstilo edao = new DAOEstilo();
		DAOAutor audao = new DAOAutor();
				
		List<Usuario> usuarios = udao.findAll();		
		List<Musica> musicas = mdao.findAll();
		List<Album> albuns = adao.findAll();
		List<Estilo> estilos = edao.findAll();
		List<Autor> autores = audao.findAll();
				
		request.setAttribute("musicas", musicas);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("albuns", albuns);
		request.setAttribute("estilos", estilos);
		request.setAttribute("autores", autores);
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fc) throws ServletException {
		this.fc = fc;
	}

	public FilterConfig getFc() {
		return fc;
	}

}
