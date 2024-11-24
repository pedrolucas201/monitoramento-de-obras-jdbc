package com.obrasmonitoramento.entities;

public class Engenheiro {
    private int id;
    private String nome;
    private String registro;

    // Getters and Setters
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

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Engenheiro [id=" + id + ", nome=" + nome + ", registro=" + registro + "]";
    }
}
