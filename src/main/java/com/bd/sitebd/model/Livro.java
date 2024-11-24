package com.bd.sitebd.model;

import java.math.BigDecimal;

public class Livro {
    
    private int id;
    private String titulo;
    private String autor;
    private int AnoLancamento;
    private BigDecimal preco;

    public Livro(){
        
    }

    //Sobrecarga dos construtores Cliente
    public Livro(int id, String autor, String titulo, int AnoLancamento, BigDecimal preco) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.AnoLancamento = AnoLancamento;
        this.preco = preco;
    }
    public Livro(String autor, String titulo, int AnoLancamento, BigDecimal preco) {
        this.autor = autor;
        this.titulo = titulo;
        this.AnoLancamento = AnoLancamento;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoLancamento() {
        return AnoLancamento;
    }

    public void setAnoLancamento(int AnoLancamento) {
        this.AnoLancamento = AnoLancamento;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }    

    

    
}