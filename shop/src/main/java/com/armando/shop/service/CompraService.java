package com.armando.shop.service;

import com.armando.shop.dto.CompraDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompraService {

     CompraDTO criarCompra(CompraDTO compraDTO);

     Page<CompraDTO> listaCpfPage(String cpf, Pageable pageable);

     Page<CompraDTO> listaTodasCompras(Pageable pageable);

}
