package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class LivroDAO {
    /* DAO = Data Acssess Object */

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    //Inserir novo livro, cada parametro recebe seu get respectivo para o banco de dados
    public void inserir(Livro livro){
        String sql = "INSERT INTO livro(titulo, autor, ano_lancamento, preco) VALUES (?,?,?,?);";
        Object[] parametros = new Object[4];
        parametros[0] = livro.getTitulo();
        parametros[1] = livro.getAutor();
        parametros[2] = livro.getAnoLancamento();
        parametros[3] = livro.getPreco();
        jdbc.update(sql,parametros);
    }

    //[ {id: 1, titulo: teste, autor: teste}
    //, {id: 2, titulo: teste1, autor: teste1}
    //]
    public List<Map<String,Object>> obterTodosLivros(){
        String sql = "SELECT * FROM livro;";
        return jdbc.queryForList(sql);
    }

    public void atualizarLivro(int id, Livro livro){
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano_lancamento = ?, preco = ? WHERE id = ?";
        jdbc.update(sql, livro.getTitulo(), livro.getAutor(), livro.getAnoLancamento(), livro.getPreco(), id);
    }

    //Obter um único livro pelo ID
    public Livro obterLivro(int id){
        String sql = "Select * FROM livro WHERE id = ?";
        return Tool.converterLivro(jdbc.queryForMap(sql,id));
    }

    public void deletarLivro(int id){
        String sql = "DELETE FROM livro WHERE id = ?";
        jdbc.update(sql,id);
    }


}
