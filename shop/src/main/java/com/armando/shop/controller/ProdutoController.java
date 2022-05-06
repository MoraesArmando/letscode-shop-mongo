package com.armando.shop.controller;

import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Produto;
import com.armando.shop.service.impl.ProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoServiceImpl produtoService;

    @PostMapping
    public ProdutoDTO criaProduto(@RequestBody ProdutoDTO produtoDTO){
     return produtoService.criaProduto(produtoDTO);
    }

    @GetMapping
    public List<Produto> listaProdutos(){
        return produtoService.listaTodosProdutos();
    }

}
