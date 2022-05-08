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

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoDTO criaProduto(ProdutoDTO produtoDTO) {
        Produto produto = Produto.convert(produtoDTO);
        return ProdutoDTO.convert(produtoRepository.save(produto));
    }

    @Override
    public Page<ProdutoDTO> listaProdutosPorCodigo(String codigo, Pageable pageable) {
        return produtoRepository.findByCodigo(codigo, pageable);
    }


    @Override
    public List<Produto> listaTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public ProdutoDTO buscaPorId(String id) {
        return ProdutoDTO.convert( produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado")));
    }

    public Boolean atualizaQuantidade(List<ProdutoCompra> produtoCompra) {
        for (ProdutoCompra p:
             produtoCompra) {
            ProdutoDTO produtoDTO = buscaPorId(p.getIdProduto());
            if (produtoDTO.getQuantidade()>p.getQuantidade()){
                return true;
            }
            throw new RuntimeException("Produto com quantidade insuficiente " + p.getIdProduto());
        }
        return false;
    }
}
