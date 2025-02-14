package bhaskara;

public class FormulaBhaskara {

    private double a;
    private double b;
    private double c;

    public FormulaBhaskara() {}

    public FormulaBhaskara(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double delta() {
        return b * b - 4 * a * c;
    }

    public double deltaMaiorZeroPositivo() {
        return (-b + Math.sqrt(delta())) / (2 * a);
    }

    public double deltaMaiorZeroNegativo() {
        return (-b - Math.sqrt(delta())) / (2 * a);
    }

    public double deltaIgualZero() {
        return -b / (2 * a);
    }
    
    public double primeiroGrau() {
    	double x = 0;
    	
    	x = -(c / b);
    	
    	return x;
    }
    
    public double equacaoImcompletaPositivo() {
    	double x = 0;
    	 
    	x = Math.sqrt(-(c/a));
    	
    	return x;
    }
    
    public double incompleta() {
    	double x = 0;
    	
    	x = -(a / b);
    	
    	return x;
    }
}
