package com.armando.shop.repository;

import com.armando.shop.dto.ProdutoDTO;
import com.armando.shop.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    Page<ProdutoDTO> findByCodigo(String codigo, Pageable pageable);
}
