package com.obrasmonitoramento.interfaces;

import com.obrasmonitoramento.entities.Tarefa;

public interface IPlanejamentoServico {
    void adicionarTarefa(Tarefa tarefa);
    void atualizarTarefa(Tarefa tarefa);
    void excluirTarefa(int id);
}
