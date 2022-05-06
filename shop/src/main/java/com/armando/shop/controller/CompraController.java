package com.armando.shop.controller;

import com.armando.shop.dto.CompraDTO;
import com.armando.shop.model.Compra;
import com.armando.shop.service.impl.CompraServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {

    private final CompraServiceImpl compraService;


    @PostMapping
    public CompraDTO criaCompra(@RequestBody CompraDTO compraDTO){
        return compraService.criarCompra(compraDTO);
    }

    @GetMapping
    public List<Compra> listaTodasCompras(){
        return compraService.listaTodasCompras();
    }

    @GetMapping("/")
    public Page<CompraDTO> buscaPorCpfPage(@RequestParam(name = "cpf", required = false) String cpf, @PageableDefault Pageable pageable){
        return compraService.listaCpfPage(cpf,pageable);
    }

}
