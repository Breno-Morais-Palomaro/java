package marinhos;

public class Polvo {

	private String nome;
	private int tentaculos;
	
	public Polvo(String nome, int tentaculos) {
		super();
		this.nome = nome;
		this.tentaculos = tentaculos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTentaculos() {
		return tentaculos;
	}
	
	public void setTentaculos(int tentaculos) {
		this.tentaculos = tentaculos;
	}
	
	public String toString() {
		return "Polvo:\nNome = " + nome + "\nNúmero de tentaculos = " + tentaculos;
	}
}
