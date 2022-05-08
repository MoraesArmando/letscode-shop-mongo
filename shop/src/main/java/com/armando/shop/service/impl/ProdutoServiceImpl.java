package com.armando.shop.service.impl;

import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Produto;
import com.armando.shop.model.ProdutoCompra;
import com.armando.shop.repository.ProdutoRepository;
import com.armando.shop.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoDTO criaProduto(ProdutoDTO produtoDTO) {
        Produto produto = Produto.convert(produtoDTO);
        produto.setId(UUID.randomUUID().toString());
        return ProdutoDTO.convert(produtoRepository.save(produto));
    }

    @Override
    public Page<Produto> listaTodosProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);

    }

    @Override
    public ProdutoDTO buscaPorId(String id) {
        return ProdutoDTO.convert(produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado")));
    }

    public void atualizaQuantidade(List<ProdutoCompra> produtoCompra) {
        for (ProdutoCompra p :
                produtoCompra) {
            ProdutoDTO produtoDTO = buscaPorId(p.getIdProduto());
            if (!(produtoDTO.getQuantidade() > p.getQuantidade())) {
                throw new RuntimeException("Produto com quantidade insuficiente " + p.getIdProduto());
            }
        }
    }

}
