package exercicios.conceitoBasico.temp;

public class TempConverter {
    public double cToF(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public double cToK(double celsius) {
    	return celsius + 273.15;
    }
    
    public double fToC(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    public double fToK(double fahrenheit) {
    	return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    public double kToC(double kelvin) {
        return kelvin - 273.15;
    }
    
    public double kToF(double kelvin) {
    	return (kelvin - 273.15) * 9 / 5 + 32;
    }
}
