package com.obrasmonitoramento.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Ou outra estratégia, como JOINED, se necessário
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING) // Define o campo discriminador para diferenciar entre as subclasses
public abstract class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private String endereco;

    public Obra () { }

    // Construtor
    public Obra(String nome, String descricao, String endereco) {
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\nObra: " +
                "\nID: " + id +
                "\nNome: " + nome  +
                "\nDescricao: " + descricao +
                "\nEndereco: " + endereco;
    }
}
