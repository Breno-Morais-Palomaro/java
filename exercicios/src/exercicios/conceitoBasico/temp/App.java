package exercicios.conceitoBasico.temp;

public class App {

	public static void main(String[] args) {
		
		TempConverter converter = new TempConverter(); 
		Loop loop = new Loop();
		loop.start(converter);
	}
}
