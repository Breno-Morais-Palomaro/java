package sqlite2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public class ProdutoGUI extends Application {
    private ProdutoDAO produtoDAO;
    private ObservableList<Produto> produtos;
    private TableView<Produto> tableView;
    private TextField nomeInput, quantidadeInput, precoInput;
    private ComboBox<String> statusComboBox;
    private Connection conexaoDB;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage palco) {
        conexaoDB = ConexaoDB.conectar();
        produtoDAO = new ProdutoDAO(conexaoDB); // Inicializa o DAO
        produtos = FXCollections.observableArrayList(produtoDAO.listarTodos()); // Carrega todos os produtos do banco de dados

        palco.setTitle("Gerenciamento de Estoque de Produtos");

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);

        HBox nomeProdutoBox = new HBox();
        nomeProdutoBox.setSpacing(10);
        Label nomeLabel = new Label("Produto:");
        nomeInput = new TextField();
        nomeProdutoBox.getChildren().addAll(nomeLabel, nomeInput);

        HBox quantidadeBox = new HBox();
        quantidadeBox.setSpacing(10);
        Label quantidadeLabel = new Label("Quantidade:");
        quantidadeInput = new TextField();
        quantidadeBox.getChildren().addAll(quantidadeLabel, quantidadeInput);

        HBox precoBox = new HBox();
        precoBox.setSpacing(10);
        Label precoLabel = new Label("Preço:");
        precoInput = new TextField();
        precoBox.getChildren().addAll(precoLabel, precoInput);

        HBox statusBox = new HBox();
        statusBox.setSpacing(10);
        Label statusLabel = new Label("Status:");
        statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Estoque Normal", "Estoque Baixo");
        statusBox.getChildren().addAll(statusLabel, statusComboBox);

        Button addButton = new Button("Adicionar");
        addButton.setOnAction(_ -> {
            String preco = precoInput.getText().replace(',', '.'); // Substitui vírgula por ponto no preço
            Produto produto = new Produto(nomeInput.getText(),
                    Integer.parseInt(quantidadeInput.getText()),
                    Double.parseDouble(preco),
                    statusComboBox.getValue());
            produtoDAO.inserir(produto); // Insere o novo produto no banco de dados
            produtos.setAll(produtoDAO.listarTodos()); // Atualiza a lista de produtos na tela
            limparCampos(); // Limpa os campos de entrada para uma nova digitação
        });

        Button updateButton = new Button("Atualizar");
        updateButton.setOnAction(_ -> {
            Produto selectedProduto = tableView.getSelectionModel().getSelectedItem(); // Obtém o produto selecionado
            if (selectedProduto != null) {
                selectedProduto.setNome(nomeInput.getText());
                selectedProduto.setQuantidade(Integer.parseInt(quantidadeInput.getText()));
                String preco = precoInput.getText().replace(',', '.');
                selectedProduto.setPreco(Double.parseDouble(preco));
                selectedProduto.setStatus(statusComboBox.getValue());
                produtoDAO.atualizar(selectedProduto); // Atualiza o produto no banco de dados
                produtos.setAll(produtoDAO.listarTodos()); // Atualiza a lista de produtos
                limparCampos(); // Limpa os campos de entrada
            }
        });

        Button deleteButton = new Button("Excluir");
        deleteButton.setOnAction(_ -> {
            Produto selectedProduto = tableView.getSelectionModel().getSelectedItem(); // Obtém o produto selecionado
            if (selectedProduto != null) {
                produtoDAO.excluir(selectedProduto.getId()); // Exclui o produto do banco de dados
                produtos.setAll(produtoDAO.listarTodos()); // Atualiza a lista de produtos
                limparCampos(); // Limpa os campos de entrada
            }
        });

        // Adiciona o botão Limpar
        Button clearButton = new Button("Limpar");
        clearButton.setOnAction(_ -> limparCampos());

        tableView = new TableView<>();
        tableView.setItems(produtos); // Define a lista de produtos na tabela
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS); // Ajusta o tamanho das colunas
        List<TableColumn<Produto, ?>> columns = List.of(
                criarColuna("ID", "id"),
                criarColuna("Produto", "nome"),
                criarColuna("Quantidade", "quantidade"),
                criarColuna("Preço", "preco"),
                criarColuna("Status", "status")
        );
        tableView.getColumns().addAll(columns);

        tableView.getSelectionModel().selectedItemProperty().addListener((_, _, newSelection) -> {
            if (newSelection != null) {
                nomeInput.setText(newSelection.getNome());
                quantidadeInput.setText(String.valueOf(newSelection.getQuantidade()));
                precoInput.setText(String.valueOf(newSelection.getPreco()));
                statusComboBox.setValue(newSelection.getStatus());
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(addButton, updateButton, deleteButton, clearButton); // Adiciona o botão Limpar ao HBox

        vbox.getChildren().addAll(nomeProdutoBox, quantidadeBox, precoBox, statusBox, buttonBox, tableView);

        Scene scene = new Scene(vbox, 800, 600);
        scene.getStylesheets().add("styles-produtos.css"); // Adiciona a folha de estilos
        palco.setScene(scene);
        palco.show();
    }

    /**
     * O método stop é chamado automaticamente quando a aplicação JavaFX é encerrada.
     */
    @Override
    public void stop() {
        try {
            conexaoDB.close(); // Fecha a conexão com o banco de dados
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão" + e.getMessage());
        }
    }

    /**
     * Limpa os campos de entrada do formulário.
     * Este método é chamado após adicionar, atualizar ou excluir um produto
     * para garantir que os campos de entrada estejam prontos para uma nova entrada.
     */
    private void limparCampos() {
        nomeInput.clear();
        quantidadeInput.clear();
        precoInput.clear();
        statusComboBox.setValue(null);
    }

    /**
     * Cria uma coluna para a TableView.
     * @param title O título da coluna que será exibido no cabeçalho.
     * @param property A propriedade do objeto Produto que esta coluna deve exibir.
     * @return A coluna configurada para a TableView.
     */
    private TableColumn<Produto, String> criarColuna(String title, String property) {
        TableColumn<Produto, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property)); // Define a propriedade da coluna
        return col;
    }
}