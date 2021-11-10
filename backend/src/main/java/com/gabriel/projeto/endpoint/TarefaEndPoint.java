package com.gabriel.projeto.endpoint;

import com.gabriel.projeto.domain.Tarefa;
import com.gabriel.projeto.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<Void> save (@Valid @RequestBody  Tarefa tarefa){
        tarefa = tarefaService.save(tarefa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }
}
