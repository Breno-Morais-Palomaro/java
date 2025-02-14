package relogioDigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RelogioDigital extends Application{

	final DateTimeFormatter FORMATADOR = 
			DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		var rotuloTempo = new Label();
		rotuloTempo.setStyle(
				"-fx-font-size: 30pt; -fx-text-fill: yellow;");
		
		KeyFrame keyFrameAtualizar = 
				new KeyFrame(Duration.ZERO, _ -> {
					rotuloTempo
						.setText(LocalDateTime.now().format(FORMATADOR));
				});
		
		var keyFrameIntervalo = new KeyFrame(Duration.seconds(1));
		
		var relogio = new Timeline();
		relogio
			.getKeyFrames()
			.addAll(keyFrameAtualizar, 
					keyFrameIntervalo);
		
		relogio.setCycleCount(Animation.INDEFINITE);
		relogio.play();
		
		VBox vboxLayout = new VBox(rotuloTempo);
		vboxLayout.setAlignment(Pos.CENTER);
		vboxLayout.setStyle("-fx-background-color: black;");
		
		var cena = new Scene(vboxLayout, 245, 100);
		
		primaryStage.setTitle("Relógio Digital");
		primaryStage.setScene(cena);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
