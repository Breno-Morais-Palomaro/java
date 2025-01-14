package exercicios.conceitoBasico.temp;

import javax.swing.JOptionPane;

public class Loop {
	private boolean running;

	public Loop() {
		super();
		this.running = true;
	}
	
	public void start(TempConverter converter) {		
		while(running) {
			String choseDigit = JOptionPane.showInputDialog("Escolha aconversão:\n"
					+ "1: °C => °F\n"
					+ "2: °C => K\n"
					+ "3: °F => °C\n"
					+ "4: °F => K\n"
					+ "5: K => °C\n"
					+ "6: K => °F\n"
					+ "0: sair");
			int chose = Integer.parseInt(choseDigit);
			switch (chose) {
			case 1:
				String tempDigit = JOptionPane.showInputDialog("Qual temperatura em °C vai ser convertida para °F:").replace(",", ".").trim();
				double temp = Double.parseDouble(tempDigit);
				double result = converter.cToF(temp);
				String resultToString = String.format("%.2f", result);
				JOptionPane.showMessageDialog(null, "A temperatura " + tempDigit + " °C é equivalente a " + resultToString + " °F");
				break;
			case 2:
				String tempDigit2 = JOptionPane.showInputDialog("Qual temperatura em °C vai ser convertida para K:").replace(",", ".").trim();
				double temp2 = Double.parseDouble(tempDigit2);
				double result2 = converter.cToK(temp2);
				String resultToString2 = String.format("%.2f", result2);
				JOptionPane.showMessageDialog(null, "A temperatura " + tempDigit2 + " °C é equivalente a " + resultToString2 + " K");
				break;
			case 3:
				String tempDigit3 = JOptionPane.showInputDialog("Qual temperatura em °F vai ser convertida para °C:").replace(",", ".").trim();
				double temp3 = Double.parseDouble(tempDigit3);
				double result3 = converter.fToC(temp3);
				String resultToString3 = String.format("%.2f", result3);
				JOptionPane.showMessageDialog(null, "A temperatura " + tempDigit3 + " °F é equivalente a " + resultToString3 + " °C");
				break;
			case 4:
				String tempDigit4 = JOptionPane.showInputDialog("Qual temperatura em °F vai ser convertida para K:").replace(",", ".").trim();
				double temp4 = Double.parseDouble(tempDigit4);
				double result4 = converter.fToK(temp4);
				String resultToString4 = String.format("%.2f", result4);
				JOptionPane.showMessageDialog(null, "A temperatura " + tempDigit4 + " °F é equivalente a " + resultToString4 + " K");
				break;
			case 5:
				String tempDigit5 = JOptionPane.showInputDialog("Qual temperatura em K vai ser convertida para °C:").replace(",", ".").trim();
				double temp5 = Double.parseDouble(tempDigit5);
				double result5 = converter.kToC(temp5);
				String resultToString5 = String.format("%.2f", result5);
				JOptionPane.showMessageDialog(null, "A temperatura " + tempDigit5 + " K é equivalente a " + resultToString5 + " °C");
				break;
			case 6:
				String tempDigit6 = JOptionPane.showInputDialog("Qual temperatura em K vai ser convertida para °F:").replace(",", ".").trim();
				double temp6 = Double.parseDouble(tempDigit6);
				double result6 = converter.kToF(temp6);
				String resultToString6 = String.format("%.2f", result6);
				JOptionPane.showMessageDialog(null, "A temperatura " + tempDigit6 + " K é equivalente a " + resultToString6 + " °F");
				break;
			case 0:
				running = false;
				JOptionPane.showMessageDialog(null, "Você escolheu sair!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalido, tente novamente!");
				break;
			}
		}
	}
}

	
		
	

