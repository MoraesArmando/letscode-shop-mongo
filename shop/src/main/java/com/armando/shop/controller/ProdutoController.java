package com.armando.shop.controller;

import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Produto;
import com.armando.shop.service.impl.ProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoServiceImpl produtoService;

    @PostMapping
    public ProdutoDTO criaProduto(ProdutoDTO produtoDTO){
     return produtoService.criaProduto(produtoDTO);
    }

    @GetMapping
    public List<Produto> listaProdutos(){
        return produtoService.listaTodosProdutos();
    }

}
