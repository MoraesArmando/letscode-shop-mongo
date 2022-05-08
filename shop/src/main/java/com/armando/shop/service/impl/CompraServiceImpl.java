package com.armando.shop.service.impl;

import com.armando.shop.dto.CompraDTO;
import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Compra;
import com.armando.shop.model.ProdutoCompra;
import com.armando.shop.repository.CompraRepository;
import com.armando.shop.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final ProdutoServiceImpl produtoService;


    public CompraDTO criarCompra(CompraDTO dto) {
        verificaQuantidadeProduto(dto.getProdutoCompra());

        dto.setDataCompra(LocalDateTime.now());
        if (dto.getProdutoCompra() != null) {
            dto.setValorTotal(calculaValorTotal(dto));
        }
        Compra compra = Compra.convert(dto);
        compra.setId((UUID.randomUUID().toString()));

        return CompraDTO.convert(compraRepository.save(compra));
    }

    public Page<CompraDTO> listaCpfPage(String cpf, Pageable pageable) {
        return compraRepository.findByCpf(cpf, pageable);
    }

    @Override
    public Page<CompraDTO> listaTodasCompras(Pageable pageable) {
        return compraRepository.findAll(pageable).map(CompraDTO::convert);
    }
    private void verificaQuantidadeProduto(List<ProdutoCompra> produtoCompra) {
        produtoService.atualizaQuantidade(produtoCompra);
    }

    private Float calculaValorTotal(CompraDTO compraDTO) {
        float valorTotal = 0;
        for (ProdutoCompra p : compraDTO.getProdutoCompra()) {
            ProdutoDTO produtoDTO = produtoService.buscaPorId(p.getIdProduto());
            valorTotal += produtoDTO.getPreco() * p.getQuantidade();
        }
        return valorTotal;
    }

}
