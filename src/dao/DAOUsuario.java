package dao;

import model.Usuario;

public class DAOUsuario extends DAOJPA<Usuario> {
	public DAOUsuario() {
		super();
	}
	//Specific Queries
	
	public Usuario findByLogin(String login) {
		return (Usuario) super.findAllByQuery("select u from Usuario u where u.login ='" + login +"%' ");
	}
	public Usuario findByLoginAndSenha(String login, String senha) {
		return (Usuario) super.findAllByQuery("select u from Usuario u Where u.login = '"+login+"' and u.senha = '"+senha+"'");
	}
	public void deleteById(String id) {
		super.deleteAll("delete from Usuario u where u.id like'" + id +"' "); 
	}
}
