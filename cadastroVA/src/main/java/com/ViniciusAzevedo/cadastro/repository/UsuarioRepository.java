package com.ViniciusAzevedo.cadastro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ViniciusAzevedo.cadastro.model.Usuario;





@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    Usuario findByEmail(String email);
    Usuario findById(long id);
}
