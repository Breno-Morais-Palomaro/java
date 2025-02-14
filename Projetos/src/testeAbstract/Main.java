package testeAbstract;

public class Main {

	public static void main(String[] args) {
		Retangulo r = new Retangulo(15, 10);
		System.out.println("A arean do retangulo é " + r.calcularArea());
		System.out.println("O perimetro do retangulo é " + r.calcularPerimetro());
	}
}
