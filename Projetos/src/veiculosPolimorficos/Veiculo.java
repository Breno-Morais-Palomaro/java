package veiculosPolimorficos;

public class Veiculo {

	private String placa;
	private int ano;
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void exibirInformacoes() {
		System.out.println("Placa: " + placa);
		System.out.println("Ano: " + ano);
	}
}
