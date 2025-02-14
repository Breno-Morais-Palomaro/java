package setImpares;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConjuntiImpares {

	public static void main(String[] args) {
		
		Set<Integer> nums = new HashSet<>(Arrays.asList(245, 732, 198, 854, 37, 489, 920, 1467, 604, 813));
		
		nums.forEach( numero -> {
			if (numero % 2 != 0) {
				System.out.println("Esse numero da coleção é impar: " + numero);
			} else if (numero % 2 == 0){
				System.out.println("Esse numero da coleção é par: " + numero);
			}
		});
	}
}
