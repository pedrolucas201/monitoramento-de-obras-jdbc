package com.obrasmonitoramento.services;

import com.obrasmonitoramento.entities.Obra;
import com.obrasmonitoramento.interfaces.IObrasRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ObrasIImplRepositorio implements IObrasRepositorio {

    // Variáveis para a conexão com o banco
    private static final String URL = "jdbc:h2:~/obras;MODE=MySQL";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final EntityManager entityManager = Persistence.createEntityManagerFactory("obrasPU").createEntityManager();

    // Método para testar a conexão com o banco de dados
    public void testarConexao() {
        try {
            if (entityManager != null && entityManager.isOpen()) {
                System.out.println("Conexão bem-sucedida ao banco de dados!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    }

    @Override
    public void salvar(Obra obra) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(obra); // Salva a obra no banco de dados
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Obra> listarTodas() {
        List<Obra> obras = null;
        try {
            // Consulta todas as obras no banco
            obras = entityManager.createQuery("SELECT o FROM Obra o", Obra.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao listar obras.");
        }
        return obras;
    }


    @Override
    public void atualizar(Obra obra) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(obra); // Atualiza a obra no banco
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Obra obra = entityManager.find(Obra.class, id); // Encontra a obra pelo id
            if (obra != null) {
                entityManager.remove(obra); // Remove a obra
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
