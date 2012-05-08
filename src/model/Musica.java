package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Musica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String titulo;
	private String comentario;
	
	@ManyToMany
	private List<Usuario> usuarios;
	@ManyToMany(mappedBy="musicas")
	private List<Autor> autores;
	@OneToMany(mappedBy="musica")
	private List<MiniPost> miniposts;
	
	@ManyToOne
	private Estilo estilo;
	@ManyToOne
	private Album album;
	
	public Musica(){}
	public Musica(Usuario usuario, Autor autor, Estilo estilo, Album album, String titulo) {				
		this.titulo = titulo;
		this.estilo = estilo;
		this.album = album;
		usuarios = new ArrayList<Usuario>();
		autores = new ArrayList<Autor>();
		miniposts = new ArrayList<MiniPost>();
		usuarios.add(usuario);
		usuario.addMusica(this);
	}	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setConteudo(String comentario) {
		this.comentario = comentario;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	public void addMiniPost(MiniPost minipost) {
		miniposts.add(minipost);
	}
	public void removeMiniPost(MiniPost minipost) {
		miniposts.remove(minipost);
	}
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	public void removeUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}
	public void addAutor(Autor autor) {
		autores.add(autor);
	}
	public void removeAutor(Autor autor) {
		autores.remove(autor);
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
