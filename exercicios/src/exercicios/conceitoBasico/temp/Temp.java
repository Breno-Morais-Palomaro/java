package exercicios.conceitoBasico.temp;

public class Temp {

	private double celsius;
	private double fahrenheit;
	private double kelvin;
	
	public Temp(double celsius, double fahrenheit, double kelvin) {
		super();
		this.celsius = celsius;
		this.fahrenheit = fahrenheit;
		this.kelvin = kelvin;
	}
	
	public double getCelsius() {
		return celsius;
	}
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	public double getFahrenheit() {
		return fahrenheit;
	}
	
	public void setFahrenheit(double fahrenheit) {
		this.fahrenheit = fahrenheit;
	}
	
	public double getKelvin() {
		return kelvin;
	}
	
	public void setKelvin(double kelvin) {
		this.kelvin = kelvin;
	}
}
