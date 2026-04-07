package com.prova.prova.controller;

import com.prova.prova.model.Produto;
import com.prova.prova.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoRepository repo;

    @Autowired

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto p) {
        Produto salvo = repo.save(p);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Produto> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        Optional<Produto> prod = repo.findById(id);
        if (prod.isPresent()) {
            return ResponseEntity.ok(prod.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto p) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        p.setId(id);
        Produto atualizado = repo.save(p);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
