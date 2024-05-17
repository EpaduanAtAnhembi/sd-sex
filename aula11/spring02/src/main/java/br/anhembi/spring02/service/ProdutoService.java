package br.anhembi.spring02.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.Produto;
import br.anhembi.spring02.repository.ProdutoRepo;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepo repo;

    public Produto inserir(Produto produto) {
        if(produto.getCodigo() > 0){
            return null;
        }
        Produto novoProduto = repo.save(produto);

        return novoProduto;
    }

    public Produto atualizarCompleto(Produto produto) {
        if(produto.getCodigo() == 0) {
            return null;
        }
        return repo.save(produto);
    }

    public Produto atualizarParcial(Produto produto, int codigo) {
        if(codigo == 0) {
            return null;
        }

        Optional<Produto> optinal = repo.findById(codigo);
        if(optinal.isEmpty()) {
            return null;
        }
        Produto produtoAtual = optinal.get();

        if(produto.getNome() != null) {
            produtoAtual.setNome(produto.getNome());
        }
        if(produto.getValor() > 0){
            produtoAtual.setValor(produto.getValor());
        }

        return repo.save(produtoAtual);
    }

    public Optional<Produto> buscarPorId(int id) {
        return repo.findById(id);
    }

    public List<Produto> listarTodos() {
        return (List<Produto>) repo.findAll();
    }

    public Optional<Produto> buscarPrecoVenda(int id) {
        Optional<Produto> produto = repo.findById(id);

        if(produto.isPresent()) {
            double valor = produto.get().getValor();
            valor = valor * 1.1;
            produto.get().setValor(valor);
        }

        return produto;
    }

    public boolean apagar(int id) {
        Optional<Produto> produto = repo.findById(id);
        if(produto.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
