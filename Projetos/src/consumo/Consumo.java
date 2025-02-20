package consumo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Consumo extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Image icon = new Image("file:///D://Eclipse-WorkSpace//Exercicios//src//main//java//"
				+ "br//com//palomarotech//consumo//icon//icon3.png");
		primaryStage.getIcons().add(icon);
		
		var labelTitle = new Label("Consumo de aparelhos");
		labelTitle.setStyle("-fx-font-size: 25px;");
		labelTitle.setPadding(new Insets(15));
		
		var labelWatts = new Label("Qual a potencia do aparelho em Watts:");
		var textWatts = new TextField();
		textWatts.setMaxWidth(60);
		var boxWatts = new HBox(5, labelWatts, textWatts);
		
		var labelHoras = new Label("Quantas horas fica ligado por dia:");
		var textHoras = new TextField();
		textHoras.setMaxWidth(90);
		var boxHoras = new HBox(5, labelHoras, textHoras);
		
		var labelDias = new Label("Quantas dias fica ligado por mês:");
		var textDias = new TextField();
		textDias.setMaxWidth(92);
		var boxDias = new HBox(5, labelDias, textDias);
		
		var labelValor = new Label("Qual valor do Kwh da sua região:");
		var textValor = new TextField();
		textValor.setMaxWidth(94);
		var boxValor = new HBox(5, labelValor, textValor);
		
		var labelResul = new Label("");
		labelResul.setStyle("-fx-font-weight: bold;");
		
		var botao = new Button("Calcular");
		Runnable calcular =  ( () -> {
			
			double watts;
			double horas;
			double valor;
			int dias;
			
			try {
				
				watts = Double.parseDouble(textWatts.getText().trim().replace(",", "."));
				horas = Double.parseDouble(textHoras.getText().trim().replace(",", "."));
				valor = Double.parseDouble(textValor.getText().trim().replace(",", "."));
				dias = Integer.parseInt(textDias.getText().trim().replace(",", "."));
				
				double total = ((watts * horas * dias) / 1000) * valor;
				
				String totalFormat = String.format("%.2f", total);
				
				botao.setStyle("-fx-background-color: #3CB371");
				botao.setText("Calculado");
				
				labelResul.setText("O aparelho gasta em media R$ " + totalFormat + " por mês.");
				
			} catch (NumberFormatException e) {
				
				labelResul.setText("Número Invalido!\n" + e.getMessage());
				
				botao.setText("ERRO!");
				botao.setStyle("-fx-background-color: #A52A2A");				
			}
			
		});
		
		botao.setOnAction(_-> calcular.run());
		
		textWatts.setOnAction(_ -> textHoras.requestFocus());
		textHoras.setOnAction(_ -> textDias.requestFocus());
		textDias.setOnAction(_ -> textValor.requestFocus());
		
		textValor.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				calcular.run();
			}
		});
		
		
		
		var boxPrincipal = new VBox(5, boxWatts, boxHoras, boxDias, boxValor, botao, labelResul);
		boxPrincipal.setPadding(new Insets(15));
		boxPrincipal.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");
		boxPrincipal.setAlignment(Pos.CENTER);
				
		var borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-image: url(file:/E:/Eclipse-WorkSpace/Projetos/src/consumo/image.jpg);"
				+ "-fx-background-size: cover;");
		borderPane.setPadding(new Insets(20));
		borderPane.setTop(labelTitle);
		borderPane.setCenter(boxPrincipal);
		BorderPane.setAlignment(labelTitle, Pos.CENTER);
		
		Scene cena = new Scene(borderPane, 450, 350);
		
		primaryStage.setScene(cena);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("file:E:\\Eclipse-WorkSpace\\icon.png"));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}