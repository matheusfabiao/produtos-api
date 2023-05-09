package com.matheusfabiao.produtosapi.controller;

import com.matheusfabiao.produtosapi.model.Produto;
import com.matheusfabiao.produtosapi.model.Resposta;
import com.matheusfabiao.produtosapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produto_service;

    @GetMapping("/")
    public String rotaTeste(){
        return "API de produtos funcionando!";
    }

    //Rota de listagem de produtos
    @GetMapping("/listar")
    public List<Produto> listar(){
        return produto_service.listar();
    }

    //rota de cadastro de produtos
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return produto_service.cadastrarAlterar(produto,"cadastrar");
    }

    //rota de alteração de produtos
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return produto_service.cadastrarAlterar(produto,"alterar");
    }

    //rota de remoção de produtos por ID
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Resposta> remover(@PathVariable long id){
        return produto_service.remover(id);
    }

}