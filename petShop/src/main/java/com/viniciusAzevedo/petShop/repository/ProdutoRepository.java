package com.viniciusAzevedo.petShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viniciusAzevedo.petShop.model.Produto;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}