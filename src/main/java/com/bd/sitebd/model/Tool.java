package com.bd.sitebd.model;
import java.math.BigDecimal;
import java.util.Map;

public class Tool {
    public static Livro converterLivro(Map<String, Object> dados) {
        Livro livro = new Livro();
        livro.setId((Integer) dados.get("id"));
        livro.setTitulo((String) dados.get("titulo"));
        livro.setAutor((String) dados.get("autor"));
        livro.setAnoLancamento((Integer) dados.get("ano_lancamento"));
        livro.setPreco((BigDecimal) dados.get("preco"));
        return livro;
    }
}
