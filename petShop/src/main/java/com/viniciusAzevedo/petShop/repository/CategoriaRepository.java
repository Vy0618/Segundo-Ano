package com.viniciusAzevedo.petShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viniciusAzevedo.petShop.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

    
}
