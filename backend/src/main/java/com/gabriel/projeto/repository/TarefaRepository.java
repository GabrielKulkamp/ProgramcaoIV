package com.gabriel.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.projeto.domain.Projeto;
import com.gabriel.projeto.domain.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa ,Integer> {
	
	List<Tarefa> findByProjeto(Projeto projeto);
}
