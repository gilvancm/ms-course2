package com.devsuperior.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//vamos acresentar uma assisnatura, busca custamizadas por email
	//para pesquina na internet Spring data jpa veja os metodos lá Query methods
      User findByEmail(String email);   	
}
