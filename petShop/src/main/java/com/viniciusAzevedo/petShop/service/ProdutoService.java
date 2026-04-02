package com.viniciusAzevedo.petShop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.viniciusAzevedo.petShop.model.Produto;
import com.viniciusAzevedo.petShop.repository.ProdutoRepository;
import com.viniciusAzevedo.petShop.repository.CategoriaRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public boolean deletar(Long id_produto) {
        if (!produtoRepository.existsById(id_produto)) {
            return false;
        }
        produtoRepository.deleteById(id_produto);
        return true;
    }

    public Produto atualizar(Long id_produto, Produto dados) {
        Produto produto = produtoRepository.findById(id_produto).orElse(null);

        if (produto == null) {
            return null;
        }

        produto.setNome(dados.getNome());
        produto.setDescricao(dados.getDescricao());
        produto.setPreco(dados.getPreco());
        produto.setPreco_desconto(dados.getPreco_desconto());
        produto.setImagem(dados.getImagem());
        produto.setQntd_estoque(dados.getQntd_estoque());
        produto.setAtivo(dados.isAtivo());
        produto.setCategoria(dados.getCategoria());
    
        return produtoRepository.save(produto);
    }

    public Produto procurar(Long id_produto) {
        return produtoRepository.findById(id_produto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }
  
}