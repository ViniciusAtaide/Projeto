package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String login;
	private String senha;
	
	@ManyToMany(mappedBy="usuarios")
	private List<Musica> musicas;
	@OneToMany(mappedBy="usuario")
	private List<MiniPost> miniposts;
	
	public Usuario() {}
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
		miniposts = new ArrayList<MiniPost>();
		musicas = new ArrayList<Musica>();
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}
	public void removeMusica(Musica musica) {
		musicas.remove(musica);
	}
	public void addMiniPost(MiniPost minipost) {
		miniposts.add(minipost);
	}
	public void removeMiniPost(MiniPost minipost) {
		miniposts.remove(minipost);
	}
	public List<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	public List<MiniPost> getMiniposts() {
		return miniposts;
	}
	public void setMiniposts(List<MiniPost> miniposts) {
		this.miniposts = miniposts;
	}	
}
