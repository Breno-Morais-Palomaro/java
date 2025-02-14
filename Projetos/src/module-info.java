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
	
	exports sqlite2 to javafx.graphics;
	exports relogioDigital to javafx.graphics;
	exports geradorDeSenha to javafx.graphics;
	exports consumo to javafx.graphics;
	exports cliente to javafx.graphics;
	exports bhaskara to javafx.graphics;
	exports sqlite;
	
	opens sqlite;
}