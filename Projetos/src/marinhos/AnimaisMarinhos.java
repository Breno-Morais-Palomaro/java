package marinhos;

public class AnimaisMarinhos {

	public static void main(String[] args) {
		
		Cesto<Peixe> cestoDePeixe = new Cesto<>();
		Peixe peixe = new Peixe("nemo", 6.5);
		
		Cesto<Polvo> cestoPolvo = new Cesto<>();
		Polvo polvo = new Polvo("Dave", 8);
		
		cestoDePeixe.setConteudo(peixe);
		cestoPolvo.setConteudo(polvo);
		
		System.out.println(cestoDePeixe.getConteudo());
		System.out.println();
		System.out.println(cestoPolvo.getConteudo());
	}
}
