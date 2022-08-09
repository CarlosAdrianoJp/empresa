package com.livmall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livmall.entities.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
	
	

}
