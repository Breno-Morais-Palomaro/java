/**
 * 
 */
/**
 * 
 */
module Projetos {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires org.junit.jupiter.api;
	requires transitive java.sql;
	requires java.net.http;
	requires org.json;
	
	exports sqlite2 to javafx.graphics;
	exports relogioDigital to javafx.graphics;
	exports geradorDeSenha to javafx.graphics;
	exports consumo to javafx.graphics;
	exports cliente to javafx.graphics;
	exports bhaskara to javafx.graphics;
	exports dadosClimatitos to javafx.graphics;
	exports listaDeCompras to javafx.graphics;
	exports sqlite;
	
	opens sqlite;
}