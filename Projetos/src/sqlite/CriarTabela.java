package sqlite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {

	public static void main(String[] args) {
		try (Connection conexao = ConexaoDB.conectar();
				Statement stmt = conexao.createStatement()) {
			
			// Definindo o comando SQL para criar a tabela
			String comandoSql = "CREATE TABLE produtos (" +
					"id_produto INTEGER PRIMARY KEY," +
					"nome_produto TEXT NOT NULL," +
					"Preco REAL," +
					"status TEXT" +
					");";
			System.out.println(comandoSql);
			
			// Executando o comando SQL
			stmt.execute(comandoSql);
			
			System.out.println("Tabela 'Produtos' criado com sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao criar a tabela: " + e.getMessage());
			e.printStackTrace(); // Sequencia de métodos chamados que deu errado
			
		}
	}
}
