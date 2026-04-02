package com.viniciusAzevedo.petShop.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.viniciusAzevedo.petShop.model.Produto;
import com.viniciusAzevedo.petShop.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produtoService.cadastrar(produto));
    }

    @PutMapping("/{id_produto}")
    public ResponseEntity<Produto> atualizarProduto(
            @PathVariable Long id_produto,
            @RequestBody Produto produto) {
        
        Produto produtoAtualizado = produtoService.atualizar(id_produto, produto);

        if (produtoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id_produto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id_produto) {
        boolean deletar = produtoService.deletar(id_produto);

        if (!deletar) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id_produto}")
    public ResponseEntity<Produto> procurar(@PathVariable Long id_produto) {
        Produto produto = produtoService.procurar(id_produto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }
    
  
}