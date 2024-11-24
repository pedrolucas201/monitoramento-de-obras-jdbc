package com.obrasmonitoramento.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Comercial") // Define o valor no campo tipo para indicar que é uma obra comercial
public class ObraComercial extends Obra {

    private String empresaResponsavel;

    public ObraComercial() {
        super();
    }
    // Construtor
    public ObraComercial(String nome, String descricao, String endereco, String empresaResponsavel) {
        super(nome, descricao, endereco);
        this.empresaResponsavel = empresaResponsavel;
    }

    public String getEmpresaResponsavel() {
        return empresaResponsavel;
    }

    public void setEmpresaResponsavel(String empresaResponsavel) {
        this.empresaResponsavel = empresaResponsavel;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmpresa Responsável: " + empresaResponsavel;
    }
}
