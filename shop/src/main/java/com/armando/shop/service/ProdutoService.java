package com.armando.shop.service;

import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO criaProduto(ProdutoDTO produtoDTO);

    Page<ProdutoDTO> listaProdutosCodigo(String codigo, Pageable pageable);

    List<Produto> listaTodosProdutos();
}
