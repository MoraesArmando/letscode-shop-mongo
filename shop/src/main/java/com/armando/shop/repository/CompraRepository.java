package com.armando.shop.repository;

import com.armando.shop.dto.CompraDTO;
import com.armando.shop.model.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends MongoRepository<Compra, String> {

     Page<CompraDTO> findByCpf(String cpf, Pageable pageable);

}
