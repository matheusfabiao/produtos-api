package com.matheusfabiao.produtosapi.service;

import com.matheusfabiao.produtosapi.model.Produto;
import com.matheusfabiao.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produto_repository;

    //método para listar todos os produtos
    public List<Produto> listar(){
        return produto_repository.findAll();
    }

}
