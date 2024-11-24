package com.bd.sitebd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.sitebd.model.Livro;
import com.bd.sitebd.model.LivroService;
import com.bd.sitebd.model.Tool;

@Controller
public class CadastroController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/") 
    public String principal(){
        return "principal"; 
    }

    @GetMapping("/atualizar/{id}") 
    public String atualizar(Model model, @PathVariable int id){
        LivroService livroService = context.getBean(LivroService.class);
        Livro livro = livroService.obterLivro(id);
        model.addAttribute("id", id);
        model.addAttribute("livro", livro); // Passa o livro para a view
        return "atualizar"; // Página de atualização
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Livro livro){
        LivroService livroService = context.getBean(LivroService.class);
        livroService.atualizarLivro(id, livro);
        return "redirect:/listagem";
    }

    @GetMapping("/cadastro") 
    public String cadastro(Model model){
        model.addAttribute("livro", new Livro()); // Objeto livro vazio para o formulário
        return "cadastro"; // Página de cadastro
        }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Livro livro){
        LivroService livroService = context.getBean(LivroService.class);
        livroService.inserir(livro);
        return "sucesso"; // Página de sucesso
    }

    @GetMapping("/listagem")
    public String listagem(Model model){
        LivroService livroService = context.getBean(LivroService.class);
        List<Map<String,Object>> lista = livroService.obterTodosLivros();
        List<Livro> listaLivros = new ArrayList<>();
        for(Map<String,Object> registro : lista){
            listaLivros.add(Tool.converterLivro(registro)); // Converte cada registro para um objeto Livro
        }
        model.addAttribute("livros", listaLivros); // Adiciona a lista de livros ao modelo
        return "listagem"; // Página de listagem
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        LivroService livroService = context.getBean(LivroService.class);
        livroService.deletarLivro(id);
        return "redirect:/listagem";
    }

}

//thymeleaf is the next