package com.matheusfabiao.produtosapi.controller;

import com.matheusfabiao.produtosapi.model.Produto;
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

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return produto_service.cadastrarAlterar(produto,"cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return produto_service.cadastrarAlterar(produto,"alterar");
    }

}