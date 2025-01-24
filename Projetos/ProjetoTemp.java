import javafx.application.*;
import java.lang.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.*;

public class ProjetoTemp extends Application{
	public void start(Stage palco) {

		var labelTitle = new Label("Titulo da pagina");

		var labelDigiteTemp = new Label("Digite a temperatura em °C:");
		var textTempC = new TextField();

		var labelTempF = new Label("A temperatura equivalente em °F:");
		var textTempF = new TextField();
		textTempF.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

		var labelTempK = new Label("A temperatura equivalente em K:");
		var textTempK = new TextField();
		textTempK.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

		var boxConvertF = new VBox(labelTempF, textTempF);
		var boxConvertK = new VBox(labelTempK, textTempK);

		var boxConvert = new HBox(boxConvertF, boxConvertK);

		var botaoConvert = new Button("Converter");
		botaoConvert.setOnAction(e -> {
			try {
				double tempC = Double.parseDouble(textTempC.getText().trim().replace(',' , '.'));

				double tempF = (tempC * 9 / 5) + 32;
				String tempFConvert = String.format("%.2f", tempF);

				double tempK = tempC + 273.15;
				String tempKConvert = String.format("%.2f", tempK);

				textTempF.setText(tempFConvert);
				textTempK.setText(tempKConvert);
			} catch (NumberFormatException ex) {
				textTempF.setText("Formato de numero invalido!");
				textTempK.setText("Formato de numero invalido!");
			}
		});

		var boxPrincipal = new VBox(labelDigiteTemp, textTempC, botaoConvert, boxConvert);

		var borderPane = new BorderPane();
		borderPane.setTop(labelTitle);
		borderPane.setCenter(boxPrincipal);
		borderPane.setMargin(labelTitle, new Insets(15));

		var cena = new Scene(borderPane, 300, 300);
		palco.setScene(cena);
		palco.setTitle("Nome da aplição");
		palco.show();
	}

	public static void main(String[] args) {

		launch(args);
	}
}