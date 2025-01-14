package exercicios.conceitoBasico.IMC;

import javax.swing.JOptionPane;

public class Loop {

	private boolean running;

	public Loop() {
		super();
		this.running = true;
	}
	
	public void start() {
		
		while(running) {
			String name = JOptionPane.showInputDialog("Digite o nome:").trim();
			
			String digitWeight = JOptionPane.showInputDialog("Digite o peso da pessoa:").replace(",", ".").trim();
			double weight = Double.parseDouble(digitWeight);
			
			String digitHeight = JOptionPane.showInputDialog("Digite a altura da pessoa:").replace(",", ".").trim();
			double height = Double.parseDouble(digitHeight);
			
			double imc = Calc.calcIMC(weight, height);
			String imcToString = String.format("%.2f", imc);
			
			JOptionPane.showMessageDialog(null, "O IMC de " + name + " é " + imcToString);
			
			 int chose = JOptionPane.showConfirmDialog(null, "Continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);
			 
			 if(chose == JOptionPane.YES_OPTION) {
				 
			 } else if(chose == JOptionPane.NO_OPTION){
				 running = false;
			 } else if(chose == JOptionPane.CLOSED_OPTION) {
				 running = false;
			 }
		}		
	}
}
