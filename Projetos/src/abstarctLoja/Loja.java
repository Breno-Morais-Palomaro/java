package abstarctLoja;

abstract public class Loja {
	
	final private String CNPJ = "123.00001-23";
	final private String razaoSocial = "Loja do zé";
	@SuppressWarnings("unused")
	private boolean aberta;

	public String getCNPJ() {
		return CNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	boolean abrir() {
		return aberta = true;
	}
	
	boolean fechar() {
		return aberta = false;
	}
	
	String aberta() {
		if (aberta) {
			return "Loja esta aberta";
		} else {
			return "Loja está fechada";
		}
	}
}
