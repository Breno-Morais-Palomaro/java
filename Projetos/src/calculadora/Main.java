package calculadora;

public class Main {

	public static void main(String[] args) {
		
		Operacao div = new Divisao();
		System.out.println(div.calcular(10, 2));
		
		Operacao soma = new Soma();
		System.out.println(soma.calcular(5, 5));
	}
}
