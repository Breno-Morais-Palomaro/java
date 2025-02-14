package veiculosPolimorficos;

public class Caminhao extends Veiculo{

	private int eixos;

	public Caminhao(int eixos) {
		super();
		this.eixos = eixos;
	}

	public int getEixos() {
		return eixos;
	}

	public void setEixos(int eixos) {
		this.eixos = eixos;
	}
	
	@Override
	public void exibirInformacoes() {
		super.exibirInformacoes();
		System.out.println("Eixos: " + eixos);
	}
}
