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
    
    public List<Tarefa> findAllSemProjeto(){
    	List<Tarefa> lista = tarefaRepository.findByProjeto(null);
        return lista;
    }

    public List<Tarefa> findAll() {
    	List<Tarefa> lista = tarefaRepository.findAll();
    	if(lista.isEmpty()) {
    		throw new EntityNotFoundException("Nenhuma tarefa encontrada");
    	}
        return lista;
    }

    public Tarefa save(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }
    
    public Tarefa findById(Integer id) {
    	return tarefaRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Tarefa com id:" + id + " não existe!"));
    }
    
    public Tarefa concluirTarefa(Integer id) {	
    	Tarefa tarefa = this.findById(id);
    	tarefa.setFinalizado(true);
    	return tarefaRepository.save(tarefa);
    }
    
    public Tarefa pendenteTarefa(Integer id) {
    	Tarefa tarefa = this.findById(id);
    	tarefa.setFinalizado(false);
    	return tarefaRepository.save(tarefa);
    }
    
    public Tarefa updateTarefa(Tarefa tarefa) {
    	Tarefa tarefaUpdate = this.findById(tarefa.getId());
    	tarefaUpdate.setTitulo(tarefa.getTitulo());
    	return tarefaRepository.save(tarefaUpdate);
    }
    
    public void deleteTarefa(Integer id){
        tarefaRepository.deleteById(id);
    }
}
