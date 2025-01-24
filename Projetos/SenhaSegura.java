import javafx.application.*;
import java.lang.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.*;
import java.security.*;

public class SenhaSegura extends Application{
	
	public void start(Stage palco) {

		palco.setTitle("SenhaMaster");

		var labelTitulo = new Label("Gerador de Senhas");
		labelTitulo.setStyle("-fx-font-family: Impact;"
				+ "-fx-padding-bottom: 60px;" 
				+ "-fx-font-size: 25px;");

		var labelTamanho = new Label("Tamanho da senha:");
		labelTamanho.setPadding(new Insets(10));

		var textTamanho = new TextField();
		textTamanho.setText("25");

		var labelSenhaGerada = new Label("Senha Gerada:");
		var textGerado = new TextField();
		textGerado.setStyle("-fx-background-color: rgba(255, 255, 255, 0);");
		textGerado.setEditable(false);

		var fazer = new Button("Gerar Senha");
		fazer.setOnAction(e -> {
			try {
				int quant = Integer.parseInt(textTamanho.getText());
				String senha = ProjetoGeradorDeSenhas.geradorSenha(quant);
				textGerado.setText(senha);
				textGerado.setPrefWidth(senha.length() * 7);
				fazer.setStyle("-fx-background-color: #49ba6e;");
				fazer.setText("Senha Gerada");
			} catch (NumberFormatException ex) {
				textGerado.setText("Passe um número valido");
				textGerado.setPrefWidth(500);
				fazer.setStyle("-fx-background-color: #de3140;");
				fazer.setText("ERRO!");
			}
		});

		var caixaTitulo = new HBox(labelTitulo);
		caixaTitulo.setAlignment(Pos.CENTER);

		var caixaPrincipal = new VBox(labelTamanho, textTamanho, fazer, labelSenhaGerada, textGerado);
		caixaPrincipal.setPadding(new Insets(20));
		caixaPrincipal.setAlignment(Pos.CENTER);
		caixaPrincipal.setMargin(fazer, new Insets(15));
		caixaPrincipal.setSpacing(10);

		var pane = new BorderPane();
		pane.setTop(caixaTitulo);
		pane.setCenter(caixaPrincipal);
		pane.setPadding(new Insets(20));



		Scene cena = new Scene(pane, 600, 350);
		palco.setScene(cena);
		palco.show();
	}

	public static void main(String[] args) {

		launch(args);
	}
}