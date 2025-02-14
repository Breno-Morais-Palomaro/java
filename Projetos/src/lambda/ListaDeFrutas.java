package lambda;

import java.util.ArrayList;
import java.util.List;

public class ListaDeFrutas {

	public static void main(String[] args) {
		
		List<String> frutas = new ArrayList<>();
		
		frutas.add("maça");
		frutas.add("banana");
		frutas.add("cereja");
		frutas.add("abacaxi");
		
		frutas.removeIf(s -> s.length() > 5);
		
		frutas.add(0, "uva");
		
		frutas.forEach(System.out::println);
	}
}
