package br.anhembi.spring02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // indica que terá uma tabela no BD para essa classe
public class Produto {
    @Id // indica chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3 ...
    private int codigo;
    private String nome;
    private double valor;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
