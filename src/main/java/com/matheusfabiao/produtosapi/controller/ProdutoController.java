package com.matheusfabiao.produtosapi.controller;

import com.matheusfabiao.produtosapi.model.Produto;
import com.matheusfabiao.produtosapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return produto_service.cadastrar(produto);
    }

}