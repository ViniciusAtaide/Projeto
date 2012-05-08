package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estilo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy="estilo")
	private List<Musica> musicas;
	@OneToMany(mappedBy="estilo")
	private List<Album> albuns;
	
	public Estilo(){}
	public Estilo(String nome, ArrayList<Musica> musicas, ArrayList<Album> albuns) {
		this.nome = nome;
		this.musicas = musicas;
		this.albuns = albuns;
		musicas = new ArrayList<Musica>();
		albuns = new ArrayList<Album>();
	}
	public Estilo(String nome) {
		this.nome = nome;
		musicas = new ArrayList<Musica>();
		albuns = new ArrayList<Album>();
	}
	public int getId() {
		return this.id;
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
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}
	public void removeMusica(Musica musica) {
		musicas.remove(musica);
	}
	public void addAlbum(Album album) {
		albuns.add(album);
	}
	public void removeAlbum(Album album) {
		albuns.remove(album);
	}
}
