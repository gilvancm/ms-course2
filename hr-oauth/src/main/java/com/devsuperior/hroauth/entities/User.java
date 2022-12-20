package com.devsuperior.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//fazendo o mapiamento do JPA criando a tabela no banco

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	//email não se repete
	//@Column(unique = true)
	private String email;
	private String password;
	
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
