package com.armando.shop.service.impl;

import com.armando.shop.dto.CompraDTO;
import com.armando.shop.model.Compra;
import com.armando.shop.repository.CompraRepository;
import com.armando.shop.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;


    public CompraDTO criarCompra(CompraDTO compraDTO) {
        Compra compra = Compra.convert(compraDTO);
        return CompraDTO.convert(compraRepository.save(compra));
    }

    public Page<CompraDTO> listaCpfPage(String cpf, Pageable pageable) {
        return compraRepository.findByCpf(cpf,pageable);
    }

    public List<Compra> listaTodasCompras() {
        return  compraRepository.findAll();
    }
}
