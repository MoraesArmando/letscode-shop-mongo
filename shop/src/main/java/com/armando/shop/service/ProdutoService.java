package com.armando.shop.service;

import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Produto;
import com.armando.shop.model.ProdutoCompra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO criaProduto(ProdutoDTO produtoDTO);

    Page<ProdutoDTO> listaProdutosPorCodigo(String codigo, Pageable pageable);

    List<Produto> listaTodosProdutos();

    ProdutoDTO buscaPorId(String id);

    Boolean atualizaQuantidade(List<ProdutoCompra> produtoCompra);

}
