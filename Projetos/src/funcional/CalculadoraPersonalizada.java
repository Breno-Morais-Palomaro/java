package funcional;

public class CalculadoraPersonalizada {
	
	public static void main(String[] args) {
		
		OperacaoMatematica potencia = (a, b) -> Math.pow(a, b);
		System.out.println(potencia.executar(2, 2));
		
		OperacaoMatematica raiz = (a, b) -> Math.sqrt(a + b);
		System.out.println(raiz.executar(72, 72));
	}
}
