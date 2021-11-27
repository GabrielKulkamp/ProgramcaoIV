package com.gabriel.projeto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.gabriel.projeto.domain.Projeto;
import com.gabriel.projeto.repository.ProjetoRepository;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Projeto save(Projeto projeto){
        return projetoRepository.save(projeto);
    }
    
    public Projeto findById(Integer id) {
    	return projetoRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Projeto com id:" + id + " não existe!"));
    }
    
    public Projeto updateProjeto(Projeto projeto) {
    	Projeto projetoUpdate = this.findById(projeto.getId());
    	
    	if(projeto.getNome() != null && !projeto.getNome().equals("")) {
    		projetoUpdate.setNome(projeto.getNome());
    	}
    	
    	return projetoRepository.save(projetoUpdate);
    }
    
    public void deleteProjeto(Integer id){
        projetoRepository.deleteById(id);
    }
}
