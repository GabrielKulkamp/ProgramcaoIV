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

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> save (@RequestBody  Tarefa tarefa){
        tarefaService.save(tarefa);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
