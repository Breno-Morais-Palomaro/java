package veiculosPolimorficos;

public class Main {

	public static void main(String[] args) {
		
		Veiculo oni = new Onibus(25);
		oni.setAno(2025);
		oni.setPlaca("123D25");
		
		Veiculo cami = new Caminhao(4);
		cami.setAno(1996);
		cami.setPlaca("COC-6616");
		
		System.out.println("Onibus:");
		oni.exibirInformacoes();
		
		System.out.println();
		
		System.out.println("Caminhão:");
		cami.exibirInformacoes();
	}
}
