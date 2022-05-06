package com.armando.shop.dto;

import com.armando.shop.model.Compra;
import com.armando.shop.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class CompraDTO {
    private LocalDate dataCompra;
    private BigDecimal valorTotal;
    private String cpf;
    private List<Produto> produtos;


    public static CompraDTO convert(Compra compra){
        return CompraDTO.builder()
                .dataCompra(compra.getDataCompra())
                .valorTotal(compra.getValorTotal())
                .cpf(compra.getCpf())
                .produtos(compra.getProdutos())
                .build();
    }
}
