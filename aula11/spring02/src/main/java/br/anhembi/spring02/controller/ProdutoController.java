package br.anhembi.spring02.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.anhembi.spring02.model.Produto;

import br.anhembi.spring02.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
        Produto novoProduto = service.inserir(produto);
        if(novoProduto != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        Produto novoProduto = service.atualizarCompleto(produto);
        if(novoProduto != null){
            return ResponseEntity.status(HttpStatus.OK).body(novoProduto);
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> updateParcial(@RequestBody Produto produto, @PathVariable int id) {
        Produto novoProduto = service.atualizarParcial(produto, id);
        if(novoProduto != null){
            return ResponseEntity.status(HttpStatus.OK).body(novoProduto);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable int id) {
        Optional<Produto> optional = service.buscarPorId(id);

        if(optional.isPresent()) {
            // retorna o produto encontrado (get) com status 200 (ok)
            return ResponseEntity.ok(optional.get());
        }
        // se não encontrou o produto, retorna 'not found' (404)
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtos = service.listarTodos();

        if(produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos);
    }


    @GetMapping("/venda/{id}")
    public ResponseEntity<Produto> buscarPrecoVenda(@PathVariable int id) {
        Optional<Produto> optional = service.buscarPrecoVenda(id);

        if(optional.isPresent()) {
            // retorna o produto encontrado (get) com status 200 (ok)
            return ResponseEntity.ok(optional.get());
        }
        // se não encontrou o produto, retorna 'not found' (404)
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable int id) {
        boolean sucesso = service.apagar(id);
        if(sucesso) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
