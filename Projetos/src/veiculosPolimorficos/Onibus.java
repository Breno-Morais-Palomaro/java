package veiculosPolimorficos;

public class Onibus extends Veiculo{

	private int assentos;
	
	public Onibus(int assentos) {
		super();
		this.assentos = assentos;
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	
	@Override
	public void exibirInformacoes() {
		super.exibirInformacoes();
		System.out.println("Assentos: " + assentos);
	}
}
