package listaDeCompras;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProjetoListaDeCompras extends Application{

	private ArrayList<String> listaDeCompras = new ArrayList<>();
	private ListView<String> listaVisualizavel = new ListView<>(); // Para exibir os itens da lista
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Aplicativo de lista de compras");
		
		var textDescricaoItem = new TextField();
		var botaoAdicionar = new Button("Adicionar");
		var botaoexportar = new Button("Exportar");
		
		var labelAdicionar = new Label("Digite o item que deseja adicionar:");
		var labelListaDeCompras = new Label("Lista de compras:");
		
		// Criação do objeto ObervableList a partir da listaDeCompras.
		ObservableList<String> obsevableListaDeCompras = FXCollections.observableArrayList(listaDeCompras);
		listaVisualizavel.setItems(obsevableListaDeCompras);
		
		var vBox = new VBox(10
				, labelAdicionar
				, textDescricaoItem
				, botaoAdicionar
				, labelListaDeCompras
				, listaVisualizavel
				, botaoexportar);
		vBox.setPadding(new Insets(10));
		
		Runnable adicionar = () -> {
			String item = textDescricaoItem.getText();
			if (!item.isEmpty()) { // Entra no 'if' se o texto não está vazio (ou seja, se o usuario digitou algo).
				listaDeCompras.add(item);
				listaVisualizavel.getItems().add(item);
				textDescricaoItem.clear(); 
			}
		};
		
		botaoAdicionar.setOnAction(_-> adicionar.run());
		
		textDescricaoItem.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				adicionar.run();
			}
		});
		
		botaoexportar.setOnAction(_->{
			try {
				var arquivo = new File("listaDeCompras.txt");
				var writer = new PrintWriter(arquivo);
				for (String item : listaDeCompras) {
					writer.println(item); // Escrevemos cada item da lista no arquivo, adicionar uma nova linha para cada item
				}
				writer.close();
			} catch (Exception e) {
				System.out.println("Erro Ocorrido: " + e.getMessage());
			}
		});
		
		var cena = new Scene(vBox, 350, 300);
		primaryStage.setScene(cena);
		primaryStage.getIcons().add(new Image("file:E:\\Eclipse-WorkSpace\\icon.png"));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
