package dao;

import java.util.List;

import model.Musica;

public class DAOMusica extends DAOJPA<Musica> {
	public DAOMusica() {
		super();
	}
	@SuppressWarnings("unchecked")
	public List<Musica> findByTitulo(String titulo) {
		return (List<Musica>) super.findAllByQuery("select m from Musica m where m.titulo ='" + titulo +"%' ");
	}
}
