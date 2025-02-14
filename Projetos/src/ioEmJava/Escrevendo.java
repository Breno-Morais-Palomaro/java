package ioEmJava;

import java.io.*;

public class Escrevendo {

    public static void main(String[] args) throws IOException {
        
        try {
			FileWriter writer = new FileWriter("E:\\Eclipse-WorkSpace\\Projetos\\src\\ioEmJavameuArquivo.txt");
			
			writer.write("Olá, mundo!");
			writer.close(); // Fechando o FileWriter para liberar o recurso
			
			FileReader reader = new FileReader("E:\\Eclipse-WorkSpace\\Projetos\\src\\ioEmJavameuArquivo.txt");
			
			int data = reader.read();
			
			while (data != -1) {
			    System.out.print((char) data);
			    
			    data = reader.read();
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Aquivo foi apagado! " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Problemas de IO: " + e.getMessage());
		}
    }
}
