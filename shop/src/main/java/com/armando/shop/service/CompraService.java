package com.armando.shop.service;

import com.armando.shop.dto.CompraDTO;
import com.armando.shop.model.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompraService {

     CompraDTO criarCompra(CompraDTO compraDTO);

     Page<CompraDTO> listaCpfPage(String cpf, Pageable pageable);

     List<Compra> listaTodasCompras();

}
