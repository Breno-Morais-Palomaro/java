package cliente;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Clientes extends Application {

    private String nome;
    private String email;
    public static List<Clientes> listaClientes = new ArrayList<>();
    private Label labelLista = new Label();

    public Clientes() {}

    public Clientes(String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
    }

    public String toString() {
        return "Nome: " + nome + "\ne-mail: " + email + "\n";
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        var labelTitle = new Label("Adicionar Cliente");

        var labelName = new Label("Nome:");
        var textName = new TextField();
        var boxName = new HBox(5, labelName, textName);

        var labelEmail = new Label("E-mail:");
        var textEmail = new TextField();
        var boxEmail = new HBox(5, labelEmail, textEmail);
        
        ScrollPane scrollPane = new ScrollPane(labelLista); // Adiciona o rótulo dentro de um ScrollPane
        scrollPane.setFitToWidth(true); // Ajusta a largura do conteúdo ao tamanho do ScrollPane


        var botaoAdicionar = new Button("Adicionar");
        botaoAdicionar.setOnAction(_ -> {
            nome = textName.getText().trim();
            email = textEmail.getText().trim();
            Clientes cliente = new Clientes(nome, email);
            listaClientes.add(cliente);
        });

        var botaoFor = new Button("Mostrar lista");
        botaoFor.setOnAction(_ -> {
            StringBuilder lista = new StringBuilder();
            for (int i = 0; i < listaClientes.size(); i++) {
                lista.append(listaClientes.get(i).toString()).append("\n");
            }
            labelLista.setText(lista.toString());
        });

        var boxPrincipal = new VBox(15, labelTitle, boxName, boxEmail, botaoAdicionar, botaoFor, labelLista, scrollPane);
        boxPrincipal.setAlignment(Pos.CENTER);

        var cena = new Scene(boxPrincipal, 400, 400);

        primaryStage.setScene(cena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
