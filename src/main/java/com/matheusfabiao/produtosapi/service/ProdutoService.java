package com.matheusfabiao.produtosapi.service;

import com.matheusfabiao.produtosapi.model.Produto;
import com.matheusfabiao.produtosapi.model.Resposta;
import com.matheusfabiao.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produto_repository;

    @Autowired
    private Resposta resposta;

    //método para listar todos os produtos
    public List<Produto> listar(){
        return produto_repository.findAll();
    }

    //método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao){
        if(produto.getNome().equals("")){ //se não for digitado o nome retorne um erro
            resposta.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        } else if (produto.getMarca().equals("")) { //se não for digitada a marca retorne um erro
            resposta.setMensagem("A marca do produto é obrigatória!");
            return new ResponseEntity<Resposta>(resposta,HttpStatus.BAD_REQUEST);
        }else {
            if (acao.equals("cadastrar")){
                return new ResponseEntity<Produto>(produto_repository.save(produto),HttpStatus.CREATED);
            }else {
                return new ResponseEntity<Produto>(produto_repository.save(produto),HttpStatus.OK);
            }
        }

    }
}
