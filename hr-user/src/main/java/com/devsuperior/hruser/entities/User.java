package com.devsuperior.hruser.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//fazendo o mapiamento do JPA criando a tabela no banco
@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	
	//Role função ou perfíl
	//vamos mapiar associação de muitos para muitos, vamos tger criar a tabela de associação das duas
	//EAGER = ancioso , queremo que o perfius carregue junto ao usuario
	//para criar a tabela de associação @ManyToMany e o @JoinTable() cria a tabelinha do meio
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role",
	     joinColumns = @JoinColumn(name = "user_id"), //coluna dessa class
	     inverseJoinColumns = @JoinColumn(name = "role_id") //coluna de outra class
	)
	
	
	//vamos criar as associações e seu get, vai ser um interface SET que é um conjunto não se repete
	//Set é interface e a HashSet<>() é a classe
	private Set<Role> roles = new HashSet<>();  //lembrar de criar o get
	
	
	public User() {
		
	}


	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
