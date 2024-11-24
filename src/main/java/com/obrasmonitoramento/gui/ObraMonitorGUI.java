package com.obrasmonitoramento.gui;

import com.obrasmonitoramento.entities.Obra;
import com.obrasmonitoramento.entities.ObraComercial;
import com.obrasmonitoramento.entities.ObraResidencial;
import com.obrasmonitoramento.services.ObrasIImplRepositorio;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ObraMonitorGUI extends Application {
    private ObrasIImplRepositorio obrasRepositorio = new ObrasIImplRepositorio();
    private TextArea logArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Monitoramento de Obras");

        // Campos para entrada de dados
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome da Obra");

        TextField descricaoField = new TextField();
        descricaoField.setPromptText("Descrição");

        TextField enderecoField = new TextField();
        enderecoField.setPromptText("Endereço");

        // ComboBox para selecionar tipo de obra
        ComboBox<String> tipoObraComboBox = new ComboBox<>();
        tipoObraComboBox.getItems().addAll("Comercial", "Residencial");
        tipoObraComboBox.setValue("Comercial"); // valor padrão

        // Campos específicos para Obra Comercial
        TextField empresaField = new TextField();
        empresaField.setPromptText("Empresa Responsável");
        empresaField.setDisable(false);

        // Campos específicos para Obra Residencial
        TextField numeroApartamentosField = new TextField();
        numeroApartamentosField.setPromptText("Número de Apartamentos");
        numeroApartamentosField.setDisable(true);

        // Botões para ações
        Button addButton = new Button("Adicionar Obra");
        Button updateButton = new Button("Atualizar Obra");
        Button deleteButton = new Button("Excluir Obra");
        Button listButton = new Button("Listar Obras");

        // Área de log para exibição de informações
        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefHeight(200);

        // Configuração dos botões
        addButton.setOnAction(e -> adicionarObra(nomeField, descricaoField, enderecoField, tipoObraComboBox, empresaField, numeroApartamentosField));
        updateButton.setOnAction(e -> atualizarObra(nomeField, descricaoField, enderecoField, tipoObraComboBox, empresaField, numeroApartamentosField));
        deleteButton.setOnAction(e -> excluirObra(nomeField));
        listButton.setOnAction(e -> listarObras());

        tipoObraComboBox.setOnAction(event -> {
            String tipoObra = tipoObraComboBox.getValue();
            if ("Comercial".equals(tipoObra)) {
                empresaField.setDisable(false);
                numeroApartamentosField.setDisable(true);
            } else {
                empresaField.setDisable(true);
                numeroApartamentosField.setDisable(false);
            }
        });

        // Layout
        GridPane formPane = new GridPane();
        formPane.setPadding(new Insets(10));
        formPane.setHgap(10);
        formPane.setVgap(10);
        formPane.add(new Label("Nome:"), 0, 0);
        formPane.add(nomeField, 1, 0);
        formPane.add(new Label("Descrição:"), 0, 1);
        formPane.add(descricaoField, 1, 1);
        formPane.add(new Label("Endereço:"), 0, 2);
        formPane.add(enderecoField, 1, 2);
        formPane.add(new Label("Tipo de Obra:"), 0, 3);
        formPane.add(tipoObraComboBox, 1, 3);
        formPane.add(new Label("Empresa Responsável:"), 0, 4);
        formPane.add(empresaField, 1, 4);
        formPane.add(new Label("Número de Apartamentos:"), 0, 5);
        formPane.add(numeroApartamentosField, 1, 5);

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(formPane, addButton, updateButton, deleteButton, listButton, logArea);

        // Cena principal
        Scene scene = new Scene(mainLayout, 400, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adicionarObra(TextField nomeField, TextField descricaoField, TextField enderecoField, ComboBox<String> tipoObraComboBox, TextField empresaField, TextField numeroApartamentosField) {
        String nome = nomeField.getText();
        String descricao = descricaoField.getText();
        String endereco = enderecoField.getText();

        if (nome.isEmpty() || descricao.isEmpty() || endereco.isEmpty()) {
            log("Todos os campos são obrigatórios para adicionar uma obra!");
            return;
        }

        String tipoObra = tipoObraComboBox.getValue();
        Obra obra = null;

        if ("Comercial".equals(tipoObra)) {
            String empresa = empresaField.getText();
            if (empresa.isEmpty()) {
                log("O campo 'Empresa Responsável' é obrigatório para obra comercial!");
                return;
            }
            obra = new ObraComercial(nome, descricao, endereco, empresa);
        } else if ("Residencial".equals(tipoObra)) {
            String numApartamentosText = numeroApartamentosField.getText();
            if (numApartamentosText.isEmpty()) {
                log("O campo 'Número de Apartamentos' é obrigatório para obra residencial!");
                return;
            }
            int numeroApartamentos = Integer.parseInt(numApartamentosText);
            obra = new ObraResidencial(nome, descricao, endereco, numeroApartamentos);
        }

        obrasRepositorio.salvar(obra);
        log("Obra adicionada: " + obra);
        limparCampos(nomeField, descricaoField, enderecoField, empresaField, numeroApartamentosField);
    }

    private void atualizarObra(TextField nomeField, TextField descricaoField, TextField enderecoField, ComboBox<String> tipoObraComboBox, TextField empresaField, TextField numeroApartamentosField) {
        String nome = nomeField.getText();

        if (nome.isEmpty()) {
            log("Nome é obrigatório para atualizar uma obra!");
            return;
        }

        List<Obra> obras = obrasRepositorio.listarTodas();
        for (Obra obra : obras) {
            if (obra.getNome().equals(nome)) {
                obra.setDescricao(descricaoField.getText());
                obra.setEndereco(enderecoField.getText());

                String tipoObra = tipoObraComboBox.getValue();
                if ("Comercial".equals(tipoObra)) {
                    ((ObraComercial) obra).setEmpresaResponsavel(empresaField.getText());
                } else if ("Residencial".equals(tipoObra)) {
                    ((ObraResidencial) obra).setNumeroApartamentos(Integer.parseInt(numeroApartamentosField.getText()));
                }

                obrasRepositorio.atualizar(obra);
                log("Obra atualizada: " + obra);
                limparCampos(nomeField, descricaoField, enderecoField, empresaField, numeroApartamentosField);
                return;
            }
        }

        log("Obra com nome " + nome + " não encontrada!");
    }

    private void excluirObra(TextField nomeField) {
        String nome = nomeField.getText();

        if (nome.isEmpty()) {
            log("Nome é obrigatório para excluir uma obra!");
            return;
        }

        List<Obra> obras = obrasRepositorio.listarTodas();
        for (Obra obra : obras) {
            if (obra.getNome().equals(nome)) {
                obrasRepositorio.excluir(obra.getId());
                log("Obra excluída: " + obra);
                nomeField.clear();
                return;
            }
        }

        log("Obra com nome " + nome + " não encontrada!");
    }

    private void listarObras() {
        List<Obra> obras = obrasRepositorio.listarTodas();
        if (obras.isEmpty()) {
            log("Nenhuma obra cadastrada.");
        } else {
            log("Lista de Obras:");
            for (Obra obra : obras) {
                log(obra.toString());
            }
        }
    }

    private void log(String mensagem) {
        logArea.appendText(mensagem + "\n");
    }

    private void limparCampos(TextField... campos) {
        for (TextField campo : campos) {
            campo.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
