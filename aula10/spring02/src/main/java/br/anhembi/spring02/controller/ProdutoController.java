package br.anhembi.spring02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring02.model.Produto;
import br.anhembi.spring02.repository.ProdutoRepo;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepo repo;

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
        Produto novoProduto =  repo.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);

    }

}
