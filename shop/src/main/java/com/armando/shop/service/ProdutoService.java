package com.armando.shop.service;

import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Produto;
import com.armando.shop.model.ProdutoCompra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO criaProduto(ProdutoDTO produtoDTO);

    Page<Produto> listaTodosProdutos(Pageable pageable);

    ProdutoDTO buscaPorId(String id);

    void atualizaQuantidade(List<ProdutoCompra> produtoCompra);

}
