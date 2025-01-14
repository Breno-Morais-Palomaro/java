package exercicios.conceitoBasico.quadradoCubo;

import javax.swing.JOptionPane;

public class Loop {

	private boolean loop = true;

	public Loop() {
		super();
		this.setLoop(true);
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	
	void start() {
		while(loop) {
			String numDigit = JOptionPane.showInputDialog("Digite um número para saber seu quadrado e cubo").replace(",", ".");
			double num = Double.parseDouble(numDigit);
			
			double numQuadrado = Calc.calcQuadrado(num);
			double numCubo = Calc.calcCubo(num);
			
			String numQuadradoToString = String.format("%.2f", numQuadrado);
			String numCuboToString = String.format("%.2f", numCubo);
			
			JOptionPane.showMessageDialog(null, "O quadrado de " + num + " é igual a " + numQuadradoToString + 
					" e o seu cubo é igual a " + numCuboToString);
			
			int chose = JOptionPane.showConfirmDialog(null, "Continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);
			
			if(chose == JOptionPane.YES_OPTION) {
				
			} else if(chose == JOptionPane.NO_OPTION) {
				loop = false;
			} else if(chose == JOptionPane.CLOSED_OPTION) {
				loop = false;
			}
		}
		
	}
}
