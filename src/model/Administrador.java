package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Administrador extends Usuario {
	public Administrador() {}
	public Administrador(String login, String senha) {
		super(login,senha);
	}
}
