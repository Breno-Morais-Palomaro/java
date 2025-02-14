package bhaskara;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        // ax² + bx + c = 0
        
        var texta = new TextField();
        texta.setMaxWidth(30);
        texta.setText("0");
        texta.setStyle("-fx-background-color: rgba(0,0,0,0);");
        var labelx2 = new Label("X² +");
        
        var textb = new TextField();
        textb.setMaxWidth(30);
        textb.setText("0");
        textb.setStyle("-fx-background-color: rgba(0,0,0,0);");
        var labelbx = new Label("X +");
        
        var textc = new TextField();
        textc.setMaxWidth(30);
        textc.setText("0");
        textc.setStyle("-fx-background-color: rgba(0,0,0,0);");
        var label0 = new Label("= 0");
        
        var labelResul = new Label("");
        
        var botao = new Button("Calcular");
        botao.setOnAction(_ -> {
            try {
				double a = Double.parseDouble(texta.getText().trim().replace(",", "."));                
				double b = Double.parseDouble(textb.getText().trim().replace(",", "."));
				double c = Double.parseDouble(textc.getText().trim().replace(",", "."));
				
				FormulaBhaskara formula = new FormulaBhaskara(a, b, c);
				
				if (a == 0 && b > 0 && c != 0) {
				    double x = formula.primeiroGrau();
				    String xString = String.format("%.2f", x);
				    
				    labelResul.setText("Essa é uma equação de primeiro grau, o resultado é:\n" + xString);
				    
				} else if (a > 0 && b == 0 && c != 0) {
				    if (c / a < 0) {
				        double x1 = formula.equacaoImcompletaPositivo();
				        double x2 = -x1;                        
				        String x1String = String.format("%.2f", x1);
				        String x2String = String.format("%.2f", x2);
				        labelResul.setText("Essa é uma equação de segundo grau incompleta!\nOs resultados são:\nx1 = " + x1String + "\nx2 = " + x2String);                        
				    } else if (c / a == 0) {
				        labelResul.setText("Solução: x = 0");
				    } else {
				        labelResul.setText("Não há soluções reais");                        
				    }
				    
				} else if (a > 0 && b != 0 && c == 0) {
				    double x = formula.incompleta();
				    String xString = String.format("%.2f", x);
				    
				    labelResul.setText("Essa é uma equação de segundo grau incompleta.\nO resultado é\nx = " + xString);
				} else {
				    double delta = formula.delta();
				    
				    if (delta > 0) {
				        double x1 = formula.deltaMaiorZeroPositivo();
				        String x1String = String.format("%.2f", x1);
				        double x2 = formula.deltaMaiorZeroNegativo();
				        String x2String = String.format("%.2f", x2);
				        
				        labelResul.setText("x1 = " + x1String + "\nx2 = " + x2String);
				    } else if (delta == 0) {
				        double x = formula.deltaIgualZero();
				        String xString = String.format("%.2f", x);
				        
				        labelResul.setText("x = " + xString);
				    } else {
				        labelResul.setText("Essa equação não possui raízes reais");
				    }
				}
			} catch (NumberFormatException e) {
				labelResul.setText("Número invalido!\n" + e.getMessage());
			}
        });
        
        var boxConteudo = new HBox(texta, labelx2, textb, labelbx, textc, label0);
        boxConteudo.setAlignment(Pos.CENTER);
        
        var boxResul = new VBox(10, botao, labelResul);
        boxResul.setAlignment(Pos.CENTER);
        
        var boxPrincipal = new VBox(25, boxConteudo, boxResul);
        
        var cena = new Scene(boxPrincipal, 350, 160);
        
        primaryStage.setScene(cena);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
