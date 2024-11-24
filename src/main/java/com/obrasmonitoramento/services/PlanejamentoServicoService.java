package com.obrasmonitoramento.services;

import com.obrasmonitoramento.entities.Tarefa;
import com.obrasmonitoramento.interfaces.IPlanejamentoServico;
import java.sql.*;

public class PlanejamentoServicoService implements IPlanejamentoServico {

    private static final String URL = "jdbc:h2:~/obras";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    @Override
    public void adicionarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (descricao, prazo, concluida) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getDescricao());
            stmt.setString(2, tarefa.getPrazo());
            stmt.setBoolean(3, tarefa.isConcluida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarTarefa(Tarefa tarefa) {
        String sql = "UPDATE tarefas SET descricao = ?, prazo = ?, concluida = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getDescricao());
            stmt.setString(2, tarefa.getPrazo());
            stmt.setBoolean(3, tarefa.isConcluida());
            stmt.setInt(4, tarefa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirTarefa(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
