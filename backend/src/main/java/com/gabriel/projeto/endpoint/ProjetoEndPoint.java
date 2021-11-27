package com.gabriel.projeto.endpoint;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.projeto.domain.Projeto;
import com.gabriel.projeto.service.ProjetoService;


@RestController
@RequestMapping(value = "projeto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjetoEndPoint {

    private final ProjetoService projetoService;

    public ProjetoEndPoint(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> findAll() {
        return ResponseEntity.ok().body(projetoService.findAll());
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(projetoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody  Projeto projeto){
        projetoService.save(projeto);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping(value="/update")
    public ResponseEntity<Projeto> updateProjeto(@RequestBody Projeto projeto){
    	return ResponseEntity.ok().body(projetoService.updateProjeto(projeto));
    }
    
    @DeleteMapping(value="/remove/{id}")
    public ResponseEntity<Projeto> deleteProjeto(@PathVariable Integer id){
    	projetoService.deleteProjeto(id);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
