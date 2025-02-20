package dadosClimatitos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SistemaDeInformacaoesClimaticasEmTempoReal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var labelTittle = new Label("Tempratura do tempo atual");
        labelTittle.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-color: blue;");
        var boxTittle = new VBox(labelTittle);
        boxTittle.setAlignment(Pos.CENTER);

        var labelCidade = new Label("Digite a cidade:");
        var textCidade = new TextField();
        textCidade.setMaxWidth(150);
        var boxCidade = new VBox(5, labelCidade, textCidade);
        boxCidade.setAlignment(Pos.CENTER);

        var labelResul = new Label("");
        labelResul.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");
        var boxResul = new VBox(labelResul);
        boxResul.setAlignment(Pos.CENTER);
        boxResul.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");

        var botao = new Button("Pesquisar");

        var boxPrincipal = new VBox(25, boxTittle, boxCidade, boxResul);
        boxPrincipal.setStyle("-fx-background-image: url('file:/E:/Eclipse-WorkSpace/Projetos/src/dadosClimatitos/imagens/mapa2.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-color: rgba(60, 138, 207, 0.5);");

        Runnable searchAction = () -> {
            try {
                String cidade = textCidade.getText().trim();
                String dadosClimaticos = Sistema.getDadosClimaticos(cidade); //retorna um json

                // Código 1006 significa localização não encontrada
                if (dadosClimaticos.contains("\"code\":1006")) { // \"code\":1006 representa "code":1006  
                    labelResul.setText("Localização não encontrada");
                    textCidade.clear();
                } else {
                    labelResul.setText(Sistema.imprimirDadosClimaticos(dadosClimaticos));
                    textCidade.clear();
                }
            } catch (Exception e) {
                labelResul.setText(e.getMessage());
                textCidade.clear();
            }
        };

        botao.setOnAction(_ -> searchAction.run());

        textCidade.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                searchAction.run();
            }
        });

        boxPrincipal.setAlignment(Pos.CENTER);

        var cena = new Scene(boxPrincipal, 500, 500);

        primaryStage.setScene(cena);
        primaryStage.getIcons().add(new Image("file:E:\\Eclipse-WorkSpace\\icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
