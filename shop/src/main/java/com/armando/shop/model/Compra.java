package com.armando.shop.model;

import com.armando.shop.dto.CompraDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Document
public class Compra {

    @Id
    private String id;
    private LocalDateTime dataCompra;
    private float valorTotal;
    private String cpf;

    private List<ProdutoCompra> produtoCompra;

    public static Compra convert(CompraDTO compraDTO){
        return Compra.builder()
                .dataCompra(compraDTO.getDataCompra())
                .valorTotal(compraDTO.getValorTotal())
                .cpf(compraDTO.getCpf())
                .produtoCompra(compraDTO.getProdutoCompra())
                .build();
    }

}
