package testeAbstract;

public class Retangulo extends FiguraGeometrica{

	private double altura;
	private double largura;
	
	public Retangulo(double altura, double largura) {
		super();
		this.altura = altura;
		this.largura = largura;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getLargura() {
		return largura;
	}
	
	public void setLargura(double largura) {
		this.largura = largura;
	}
	
	@Override
	double calcularArea() {
		return altura * largura;
	}
	
	@Override
	double calcularPerimetro() {
		return 2 * (altura + largura);
	}
}
