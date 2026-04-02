package com.viniciusAzevedo.petShop.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;
    
    private String nome;
    private String descricao;
    private Double preco;
    private Double preco_desconto;
    private String imagem;
    private Integer qntd_estoque;
    private boolean ativo = true;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    public Produto() {}

    // Getters e Setters
    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPreco_desconto() {
        return preco_desconto;
    }

    public void setPreco_desconto(Double preco_desconto) {
        this.preco_desconto = preco_desconto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getQntd_estoque() {
        return qntd_estoque;
    }

    public void setQntd_estoque(Integer qntd_estoque) {
        this.qntd_estoque = qntd_estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}