package com.armando.shop.dto;

import com.armando.shop.model.Compra;
import com.armando.shop.model.ProdutoCompra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CompraDTO {

    private LocalDateTime dataCompra;
    private float valorTotal;
    private String cpf;
    private List<ProdutoCompra> produtoCompra;

    public static CompraDTO convert(Compra compra){
        return CompraDTO.builder()
                .dataCompra(compra.getDataCompra())
                .valorTotal(compra.getValorTotal())
                .cpf(compra.getCpf())
                .produtoCompra(compra.getProdutoCompra())
                .build();
    }
}
