package com.gabriel.projeto.endpoint;

import com.gabriel.projeto.domain.Tarefa;
import com.gabriel.projeto.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "tarefa")
public class TarefaEndPoint {

    private final TarefaService tarefaService;

    public TarefaEndPoint(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll() {
        return ResponseEntity.ok().body(tarefaService.findAll());
    }
    
    @GetMapping(value="/id")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(tarefaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody  Tarefa tarefa){
        tarefaService.save(tarefa);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PatchMapping
    public ResponseEntity<Tarefa> alteraSituacaoTarefa(@RequestBody Tarefa tarefa){
    	return ResponseEntity.ok().body(tarefaService.alteraSituacaoTarefa(tarefa));
    }
    
    @PutMapping
    public ResponseEntity<Tarefa> updateTarefa(@RequestBody Tarefa tarefa){
    	return ResponseEntity.ok().body(tarefaService.updateTarefa(tarefa));
    }
    
    @DeleteMapping(value="/id")
    public ResponseEntity<Tarefa> deleteTarefa(@RequestBody Long id){
    	tarefaService.deleteTarefa(id);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
