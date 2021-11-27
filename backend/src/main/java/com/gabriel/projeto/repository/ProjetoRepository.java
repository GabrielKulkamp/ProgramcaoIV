package com.gabriel.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.projeto.domain.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto ,Integer> {
}
