package colecoes;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

	public static void main(String[] args) {
		int subtracao = 1;
		
		Map<String, Integer> produto = new HashMap<>();
		
		produto.put("123.55", 25);
		produto.put("123.44", 5);
		produto.put("123.66", 2);
		produto.put("123.11", 14);
		produto.put("123.22", 1);
		produto.put("123.33", null);
		
		System.out.println("quantidade no estoque: " + produto.get("123.55"));
		int valor = produto.get("123.55");
		valor = valor - subtracao;
		produto.put("123.55", valor);
		System.out.println("quantidade no estoque: " + produto.get("123.55"));
	}
}
