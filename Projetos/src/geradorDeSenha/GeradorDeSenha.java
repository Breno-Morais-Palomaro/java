package geradorDeSenha;

import java.security.SecureRandom;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


    
public class GeradorDeSenha extends Application {
	
	private static final String CARACTERES = 
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
			+ "!@#$%&*()_+-=[]|,./?><";
	
	public static String gerarSenha(int comprimento) {
	    SecureRandom geradorDeNumeroAleatorio = new SecureRandom();
	    StringBuilder senha = new StringBuilder(comprimento);

	    for (int i = 0; i < comprimento; i++) {
	        int indice = geradorDeNumeroAleatorio.nextInt(CARACTERES.length());
	        senha.append(CARACTERES.charAt(indice));
	    }
	    return senha.toString();
	}

    @Override
    public void start(Stage palco) {

        palco.setTitle("Gerador de Senhas");

        Label labelTamanhoSenha = new Label("Tamanho da senha:");
        TextField campoTamanhoSenha = new TextField();
        campoTamanhoSenha.setMaxWidth(27);
        campoTamanhoSenha.setStyle("-fx-background-color: transparent;");
        campoTamanhoSenha.setText("25");  // Sugestão de tamanho de senha

        Label labelSenhaGerada = new Label("Senha gerada:");
        TextField campoSenhaGerada = new TextField();
        campoSenhaGerada.setAlignment(Pos.CENTER);
        campoSenhaGerada.setEditable(false);
		campoSenhaGerada.setStyle("-fx-background-color: transparent; -fx-font-weight: bold;");

        Button botaoGerar = new Button("Gerar Senha");
        botaoGerar.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        botaoGerar.setOnAction(_ -> {
            int tamanhoSenha;
			try {
				tamanhoSenha = Integer.parseInt(campoTamanhoSenha.getText());
				String senha = GeradorDeSenha.gerarSenha(tamanhoSenha); // Gero a senha
				campoSenhaGerada.setText(senha); // Mostro a senha gerada para o usuário
			} catch (NumberFormatException e) {
				campoSenhaGerada.setText("ERRO!");				
			} // Pego o tamanho desejado
        });

        VBox vBox = new VBox(labelTamanhoSenha, campoTamanhoSenha, botaoGerar, labelSenhaGerada, campoSenhaGerada);
        vBox.setStyle("-fx-background-color: rgb(122, 121, 121);");
        vBox.setSpacing(10); // Configura espaçamento entre os componentes
		vBox.setPadding(new Insets(10)); // Adiciona um espaçamento de 10 pixels em todas as bordas
		vBox.setAlignment(Pos.CENTER);
		
		palco.getIcons().add(new Image("file:E:\\Eclipse-WorkSpace\\icon.png"));
		Scene cena = new Scene(vBox, 300, 200);
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
