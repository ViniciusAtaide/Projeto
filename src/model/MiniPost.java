package model;

import javax.persistence.*;

@Entity
public class MiniPost {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private String titulo;
	private String conteudo;
	
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Musica musica;
	
	public MiniPost(){}
	public MiniPost(Usuario usuario, String titulo, String conteudo) {
		this.usuario = usuario;
		this.titulo = titulo;
		this.conteudo = conteudo;		
	}	
	public MiniPost(Usuario usuario, Musica musica, String titulo, String conteudo) {
		this.usuario = usuario;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.musica = musica;
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {		
		this.conteudo = conteudo;
	}	
}
