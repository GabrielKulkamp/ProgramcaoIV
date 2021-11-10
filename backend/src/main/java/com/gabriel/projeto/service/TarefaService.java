package com.gabriel.projeto.service;

import com.gabriel.projeto.domain.Tarefa;
import com.gabriel.projeto.repository.TarefaRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
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
}
