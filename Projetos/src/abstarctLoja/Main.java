package abstarctLoja;

public class Main {

	public static void main(String[] args) {
		
		LojaDoZe loja = new LojaDoZe();
		loja.abrir();
		System.out.println(loja.aberta());
		
		loja.fechar();
		System.out.println(loja.aberta());
		
		System.out.println("CNPJ: " + loja.getCNPJ());
		System.out.println("Razão social: " + loja.getRazaoSocial());
	}
}
