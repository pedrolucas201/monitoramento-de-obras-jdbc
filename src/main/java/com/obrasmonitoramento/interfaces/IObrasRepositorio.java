package com.obrasmonitoramento.interfaces;

import com.obrasmonitoramento.entities.Obra;
import java.util.List;

public interface IObrasRepositorio {
    void salvar(Obra obra);
    List<Obra> listarTodas();
    void atualizar(Obra obra);
    void excluir(int id);
}
