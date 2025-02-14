package colecoes;

import java.util.ArrayList;
import java.util.List;

public class Filmes {

	public static void main(String[] args) {
		
		List<String> filmes2025 = new ArrayList<>();
		
		filmes2025.add("Nosferatu");
		filmes2025.add("Babygirl");
		filmes2025.add("Pequenas Coisas Como Estas");
		filmes2025.add("Maria Callas");		
		filmes2025.add("Lobisomem");		
		filmes2025.add("Conclave");		
		filmes2025.add("Paddington: Uma Aventura na Floresta");		
		filmes2025.add("A Verdadeira Dor");		
		filmes2025.add("Acompanhante Perfeita");		
		filmes2025.add("Covil dos Ladrões 2");		
		filmes2025.add("Emilia Pérez");		
		filmes2025.add("Capitão América: Admirável Novo Mundo");		
		filmes2025.add("Sing Sing");		
		filmes2025.add("O Brutalista");		
		filmes2025.add("Um Completo Desconhecido");		
		filmes2025.add("Mickey 17");		
		filmes2025.add("Better Man: A História de Robbie Williams");		
		filmes2025.add("Vitória");		
		filmes2025.add("Código Preto");		
		filmes2025.add("Branca de Neve");		
		filmes2025.add("Um Filme Minecraft");		
		filmes2025.add("Operação Vingança");
		
		System.out.println("Esse filme está na lista: Um Filme Minecraft - " + filmes2025.contains("Um Filme Minecraft"));
		System.out.println("Filmes para serem lançados em 2025: " + filmes2025);
	}
}
