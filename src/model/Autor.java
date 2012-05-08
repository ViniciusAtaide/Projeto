package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Autor {
	private String nome;
	private String biografia;
	
	@ManyToMany(mappedBy="autores")
	private List<Album> albuns;
	@ManyToMany
	private List<Musica> musicas;
	
	public Autor(){}
	public Autor(String nome, String biografia) {
		this.nome = nome;
		this.biografia = biografia;
		albuns = new ArrayList<Album>();
		musicas = new ArrayList<Musica>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public void addAlbum(Album album) {
		albuns.add(album);
	}
	public void removeAlbum(Album album) {
		albuns.remove(album);
	}
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}
	public void removeMusica(Musica musica) {
		musicas.remove(musica);
	}
}
