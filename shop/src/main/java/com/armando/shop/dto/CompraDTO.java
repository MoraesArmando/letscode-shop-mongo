package com.armando.shop.dto;

import com.armando.shop.model.Compra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CompraDTO {
    private LocalDateTime dataCompra;
    private BigDecimal valorTotal;
    private String cpf;

    public static CompraDTO convert(Compra compra){
        return CompraDTO.builder()
                .dataCompra(compra.getDataCompra())
                .valorTotal(compra.getValorTotal())
                .cpf(compra.getCpf())
                .build();
    }
}
