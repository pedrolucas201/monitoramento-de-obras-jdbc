package com.obrasmonitoramento.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Residencial") // Define o valor no campo tipo para indicar que é uma obra residencial
public class ObraResidencial extends Obra {

    private int numeroApartamentos;

    public ObraResidencial () {
        super();
    }

    // Construtor
    public ObraResidencial(String nome, String descricao, String endereco, int numeroApartamentos) {
        super(nome, descricao, endereco);
        this.numeroApartamentos = numeroApartamentos;
    }

    public int getNumeroApartamentos() {
        return numeroApartamentos;
    }

    public void setNumeroApartamentos(int numeroApartamentos) {
        this.numeroApartamentos = numeroApartamentos;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNúmero de Apartamentos: " + numeroApartamentos;
    }
}
