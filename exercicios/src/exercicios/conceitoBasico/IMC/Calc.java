package exercicios.conceitoBasico.IMC;

public class Calc {

	public static double calcIMC(double peso, double altura) {
		return peso / Math.pow(altura, 2);
	}
}
