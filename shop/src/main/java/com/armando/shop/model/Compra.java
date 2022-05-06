package com.armando.shop.model;

import com.armando.shop.dto.CompraDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Document
public class Compra {

    @Id
    private String id;
    private LocalDate dataCompra;
    private BigDecimal valorTotal;
    private String cpf;

    @DBRef
    private List<Produto> produtos;

    public static Compra convert(CompraDTO compraDTO){
        return Compra.builder()
                .dataCompra(compraDTO.getDataCompra())
                .valorTotal(compraDTO.getValorTotal())
                .cpf(compraDTO.getCpf())
                .produtos(compraDTO.getProdutos())
                .build();
    }

}
