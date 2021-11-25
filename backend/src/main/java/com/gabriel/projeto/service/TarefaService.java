package com.gabriel.projeto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.gabriel.projeto.domain.Tarefa;
import com.gabriel.projeto.repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Tarefa save(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }
    
    public Tarefa findById(Long id) {
    	return tarefaRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Tarefa com id:" + id + " não existe!"));
    }
    
    public Tarefa alteraSituacaoTarefa(Tarefa tarefa) {
    	Tarefa tarefaBanco = this.findById(tarefa.getId());
    	tarefaBanco.setFinalizado(tarefa.isFinalizado());
    	return tarefaRepository.save(tarefaBanco);
    }
    
    public Tarefa updateTarefa(Tarefa tarefa) {
    	Tarefa tarefaUpdate = this.findById(tarefa.getId());
    	
    	if(tarefa.getTitulo() != null && !tarefa.getTitulo().equals("")) {
    		tarefaUpdate.setTitulo(tarefa.getTitulo());
    	}
    	
    	if(tarefa.getDescricao() != null && !tarefa.getDescricao().equals("")) {
    		tarefaUpdate.setDescricao(tarefa.getDescricao());
    	}
    	
    	return tarefaRepository.save(tarefaUpdate);
    }
    
    public void deleteTarefa(Long id){
        tarefaRepository.deleteById(id);
    }
}
