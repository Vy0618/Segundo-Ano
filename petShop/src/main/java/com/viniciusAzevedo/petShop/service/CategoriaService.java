package com.viniciusAzevedo.petShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viniciusAzevedo.petShop.model.Categoria;
import com.viniciusAzevedo.petShop.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria cadastrar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria dados) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);

        if (categoria == null) {
            return null;
        }

        categoria.setNome(dados.getNome());
        categoria.setDescricao(dados.getDescricao());
        categoria.setAtivo(dados.isAtivo());

        return categoriaRepository.save(categoria);

    }

    public boolean deletar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            return false;
        }

        categoriaRepository.deleteById(id);
        return true;

    }

    public Categoria procurar(long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não envcontrada"));
    }

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

}
