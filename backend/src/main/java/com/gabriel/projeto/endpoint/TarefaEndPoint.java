package com.gabriel.projeto.endpoint;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.projeto.domain.Tarefa;
import com.gabriel.projeto.service.TarefaService;

@RestController
@RequestMapping(value = "tarefa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefaEndPoint {

    private final TarefaService tarefaService;

    public TarefaEndPoint(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }
    
    @GetMapping(value="/noproject")
    public List<Tarefa> findAllSemProjeto(){
    	return tarefaService.findAllSemProjeto();
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll() {
        return ResponseEntity.ok().body(tarefaService.findAll());
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(tarefaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Tarefa> save (@RequestBody  Tarefa tarefa){
        return  ResponseEntity.ok().body(tarefaService.save(tarefa));
    }
    
    @PatchMapping(value="/set-pendente/{id}")
    public ResponseEntity<Tarefa> alteraSituacaoTarefa(@PathVariable Integer id){
    	return ResponseEntity.ok().body(tarefaService.pendenteTarefa(id));
    }
    
    @PatchMapping(value="/set-concluido/{id}")
    public ResponseEntity<Tarefa> concluirTarefa(@PathVariable Integer id){
    	return ResponseEntity.ok().body(tarefaService.concluirTarefa(id));
    }
    
    @PutMapping(value="/update")
    public ResponseEntity<Tarefa> updateTarefa(@RequestBody Tarefa tarefa){
    	return ResponseEntity.ok().body(tarefaService.updateTarefa(tarefa));
    }
    
    @DeleteMapping(value="/remove/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Integer id){
    	tarefaService.deleteTarefa(id);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
