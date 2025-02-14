package marinhos;

public class Peixe {

	private String nome;
	private Double tamanho;
	
	public Peixe(String nome, Double tamanho) {
		super();
		this.nome = nome;
		this.tamanho = tamanho;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}
	
	@Override
    public String toString() {
        return "Peixe:\nNome = " + nome + "\nTamanho = " + tamanho;
    }
}
