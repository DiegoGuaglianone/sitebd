package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    // CONEXAO É O SERVICE, OU SEJA, O FRONT SO ENXERGA AQUI, ENQUANTO O DAO É ESCONDIDO (A VIEW NAO O VÊ)
    
    @Autowired
    private LivroDAO livroDAO;

    public void inserir(Livro livro){
        livroDAO.inserir(livro);
    }

    public List<Map<String, Object>> obterTodosLivros(){
        return livroDAO.obterTodosLivros();
    }

    public void atualizarLivro(int id, Livro livro){
        livroDAO.atualizarLivro(id, livro);
    }

    public Livro obterLivro(int id){
        return livroDAO.obterLivro(id);
    }

    public void deletarLivro(int id){
        livroDAO.deletarLivro(id);
    }
}
