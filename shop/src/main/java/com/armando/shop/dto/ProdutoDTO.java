package com.armando.shop.dto;

import com.armando.shop.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoDTO {

    private String codigo;
    private Float preco;
    private Integer quantidade;

    public static ProdutoDTO convert(Produto produto){
        return ProdutoDTO.builder()
                .codigo(produto.getCodigo())
                .preco(produto.getPreco())
                .quantidade(produto.getQuantidade())
                .build();
    }

}
