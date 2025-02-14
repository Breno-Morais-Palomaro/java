package serializacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serializacao {
    // Método para serializar os contatos
    private static void serializarContatos(List<Contatos> listaContatos) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("E:\\Eclipse-WorkSpace\\Projetos\\src\\serializacao\\contatos\\agenda.ser"))) {
            outputStream.writeObject(listaContatos);
            System.out.println("Contatos serializados e salvos com sucesso!");
        }
    }
    
    // Método para deserializar e exibir os contatos
    private static void deserializarContatos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("E:\\Eclipse-WorkSpace\\Projetos\\src\\serializacao\\contatos\\agenda.ser"))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List<?>) {
                List<?> listaGenerica = (List<?>) obj;
                if (!listaGenerica.isEmpty() && listaGenerica.get(0) instanceof Contatos) {
                    @SuppressWarnings("unchecked")
                    List<Contatos> contatosLidos = (List<Contatos>) listaGenerica;
                    for (Contatos contato : contatosLidos) {
                        System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getNumero());
                    }
                } else {
                    System.out.println("O conteúdo da lista não é do tipo Contatos.");
                }
            } else {
                System.out.println("O objeto lido não é uma lista.");
            }
        }
    }
    
    
    public static void main(String[] args) {
        Contatos contato1 = new Contatos("Breno", "(11) 91555-0818");
        Contatos contato2 = new Contatos("Ciclano", "(12) 34567-8910");
        Contatos contato3 = new Contatos("Beotrano", "(11) 4002-8922");
        
        List<Contatos> listaContatos = new ArrayList<>();
        listaContatos.add(contato1);
        listaContatos.add(contato2);
        listaContatos.add(contato3);
        
        try {
            serializarContatos(listaContatos);
            deserializarContatos();
        } catch (IOException e) {
            System.out.println("Erro de IO ao manipular contatos: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe não encontrada ao manipular contatos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
