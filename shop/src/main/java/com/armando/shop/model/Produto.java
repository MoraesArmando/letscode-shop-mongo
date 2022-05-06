package com.armando.shop.model;

import com.armando.shop.dto.ProdutoDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Document
public class Produto {

    @Id
    private String id;
    private String codigo;
    private BigDecimal preco;
    private Integer quantidade;

    public static Produto convert(ProdutoDTO produtoDTO){
        return Produto.builder()
                .codigo(produtoDTO.getCodigo())
                .preco(produtoDTO.getPreco())
                .quantidade(produtoDTO.getQuantidade())
                .build();
    }

}
