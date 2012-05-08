package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	private String nome;
	private String sobre;
	
	@ManyToOne
	private Estilo estilo;
	@ManyToMany
	private List<Musica> musicas;
	@ManyToMany
	private List<Autor> autores;
		
	public Album(){}
	public Album(String nome, String sobre, Autor autor) {
		this.nome = nome;
		this.sobre = sobre;
		autores = new ArrayList<Autor>();
		musicas = new ArrayList<Musica>();
		autores.add(autor);
		autor.addAlbum(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}
	public void removeMusica(Musica musica) {
		musicas.remove(musica);
	}
	public void addAutor(Autor autor) {
		autores.add(autor);
	}
	public void removeAutor(Autor autor) {
		autores.remove(autor);
	}
}
