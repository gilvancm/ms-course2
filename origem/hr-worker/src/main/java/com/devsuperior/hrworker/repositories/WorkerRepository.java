package com.devsuperior.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hrworker.entities.Worker;

//WorkerRepository ele buscas as funções do JPA
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
