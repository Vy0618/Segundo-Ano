package com.viniciusAzevedo.petShop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusAzevedo.petShop.model.Categoria;
import com.viniciusAzevedo.petShop.service.CategoriaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaService.cadastrar(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(
            @PathVariable long id,
            @RequestBody Categoria categoria) {
        
                Categoria categoriaAtualizada = categoriaService.atualizar(id, categoria);

                if(categoriaAtualizada == null){
                    return ResponseEntity.notFound().build();
                }

        return ResponseEntity.ok(categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
        boolean deletar = categoriaService.deletar(id);

        if(!deletar){
            return ResponseEntity.notFound().build();

        }
         return ResponseEntity.noContent().build();

    }

}
